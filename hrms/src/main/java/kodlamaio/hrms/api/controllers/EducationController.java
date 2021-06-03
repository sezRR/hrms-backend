package kodlamaio.hrms.api.controllers;

import java.util.List;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/education")
public class EducationController {
    private final EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }


    @GetMapping("/getall")
    public DataResult<List<Education>> getAll(){
        return this.educationService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody Education education){
        return this.educationService.add(education);
    }
}
