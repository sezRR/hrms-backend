package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateUser;

public interface CandidateUserValidatorService {
    Result candidateUserCheckFields(CandidateUser candidateUser);
}
