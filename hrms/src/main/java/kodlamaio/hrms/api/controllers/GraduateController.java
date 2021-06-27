package kodlamaio.hrms.api.controllers;

import java.util.List;

import kodlamaio.hrms.business.abstracts.GraduateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Graduate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/graduates")
@CrossOrigin
public class GraduateController {

    private final GraduateService graduateService;

    @Autowired
    public GraduateController(GraduateService graduateService) {
        this.graduateService = graduateService;
    }

    @GetMapping("/getall")
    public DataResult<List<Graduate>> getAll(){
        return this.graduateService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody Graduate graduate){
        return this.graduateService.add(graduate);
    }
}
