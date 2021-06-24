package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ResumeUpdatingService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/resumesupdating")
public class ResumesUpdatingController {

    private final ResumeUpdatingService resumeUpdatingService;

    @Autowired
    public ResumesUpdatingController(ResumeUpdatingService resumeUpdatingService) {
        this.resumeUpdatingService = resumeUpdatingService;
    }

    @PutMapping("/updateresume")
    public Result updateResume(@Valid @RequestBody ResumeUpdateDto resumeUpdateDto){
        return this.resumeUpdatingService.updateResume(resumeUpdateDto);
    }

    @PutMapping("/updateeducation")
    public Result updateEducation(@Valid @RequestBody EducationUpdateDto educationUpdateDto){
        return this.resumeUpdatingService.updateEducation(educationUpdateDto);
    }

    @PutMapping("/updatejobexperience")
    public Result updateJobExperience(@Valid @RequestBody JobExperienceUpdateDto jobExperienceUpdateDto){
        return this.resumeUpdatingService.updateJobExperience(jobExperienceUpdateDto);
    }

    @PutMapping("/updatelanguage")
    public Result updateLanguage(@Valid @RequestBody LanguageUpdateDto languageUpdateDto){
        return this.resumeUpdatingService.updateLanguage(languageUpdateDto);
    }

    @PutMapping("/updatetechnology")
    public Result updateTechnology(@Valid @RequestBody TechnologyUpdateDto technologyUpdateDto){
        return this.resumeUpdatingService.updateTechnology(technologyUpdateDto);
    }
}
