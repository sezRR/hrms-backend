package kodlamaio.hrms.api.controllers;

import java.util.List;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.LanguageAddDto;
import kodlamaio.hrms.entities.dtos.LanguageUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin
public class LanguagesController {
    private final LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    public DataResult<List<Language>> getAll(){
        return this.languageService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody LanguageAddDto languageAddDto){
        return this.languageService.add(languageAddDto);
    }

    @PutMapping("/update")
    public Result update(@Valid @RequestBody LanguageUpdateDto languageUpdateDto){
        return this.languageService.update(languageUpdateDto);
    }
}
