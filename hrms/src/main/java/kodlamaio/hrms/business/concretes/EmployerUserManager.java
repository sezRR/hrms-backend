package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.business.abstracts.EmployerUserService;
import kodlamaio.hrms.business.concretes.checkHelper.UserCheckHelper;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.validationRules.EmployerUserValidatorService;
import kodlamaio.hrms.core.utilities.business.BusinessEngine;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerUserDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.EmployerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerUserManager extends UserManager<EmployerUser> implements EmployerUserService {

    private final EmployerUserDao employerUserDao;
    private final EmployerUserValidatorService employerUserValidatorService;
    private final EmailService emailService;

    @Autowired
    public EmployerUserManager(UserDao<EmployerUser> userDao, EmployerUserValidatorService employerUserValidatorService, EmailService emailService) {
        super(userDao);
        this.employerUserDao = (EmployerUserDao) userDao;
        this.employerUserValidatorService = employerUserValidatorService;
        this.emailService = emailService;
    }

    @Override
    public DataResult<List<EmployerUser>> getAll() {
        return new SuccessDataResult<>(this.employerUserDao.findAll(), Messages.usersListed);
    }

    @Override
    public Result add(EmployerUser employerUser) {
        List<Result> results = new ArrayList<>();

        results.add(BusinessEngine.run(super.existsByEmail(employerUser.getEmail())));
        results.add(BusinessEngine.run(this.employerUserValidatorService.employerUserCheckFields(employerUser)));
        results.add(BusinessEngine.run(this.employerUserValidatorService.isEmailDomainCheck(employerUser)));

        Result result = UserCheckHelper.checkLogicResults(results);

        if (!result.isSuccess()){
            return new ErrorResult(result.getMessage());
        }

        this.employerUserDao.save(employerUser);
        return new SuccessResult(this.emailService.sendEmail(employerUser).getMessage());
    }
}
