package kodlamaio.hrms.api.controllers;

import java.util.List;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dtos.JobExperienceAddDto;
import kodlamaio.hrms.entities.dtos.JobExperienceUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/jobexperiences")
@CrossOrigin
public class JobExperiencesController {
    private final JobExperienceService jobExperienceService;

    @Autowired
    public JobExperiencesController(JobExperienceService jobExperienceService) {
        this.jobExperienceService = jobExperienceService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobExperience>> getAll(){
        return this.jobExperienceService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody JobExperienceAddDto jobExperienceAddDto){
        return this.jobExperienceService.add(jobExperienceAddDto);
    }

    @PutMapping("/update")
    public Result update(@Valid @RequestBody JobExperienceUpdateDto jobExperienceUpdateDto){
        return this.jobExperienceService.update(jobExperienceUpdateDto);
    }
}
