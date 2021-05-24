package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CandidateUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateUserDao extends JpaRepository<CandidateUser, Integer> {
    List<CandidateUser> findByEmailIs(String email);
    List<CandidateUser> findByIdentityNumberIs(String identityNumber);
}
