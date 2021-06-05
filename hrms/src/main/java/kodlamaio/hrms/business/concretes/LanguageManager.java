package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.converter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.LanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    private final LanguageDao languageDao;
    private final DtoConverterService dtoConverterService;

    @Autowired
    public LanguageManager(LanguageDao languageDao, DtoConverterService dtoConverterService) {
        this.languageDao = languageDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<>(this.languageDao.findAll(), "Data listed");
    }

    @Override
    public Result add(LanguageDto languageDto) {
        this.languageDao.save((Language)this.dtoConverterService.dtoToBaseClassConverter(languageDto, Language.class));
        return new SuccessResult("Added");
    }
}
