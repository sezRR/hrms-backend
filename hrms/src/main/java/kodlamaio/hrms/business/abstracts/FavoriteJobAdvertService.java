package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.FavoriteJobAdvert;
import kodlamaio.hrms.entities.dtos.FavoriteJobAdvertAddDto;

import java.util.List;

public interface FavoriteJobAdvertService {
    DataResult<List<FavoriteJobAdvert>> getAll();
    DataResult<List<FavoriteJobAdvert>> getAllByCandidateUser(int candidateUserId);

    Result add(FavoriteJobAdvertAddDto favoriteJobAdvertAddDto);
}
