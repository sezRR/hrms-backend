package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertAddDto;

import java.util.List;

public interface JobAdvertService {
    DataResult<List<JobAdvert>> getAll();
    DataResult<List<JobAdvert>> getByActiveIs();
    DataResult<List<JobAdvert>> getByActiveIsAndEmployer_Id(int employerId);

    Result add(JobAdvertAddDto jobAdvertAddDto);

    Result closeJobAdvert(int jobAdvertId);
    Result openJobAdvert(int jobAdvertId);
}
