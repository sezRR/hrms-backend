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
import org.springframework.stereotype.Service;

import java.util.List;

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
    public DataResult<List<JobAdvert>> getByActiveIs() {
        return new SuccessDataResult<>(this.jobAdvertDao.getByActiveIs(), Messages.jobAdvertsListedByActivationStatus);
    }

    @Override
    public DataResult<List<JobAdvert>> getByActiveIsAndEmployer_Id(int employerId) {
        return new SuccessDataResult<>(this.jobAdvertDao.getByActiveIsAndEmployer_Id(employerId), Messages.jobAdvertsListedByActivationStatusAndByEmployerId);
    }

    @Override
    public Result add(JobAdvertAddDto jobAdvertAddDto) {
        this.jobAdvertDao.save((JobAdvert)this.dtoConverterService.dtoToBaseClassConverter(jobAdvertAddDto, JobAdvert.class));
        return new SuccessResult("Added");
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
