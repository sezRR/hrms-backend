package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Graduate;

import java.util.List;

public interface GraduateService {
    DataResult<List<Graduate>> getAll();
    Result add(Graduate graduate);
}