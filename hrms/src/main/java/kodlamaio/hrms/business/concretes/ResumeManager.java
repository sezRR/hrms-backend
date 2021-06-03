package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.adapters.cloudinary.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResumeManager implements ResumeService{
    private final ResumeDao resumeDao;
    private final CloudinaryService cloudinaryService;

    @Autowired
    public ResumeManager(ResumeDao resumeDao, CloudinaryService cloudinaryService) {
        this.resumeDao = resumeDao;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public DataResult<List<Resume>> getAll() {
        return new SuccessDataResult<>(this.resumeDao.findAll());
    }

    @Override
    public Result add(Resume resume) {
        this.resumeDao.save(resume);
        return new SuccessResult("Added");
    }

    @Override
    public Result uploadImage(MultipartFile multipartFile, int resumeId) {
        try {
            String filePath = this.cloudinaryService.upload(multipartFile).getData().get("url").toString();

            Resume tempResume = resumeDao.getOne(resumeId);
            tempResume.setPhoto(filePath);
            resumeDao.save(tempResume);

            return new SuccessResult("Uploaded");
        } catch (IOException e) {
            return new ErrorResult("Exception: " + e.getMessage());
        }
    }
}
