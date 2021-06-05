package kodlamaio.hrms.api.controllers;

import java.io.File;
import java.util.List;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/resumes")
public class ResumesController {
    private final ResumeService resumeService;

    @Autowired
    public ResumesController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("/getall")
    public DataResult<List<Resume>> getAll(){
        return this.resumeService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody ResumeAddDto resumeAddDto){
        return this.resumeService.add(resumeAddDto);
    }

    @PutMapping("/uploadimage")
    public Result uploadImage(@RequestBody MultipartFile file, @RequestParam int resumeId){
        return this.resumeService.uploadImage(file, resumeId);
    }


}
