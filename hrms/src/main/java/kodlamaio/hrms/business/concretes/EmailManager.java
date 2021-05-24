package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.User;
import org.springframework.stereotype.Component;

@Component
public class EmailManager implements EmailService {
    @Override
    public Result sendEmail(User user) {
        return new SuccessResult("Email was sent successfully to: " + user.getEmail());
    }
}
