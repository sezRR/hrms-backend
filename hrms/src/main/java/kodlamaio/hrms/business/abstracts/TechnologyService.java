package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Technology;
import kodlamaio.hrms.entities.dtos.TechnologyAddDto;
import kodlamaio.hrms.entities.dtos.TechnologyUpdateDto;

import java.util.List;

public interface TechnologyService {
    DataResult<List<Technology>> getAll();

    Result add(TechnologyAddDto technologyAddDto);
    Result update(TechnologyUpdateDto technologyUpdateDto);
}
