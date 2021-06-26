package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerUser;

import java.util.List;

public interface EmployerUserService {
    DataResult<List<EmployerUser>> getAll();

    Result add(EmployerUser employerUser);
    Result update(EmployerUser employerUser);
}
