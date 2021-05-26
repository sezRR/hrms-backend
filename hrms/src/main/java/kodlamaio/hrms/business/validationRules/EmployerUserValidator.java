package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.EmployerUser;
import org.springframework.stereotype.Component;

@Component
public class EmployerUserValidator extends UserValidator implements EmployerUserValidatorService {
    @Override
    public Result employerUserCheckFields(EmployerUser employerUser) {

        String companyName = employerUser.getCompanyName();
        String webAddress = employerUser.getWebAddress();
        String phoneNumber = employerUser.getPhoneNumber();

        if (!super.userCheckFields(employerUser).isSuccess()
                || (companyName == null || companyName.isBlank())
                || (webAddress == null || webAddress.isBlank())
                || (phoneNumber == null || phoneNumber.isBlank()))
        {
            return new ErrorResult(Messages.userFieldsInvalid);
        }

        return new SuccessResult();
    }

    @Override
    public Result isEmailDomainCheck(EmployerUser employerUser) {
        String email = employerUser.getEmail();
        String webAddress = employerUser.getWebAddress();

        String domain = webAddress.split("www.")[1];

        if (domain.equals(email.split("@")[1])){
            return new SuccessResult();
        }

        return new ErrorResult(Messages.employerEmailInvalid);
    }
}
