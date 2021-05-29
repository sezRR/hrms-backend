package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertManager implements JobAdvertService {

    private final JobAdvertDao jobAdvertDao;

    @Autowired
    public JobAdvertManager(JobAdvertDao jobAdvertDao) {
        this.jobAdvertDao = jobAdvertDao;
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
    public Result closeJobAdvert(int jobAdvertId) {
        JobAdvert tempJobAdvert = this.jobAdvertDao.getOne(jobAdvertId);
        tempJobAdvert.setActive(false);

        this.jobAdvertDao.save(tempJobAdvert);
        return new SuccessResult(Messages.updateJobAdvertActivationStatus);
    }
}
