package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.customEntity.JobAdvertFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
    @Query("FROM JobAdvert where isActive = true ORDER BY id")
    List<JobAdvert> getByActiveIs();

    @Query("FROM JobAdvert jobAdvert WHERE " +
            "((:#{#jfilter.cities}) IS NULL OR jobAdvert.city.id IN (:#{#jfilter.cities})) and " +
            "((:#{#jfilter.workingTimes}) IS NULL OR jobAdvert.workingTime.id IN (:#{#jfilter.workingTimes})) and " +
            "((:#{#jfilter.workingPlaces}) IS NULL OR jobAdvert.workingPlace.id IN (:#{#jfilter.workingPlaces})) and " +
            "jobAdvert.isActive = true ORDER BY jobAdvert.id")
    Page<JobAdvert> getByActiveIs(Pageable pageable, @Param("jfilter") JobAdvertFilter jobAdvertFilter);

    @Query("FROM JobAdvert where isActive = true and employer.id=:employerId")
    List<JobAdvert> getByActiveIsAndEmployer_Id(int employerId);
}
