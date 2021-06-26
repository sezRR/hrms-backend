package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.*;

public interface CombineResumeUpdatingService {
    Result updateResume(ResumeUpdateDto resumeUpdateDto);
    Result updateEducation(EducationUpdateDto educationUpdateDto);
    Result updateJobExperience(JobExperienceUpdateDto jobExperienceUpdateDto);
    Result updateLanguage(LanguageUpdateDto languageUpdateDto);
    Result updateTechnology(TechnologyUpdateDto technologyUpdateDto);
}
