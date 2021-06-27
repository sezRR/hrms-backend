package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.FavoriteJobAdvertService;
import kodlamaio.hrms.core.utilities.business.BusinessEngine;
import kodlamaio.hrms.core.utilities.converter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.*;
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
    public DataResult<FavoriteJobAdvert> add(FavoriteJobAdvert favoriteJobAdvert) {

        var result = BusinessEngine.run(this.checkIsExist(favoriteJobAdvert.getCandidateUser().getId(), favoriteJobAdvert.getJobAdvert().getId()));
        if (result != null){
            return new ErrorDataResult<>("This job advert already exists in your favorite job adverts.");
        }

        favoriteJobAdvert.setCreatedDate(LocalDate.now());
        this.favoriteJobAdvertDao.save(favoriteJobAdvert);

        return new SuccessDataResult<>(favoriteJobAdvert, "Job Advert added to favorites successfully");
    }

    @Override
    public Result delete(int favoriteJobAdvertId) {
        this.favoriteJobAdvertDao.delete(this.favoriteJobAdvertDao.getOne(favoriteJobAdvertId));
        return new SuccessResult("Job Advert removed from your favorites successfully");
    }

    public Result checkIsExist(int candidateUserId, int favoriteJobAdvertId){
        boolean isExist = this.favoriteJobAdvertDao.existsByCandidateUser_IdAndJobAdvert_Id(candidateUserId, favoriteJobAdvertId);

        if (isExist){
            return new ErrorResult("This job advert already exists in your favorite job adverts.");
        }

        return new SuccessResult();
    }
}
