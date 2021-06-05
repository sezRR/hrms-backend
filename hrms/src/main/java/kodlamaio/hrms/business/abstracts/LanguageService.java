package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.LanguageDto;

import java.util.List;

public interface LanguageService {
    DataResult<List<Language>> getAll();
    Result add(LanguageDto languageDto);
}
