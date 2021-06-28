package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.StaffUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffUserDao extends JpaRepository<StaffUser, Integer> {
    StaffUser getById(int id);
}
