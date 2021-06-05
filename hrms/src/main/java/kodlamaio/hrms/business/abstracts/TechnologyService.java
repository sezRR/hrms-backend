package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Technology;
import kodlamaio.hrms.entities.dtos.TechnologyDto;

import java.util.List;

public interface TechnologyService {
    DataResult<List<Technology>> getAll();
    Result add(TechnologyDto technologyDto);
}
