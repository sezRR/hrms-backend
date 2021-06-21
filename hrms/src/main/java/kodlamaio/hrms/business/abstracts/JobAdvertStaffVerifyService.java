package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertStaffVerify;
import kodlamaio.hrms.entities.dtos.JobAdvertStaffVerifyAddDto;

import java.util.List;

public interface JobAdvertStaffVerifyService {
    DataResult<List<JobAdvertStaffVerify>> getAll();
    DataResult<List<JobAdvertStaffVerify>> getByStaffUserIsNull();

    Result add(JobAdvertStaffVerifyAddDto jobAdvertStaffVerifyAddDto);
    Result confirmJobAdvert(int jobAdvertStaffVerifyId, int jobAdvertId, int staffUserId);
    Result rejectJobAdvert(int jobAdvertStaffVerifyId, int staffUserId);
}
