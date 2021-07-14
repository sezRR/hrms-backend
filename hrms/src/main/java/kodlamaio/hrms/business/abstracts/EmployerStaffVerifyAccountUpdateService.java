package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerStaffVerifyAccountUpdate;
import kodlamaio.hrms.entities.dtos.EmployerStaffVerifyAccountUpdateAddDto;

import java.util.List;

public interface EmployerStaffVerifyAccountUpdateService {
    DataResult<List<EmployerStaffVerifyAccountUpdate>> getAll();
    DataResult<List<EmployerStaffVerifyAccountUpdate>> getWaitingRequests();
    DataResult<EmployerStaffVerifyAccountUpdate> getById(int employerStaffVerifyAccountUpdateId);

    Result add(EmployerStaffVerifyAccountUpdateAddDto employerStaffVerifyAccountUpdateAddDto);
    Result confirmEmployerAccountChange(int employerStaffVerifyAccountUpdateId, int staffUserId);
    Result rejectEmployerAccountChange(int employerStaffVerifyAccountUpdateId, int staffUserId);
}
