package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.FavoriteJobAdvertService;
import kodlamaio.hrms.core.utilities.converter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.FavoriteJobAdvertDao;
import kodlamaio.hrms.entities.concretes.FavoriteJobAdvert;
import kodlamaio.hrms.entities.dtos.FavoriteJobAdvertAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FavoriteJobAdvertManager implements FavoriteJobAdvertService {
    private final FavoriteJobAdvertDao favoriteJobAdvertDao;
    private final DtoConverterService dtoConverterService;

    @Autowired
    public FavoriteJobAdvertManager(FavoriteJobAdvertDao favoriteJobAdvertDao, DtoConverterService dtoConverterService) {
        this.favoriteJobAdvertDao = favoriteJobAdvertDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public DataResult<List<FavoriteJobAdvert>> getAll() {
        return new SuccessDataResult<>(this.favoriteJobAdvertDao.findAll());
    }

    @Override
    public DataResult<List<FavoriteJobAdvert>> getAllByCandidateUser(int candidateUserId) {
        return new SuccessDataResult<>(this.favoriteJobAdvertDao.findAllByCandidateUser_Id(candidateUserId));
    }

    @Override
    public Result add(FavoriteJobAdvertAddDto favoriteJobAdvertAddDto) {
        FavoriteJobAdvert favoriteJobAdvert = (FavoriteJobAdvert) this.dtoConverterService.dtoToBaseClassConverter(favoriteJobAdvertAddDto, FavoriteJobAdvert.class);
        favoriteJobAdvert.setCreatedDate(LocalDate.now());
        this.favoriteJobAdvertDao.save(favoriteJobAdvert);
        return new SuccessResult("Added");
    }
}
