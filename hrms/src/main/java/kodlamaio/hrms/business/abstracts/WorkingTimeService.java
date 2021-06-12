package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkingTime;

import java.util.List;

public interface WorkingTimeService {
    DataResult<List<WorkingTime>> getAll();
}
