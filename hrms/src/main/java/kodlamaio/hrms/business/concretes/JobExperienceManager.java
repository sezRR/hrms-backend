package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.converter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dtos.JobExperienceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {
    private final JobExperienceDao jobExperienceDao;
    private final DtoConverterService dtoConverterService;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao, DtoConverterService dtoConverterService) {
        this.jobExperienceDao = jobExperienceDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<>(this.jobExperienceDao.findAll(), "Data listed");
    }

    @Override
    public Result add(JobExperienceDto jobExperienceDto) {
        this.jobExperienceDao.save((JobExperience)this.dtoConverterService.dtoToBaseClassConverter(jobExperienceDto, JobExperience.class));
        return new SuccessResult("Added");
    }
}
