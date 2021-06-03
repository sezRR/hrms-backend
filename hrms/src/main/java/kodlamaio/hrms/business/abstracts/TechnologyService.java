package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.concretes.Technology;

import java.util.List;

public interface TechnologyService {
    DataResult<List<Technology>> getAll();
    Result add(Technology technology);
}
