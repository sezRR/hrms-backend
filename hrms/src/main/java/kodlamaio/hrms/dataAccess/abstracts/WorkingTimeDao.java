package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.WorkingTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkingTimeDao extends JpaRepository<WorkingTime, Integer> {
    @Query("SELECT id FROM WorkingTime")
    List<Integer> getAllWorkingTimeId();
}
