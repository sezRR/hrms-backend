package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResumeService {
    DataResult<List<Resume>> getAll();
    Result add(Resume resume);

    Result uploadImage(MultipartFile multipartFile, int resumeId);
}
