package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.FavoriteJobAdvert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteJobAdvertDao extends JpaRepository<FavoriteJobAdvert, Integer> {
    List<FavoriteJobAdvert> findAllByCandidateUser_Id(int candidateUserId);
}
