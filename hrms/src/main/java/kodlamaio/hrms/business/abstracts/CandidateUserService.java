package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateUser;

import java.time.LocalDate;
import java.util.List;

public interface CandidateUserService {
    DataResult<List<CandidateUser>> getAll();
    DataResult<List<CandidateUser>> findByEmailIs(String email);
    DataResult<List<CandidateUser>> findByIdentityNumberIs(String identityNumber);

    DataResult<Boolean> checkIfRealPerson(String nationalityId, String firstName, String lastName, LocalDate dateOfBirthYear);

    Result add(CandidateUser candidateUser);
}
