package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dtos.JobExperienceAddDto;
import kodlamaio.hrms.entities.dtos.JobExperienceUpdateDto;

import java.util.List;

public interface JobExperienceService {
    DataResult<List<JobExperience>> getAll();

    Result add(JobExperienceAddDto jobExperienceAddDto);
    Result update(JobExperienceUpdateDto jobExperienceUpdateDto);
}
