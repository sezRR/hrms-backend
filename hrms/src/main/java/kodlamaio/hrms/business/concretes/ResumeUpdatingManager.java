package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.*;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeUpdatingManager implements ResumeUpdatingService {

    private final ResumeService resumeService;
    private final EducationService educationService;
    private final JobExperienceService jobExperienceService;
    private final LanguageService languageService;
    private final TechnologyService technologyService;

    @Autowired
    public ResumeUpdatingManager(ResumeService resumeService, EducationService educationService, JobExperienceService jobExperienceService, LanguageService languageService, TechnologyService technologyService) {
        this.resumeService = resumeService;
        this.educationService = educationService;
        this.jobExperienceService = jobExperienceService;
        this.languageService = languageService;
        this.technologyService = technologyService;
    }

    @Override
    public Result updateResume(ResumeUpdateDto resumeUpdateDto) {
        return resumeService.update(resumeUpdateDto);
    }

    @Override
    public Result updateEducation(EducationUpdateDto educationUpdateDto) {
        this.educationService.update(educationUpdateDto);
        this.resumeService.updateUpdatedDate(educationUpdateDto.getResumeId());

        return new SuccessResult("Updated");
    }

    @Override
    public Result updateJobExperience(JobExperienceUpdateDto jobExperienceUpdateDto) {
        this.jobExperienceService.update(jobExperienceUpdateDto);
        this.resumeService.updateUpdatedDate(jobExperienceUpdateDto.getResumeId());

        return new SuccessResult("Updated");
    }

    @Override
    public Result updateLanguage(LanguageUpdateDto languageUpdateDto) {
        this.languageService.update(languageUpdateDto);
        this.resumeService.updateUpdatedDate(languageUpdateDto.getResumeId());

        return new SuccessResult("Updated");
    }

    @Override
    public Result updateTechnology(TechnologyUpdateDto technologyUpdateDto) {
        this.technologyService.update(technologyUpdateDto);
        this.resumeService.updateUpdatedDate(technologyUpdateDto.getResumeId());

        return new SuccessResult("Updated");
    }
}
