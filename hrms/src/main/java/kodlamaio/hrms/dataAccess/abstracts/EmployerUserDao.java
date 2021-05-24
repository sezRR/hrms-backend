package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.EmployerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployerUserDao extends JpaRepository<EmployerUser, Integer> {
    List<EmployerUser> findByEmailIs(String email);
}
