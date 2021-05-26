package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.CandidateUser;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CandidateUserValidator extends UserValidator implements CandidateUserValidatorService {
    @Override
    public Result candidateUserCheckFields(CandidateUser candidateUser) {

        String firstName = candidateUser.getFirstName();
        String lastName = candidateUser.getLastName();
        String identityNumber = candidateUser.getIdentityNumber();
        LocalDate dateOfBirth = candidateUser.getDateOfBirth();

        if (!super.userCheckFields(candidateUser).isSuccess()
                || (firstName == null || firstName.isBlank())
                || (lastName == null || lastName.isBlank())
                || (identityNumber == null || identityNumber.isBlank() || identityNumber.length() != 11)
                || (dateOfBirth == null || dateOfBirth.toString().isBlank()))
        {
            return new ErrorResult(Messages.userFieldsInvalid);
        }

        return new SuccessResult();
    }
}
