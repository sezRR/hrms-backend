package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.converter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.dtos.EducationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationManager implements EducationService {
    private final EducationDao educationDao;
    private final DtoConverterService dtoConverterService;

    @Autowired
    public EducationManager(EducationDao educationDao, DtoConverterService dtoConverterService) {
        this.educationDao = educationDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public DataResult<List<Education>> getAll() {
        return new SuccessDataResult<>(this.educationDao.findAll(), "Data listed");
    }

    @Override
    public Result add(EducationDto educationDto) {
        this.educationDao.save((Education)this.dtoConverterService.dtoToBaseClassConverter(educationDto, Education.class));
        return new SuccessResult("Added");
    }
}
