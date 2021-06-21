package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateUserService;
import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.business.concretes.checkHelper.UserCheckHelper;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.validationRules.CandidateUserValidatorService;
import kodlamaio.hrms.core.adapters.mernis.UserCheckService;
import kodlamaio.hrms.core.utilities.business.BusinessEngine;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CandidateUserDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.CandidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateUserManager extends UserManager<CandidateUser> implements CandidateUserService  {

    private final CandidateUserDao candidateUserDao;
    private final CandidateUserValidatorService candidateUserValidatorService;
    private final UserCheckService userCheckService;
    private final EmailService emailService;

    @Autowired
    public CandidateUserManager(UserDao<CandidateUser> userDao, CandidateUserValidatorService candidateUserValidatorService, UserCheckService userCheckService, EmailService emailService) {
        super(userDao);
        this.candidateUserDao = (CandidateUserDao) userDao;
        this.candidateUserValidatorService = candidateUserValidatorService;
        this.userCheckService = userCheckService;
        this.emailService = emailService;
    }

    @Override
    public DataResult<List<CandidateUser>> getAll() {
        return new SuccessDataResult<>(this.candidateUserDao.findAll(), Messages.usersListed);
    }

    @Override
    public Result add(CandidateUser candidateUser) {
        List<Result> results = new ArrayList<>();

        results.add(BusinessEngine.run(this.checkUserRealOrNot(candidateUser.getIdentityNumber(), candidateUser.getFirstName(), candidateUser.getLastName(), candidateUser.getDateOfBirth())));
        results.add(BusinessEngine.run(super.existsByEmail(candidateUser.getEmail())));
        results.add(BusinessEngine.run(this.checkIdentityNumber(candidateUser.getIdentityNumber())));
        results.add(BusinessEngine.run(this.candidateUserValidatorService.candidateUserCheckFields(candidateUser)));

        Result result = UserCheckHelper.checkLogicResults(results);

        if (!result.isSuccess()){
            return new ErrorResult(result.getMessage());
        }

        this.candidateUserDao.save(candidateUser);
        return new SuccessResult(this.emailService.sendEmail(candidateUser).getMessage());
    }

    public Result checkUserRealOrNot(String identityNumber, String firstName, String lastName, LocalDate dateOfBirthYear) {
        var logic = this.userCheckService.checkIfRealPerson(identityNumber, firstName, lastName, dateOfBirthYear);

        if (!logic){
            return new ErrorResult(Messages.notRealPerson);
        }

        return new SuccessResult(Messages.validationSuccess);
    }

    public Result checkIdentityNumber(String identityNumber) {
        var logic = this.candidateUserDao.existsByIdentityNumber(identityNumber);

        if (logic){
            return new ErrorResult(Messages.identityNumberExist);
        }

        return new SuccessResult(Messages.validationSuccess);
    }
}
