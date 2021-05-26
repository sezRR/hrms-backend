package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CandidateUser;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateUserDao extends UserDao<CandidateUser> {
    boolean existsByIdentityNumber(String identityNumber);
}
