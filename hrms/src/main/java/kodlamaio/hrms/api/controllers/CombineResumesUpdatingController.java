package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CombineResumeUpdatingService;
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
public class CombineResumesUpdatingController {

    private final CombineResumeUpdatingService combineResumeUpdatingService;

    @Autowired
    public CombineResumesUpdatingController(CombineResumeUpdatingService combineResumeUpdatingService) {
        this.combineResumeUpdatingService = combineResumeUpdatingService;
    }

    @PutMapping("/updateresume")
    public Result updateResume(@Valid @RequestBody ResumeUpdateDto resumeUpdateDto){
        return this.combineResumeUpdatingService.updateResume(resumeUpdateDto);
    }

    @PutMapping("/updateeducation")
    public Result updateEducation(@Valid @RequestBody EducationUpdateDto educationUpdateDto){
        return this.combineResumeUpdatingService.updateEducation(educationUpdateDto);
    }

    @PutMapping("/updatejobexperience")
    public Result updateJobExperience(@Valid @RequestBody JobExperienceUpdateDto jobExperienceUpdateDto){
        return this.combineResumeUpdatingService.updateJobExperience(jobExperienceUpdateDto);
    }

    @PutMapping("/updatelanguage")
    public Result updateLanguage(@Valid @RequestBody LanguageUpdateDto languageUpdateDto){
        return this.combineResumeUpdatingService.updateLanguage(languageUpdateDto);
    }

    @PutMapping("/updatetechnology")
    public Result updateTechnology(@Valid @RequestBody TechnologyUpdateDto technologyUpdateDto){
        return this.combineResumeUpdatingService.updateTechnology(technologyUpdateDto);
    }
}
