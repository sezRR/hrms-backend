package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobAdvertStaffVerifyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertStaffVerify;
import kodlamaio.hrms.entities.dtos.JobAdvertStaffVerifyAddDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jobadvertsstaffverify")
@CrossOrigin
public class JobAdvertStaffVerifyController {
    private final JobAdvertStaffVerifyService jobAdvertStaffVerifyService;

    public JobAdvertStaffVerifyController(JobAdvertStaffVerifyService jobAdvertStaffVerifyService) {
        this.jobAdvertStaffVerifyService = jobAdvertStaffVerifyService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertStaffVerify>> getAll(){
        return this.jobAdvertStaffVerifyService.getAll();
    }

    @GetMapping("/getbystaffuserisnull")
    public DataResult<List<JobAdvertStaffVerify>> getByStaffUserIsNull(){
        return this.jobAdvertStaffVerifyService.getByStaffUserIsNull();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody JobAdvertStaffVerifyAddDto jobAdvertStaffVerifyAddDto){
        return this.jobAdvertStaffVerifyService.add(jobAdvertStaffVerifyAddDto);
    }

    @PutMapping("/confirmjobadvert")
    Result confirmJobAdvert(@Valid int jobAdvertStaffVerifyId, @Valid int jobAdvertId, @Valid int staffUserId){
        return this.jobAdvertStaffVerifyService.confirmJobAdvert(jobAdvertStaffVerifyId, jobAdvertId, staffUserId);
    }

    @PutMapping("/rejectjobadvert")
    public Result rejectJobAdvert(int jobAdvertStaffVerifyId, int staffUserId) {
        return this.jobAdvertStaffVerifyService.rejectJobAdvert(jobAdvertStaffVerifyId, staffUserId);
    }
}
