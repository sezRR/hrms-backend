package kodlamaio.hrms.api.controllers;

import java.util.List;

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Technology;
import kodlamaio.hrms.entities.dtos.TechnologyAddDto;
import kodlamaio.hrms.entities.dtos.TechnologyUpdateDto;
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
    public Result add(@Valid @RequestBody TechnologyAddDto technologyAddDto){
        return this.technologyService.add(technologyAddDto);
    }

    @PutMapping("/update")
    public Result update(@Valid @RequestBody TechnologyUpdateDto technologyUpdateDto){
        return this.technologyService.update(technologyUpdateDto);
    }
}
