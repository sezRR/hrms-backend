package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.converter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JobAdvertManager implements JobAdvertService {

    private final JobAdvertDao jobAdvertDao;
    private final DtoConverterService dtoConverterService;

    @Autowired
    public JobAdvertManager(JobAdvertDao jobAdvertDao, DtoConverterService dtoConverterService) {
        this.jobAdvertDao = jobAdvertDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public DataResult<List<JobAdvert>> getAll() {
        return new SuccessDataResult<>(this.jobAdvertDao.findAll(), Messages.jobAdvertsListed);
    }

    @Override
    public DataResult<List<JobAdvert>> getByActiveIsWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        return new SuccessDataResult<>(this.jobAdvertDao.getByActiveIs(pageable).getContent());
    }

    @Override
    public DataResult<List<JobAdvert>> getByActiveIsWithCityFiltering(int pageNo, int pageSize, int... cityIds) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        return new SuccessDataResult<>(this.jobAdvertDao.getByActiveIsWithCityFiltering(pageable, cityIds).getContent());
    }

    @Override
    public DataResult<List<JobAdvert>> getByActiveIsAndWorkingTimeFiltering(int pageNo, int pageSize, int... workingTimes) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        return new SuccessDataResult<>(this.jobAdvertDao.getByActiveIsAndWorkingTimeFiltering(pageable, workingTimes).getContent());
    }

    @Override
    public DataResult<List<JobAdvert>> getByActiveIs() {
        return new SuccessDataResult<>(this.jobAdvertDao.getByActiveIs(), Messages.jobAdvertsListedByActivationStatus);
    }

    @Override
    public DataResult<List<JobAdvert>> getByActiveIsAndEmployer_Id(int employerId) {
        return new SuccessDataResult<>(this.jobAdvertDao.getByActiveIsAndEmployer_Id(employerId), Messages.jobAdvertsListedByActivationStatusAndByEmployerId);
    }

    @Override
    @Cacheable(value = "prominentJobAdvertsCache")
    public DataResult<List<JobAdvert>> getByActiveForProminent(int numberOfProminent) {
        Random random = new Random();

        List<JobAdvert> activeJobAdverts = this.jobAdvertDao.getByActiveIs();
        List<JobAdvert> prominentJobAdverts = new ArrayList<>();

        for (int i = 0; i < numberOfProminent; i++){

            if (i > activeJobAdverts.size() + 1){
                return new SuccessDataResult<>(prominentJobAdverts);
            }

            int randomIndex = random.nextInt(activeJobAdverts.size());

            prominentJobAdverts.add(activeJobAdverts.get(randomIndex));
            activeJobAdverts.remove(randomIndex);
        }
        return new SuccessDataResult<>(prominentJobAdverts);
    }

    @Override
    public DataResult<JobAdvert> add(JobAdvertAddDto jobAdvertAddDto) {
        var addedJobAdvert = this.jobAdvertDao.save((JobAdvert)this.dtoConverterService.dtoToBaseClassConverter(jobAdvertAddDto, JobAdvert.class));
        return new SuccessDataResult<>(addedJobAdvert, "Added");
    }

    @Override
    public Result closeJobAdvert(int jobAdvertId) {
        JobAdvert tempJobAdvert = this.jobAdvertDao.getOne(jobAdvertId);
        tempJobAdvert.setActive(false);

        this.jobAdvertDao.save(tempJobAdvert);
        return new SuccessResult(Messages.updateJobAdvertActivationStatusToDeactivate);
    }

    @Override
    public Result openJobAdvert(int jobAdvertId) {
        JobAdvert tempJobAdvert = this.jobAdvertDao.getOne(jobAdvertId);
        tempJobAdvert.setActive(true);

        this.jobAdvertDao.save(tempJobAdvert);
        return new SuccessResult(Messages.updateJobAdvertActivationStatusToActivate);
    }
}
