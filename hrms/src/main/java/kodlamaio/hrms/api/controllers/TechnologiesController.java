package kodlamaio.hrms.api.controllers;

import java.util.List;

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
    private final TechnologyService technologyService;

    @Autowired
    public TechnologiesController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping("/getall")
    public DataResult<List<Technology>> getAll(){
        return this.technologyService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody Technology technology){
        return this.technologyService.add(technology);
    }
}
