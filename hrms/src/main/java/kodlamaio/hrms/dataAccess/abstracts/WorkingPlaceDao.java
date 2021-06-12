package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.WorkingPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingPlaceDao extends JpaRepository<WorkingPlace, Integer> {

}
