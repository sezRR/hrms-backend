package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
    List<JobPosition> findByPosition(String position);
}
