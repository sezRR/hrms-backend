package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.WorkingTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingTimeDao extends JpaRepository<WorkingTime, Integer> {

}
