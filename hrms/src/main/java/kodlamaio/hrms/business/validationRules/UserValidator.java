package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.User;

public abstract class UserValidator {
    public Result userCheckFields(User user){
        String email = user.getEmail();
        String password = user.getPassword();

        if ((email == null || email.isBlank()) || (password == null || password.isBlank())){
            return new ErrorResult(Messages.userFieldsInvalid);
        }

        return new SuccessResult();
    }
}
