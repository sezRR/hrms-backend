package kodlamaio.hrms.api.controllers;

import java.util.List;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.dtos.EducationAddDto;
import kodlamaio.hrms.entities.dtos.EducationUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/education")
@CrossOrigin
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
    public Result add(@Valid @RequestBody EducationAddDto educationAddDto){
        return this.educationService.add(educationAddDto);
    }

    @PutMapping("/update")
    public Result update(@Valid @RequestBody EducationUpdateDto educationUpdateDto){
        return this.educationService.update(educationUpdateDto);
    }
}
