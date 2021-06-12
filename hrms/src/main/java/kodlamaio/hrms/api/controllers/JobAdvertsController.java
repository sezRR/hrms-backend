package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertsController {
    private final JobAdvertService jobAdvertService;

    @Autowired
    public JobAdvertsController(JobAdvertService jobAdvertService) {
        this.jobAdvertService = jobAdvertService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvert>> getAll(){
        return this.jobAdvertService.getAll();
    }

    @GetMapping("/getbyactiveis")
    public DataResult<List<JobAdvert>> getByActiveIs(){
        return this.jobAdvertService.getByActiveIs();
    }

    @GetMapping("/getbyactiveisandemployerid")
    public DataResult<List<JobAdvert>> getByActiveIsAndEmployerId(@RequestParam int employerId){
        return this.jobAdvertService.getByActiveIsAndEmployer_Id(employerId);
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody JobAdvertAddDto jobAdvertAddDto){
        return this.jobAdvertService.add(jobAdvertAddDto);
    }

    @PutMapping("/closejobadvert")
    public Result closeJobAdvert(@Valid @RequestParam int jobAdvertId){
        return this.jobAdvertService.closeJobAdvert(jobAdvertId);
    }

    @PutMapping("/openjobadvert")
    public Result openJobAdvert(@Valid @RequestParam int jobAdvertId){
        return this.jobAdvertService.openJobAdvert(jobAdvertId);
    }
}
