package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.converter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.EducationAddDto;
import kodlamaio.hrms.entities.dtos.EducationUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public Result add(EducationAddDto educationAddDto) {
        this.educationDao.save((Education)this.dtoConverterService.dtoToBaseClassConverter(educationAddDto, Education.class));
        return new SuccessResult("Added");
    }

    @Override
    public Result update(EducationUpdateDto educationUpdateDto) {
        Education tempEducation = this.educationDao.getOne(educationUpdateDto.getId());

        EducationAddDto educationAddDto = (EducationAddDto) this.dtoConverterService.dtoToBaseClassConverter(tempEducation, EducationAddDto.class);
        educationAddDto.setSchoolName(educationUpdateDto.getSchoolName());
        educationAddDto.setSchoolDepartment(educationUpdateDto.getSchoolDepartment());
        educationAddDto.setGraduateId(educationUpdateDto.getGraduateId());
        educationAddDto.setStartedDate(educationUpdateDto.getStartedDate());
        educationAddDto.setEndedDate(educationUpdateDto.getEndedDate());

        Education updatedEducation = (Education) this.dtoConverterService.dtoToBaseClassConverter(educationAddDto, Education.class);
        this.educationDao.save(updatedEducation);

        return new SuccessResult("Updated");
    }
}
