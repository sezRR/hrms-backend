package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.LanguageAddDto;
import kodlamaio.hrms.entities.dtos.LanguageUpdateDto;

import java.util.List;

public interface LanguageService {
    DataResult<List<Language>> getAll();

    Result add(LanguageAddDto languageAddDto);
    Result update(LanguageUpdateDto languageUpdateDto);
}
