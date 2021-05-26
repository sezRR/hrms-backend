package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerUser;

public interface EmployerUserValidatorService {
    Result employerUserCheckFields(EmployerUser employerUser);
    Result isEmailDomainCheck(EmployerUser employerUser);
}
