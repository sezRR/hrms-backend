package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityDao extends JpaRepository<City, Integer> {
    @Query("SELECT id FROM City")
    List<Integer> getAllCityId();
}
