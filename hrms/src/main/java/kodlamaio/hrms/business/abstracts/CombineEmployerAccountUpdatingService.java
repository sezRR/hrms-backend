package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.EmployerStaffVerifyAccountUpdateAddDto;

public interface CombineEmployerAccountUpdatingService {
    Result makeRequestForAccountDetailsChange(EmployerStaffVerifyAccountUpdateAddDto employerStaffVerifyAccountUpdateAddDto);
    Result confirmEmployerAccountChange(int employerStaffVerifyAccountUpdateId, int staffUserId, int employerId);
    Result rejectEmployerAccountChange(int employerStaffVerifyAccountUpdateId, int staffUserId);
    Result updateEmployerAccountInformation(int employerId, int employerStaffVerifyAccountUpdateId);
}
