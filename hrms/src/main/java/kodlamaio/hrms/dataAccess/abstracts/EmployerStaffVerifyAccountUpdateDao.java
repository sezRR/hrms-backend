package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.EmployerStaffVerifyAccountUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerStaffVerifyAccountUpdateDao extends JpaRepository<EmployerStaffVerifyAccountUpdate, Integer> {
}
