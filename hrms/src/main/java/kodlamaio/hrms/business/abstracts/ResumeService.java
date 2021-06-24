package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeAddDto;
import kodlamaio.hrms.entities.dtos.ResumeUpdateDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResumeService {
    DataResult<List<Resume>> getAll();

    Result add(ResumeAddDto resumeAddDto);
    Result update(ResumeUpdateDto resumeUpdateDto);
    Result updateUpdatedDate(int resumeId);

    Result uploadImage(MultipartFile multipartFile, int resumeId);
}
