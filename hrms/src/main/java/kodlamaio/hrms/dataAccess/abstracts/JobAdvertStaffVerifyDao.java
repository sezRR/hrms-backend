package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobAdvertStaffVerify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertStaffVerifyDao extends JpaRepository<JobAdvertStaffVerify, Integer> {
    @Query("FROM JobAdvertStaffVerify where staffUser IS NULL")
    List<JobAdvertStaffVerify> getByStaffUserIsNull();
}
