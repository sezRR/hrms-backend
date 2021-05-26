package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateUser;

import java.util.List;

public interface CandidateUserService {
    DataResult<List<CandidateUser>> getAll();

    Result add(CandidateUser candidateUser);
}
