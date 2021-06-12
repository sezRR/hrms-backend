package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkingPlace;

import java.util.List;

public interface WorkingPlaceService {
    DataResult<List<WorkingPlace>> getAll();
}
