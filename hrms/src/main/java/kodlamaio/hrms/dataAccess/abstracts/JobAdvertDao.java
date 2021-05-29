package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobAdvert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
    @Query("FROM JobAdvert where isActive = true")
    List<JobAdvert> getByActiveIs();

    @Query("FROM JobAdvert where isActive = true and employer.id=:employerId")
    List<JobAdvert> getByActiveIsAndEmployer_Id(int employerId);
}
