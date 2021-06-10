package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CandidateUserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidateusers")
@CrossOrigin
public class CandidateUsersController {

    private final CandidateUserService candidateUserService;

    @Autowired
    public CandidateUsersController(CandidateUserService candidateUserService) {
        this.candidateUserService = candidateUserService;
    }

    @GetMapping("/getall")
    public DataResult<List<CandidateUser>> getAll(){
        return this.candidateUserService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody CandidateUser candidateUser){
        return this.candidateUserService.add(candidateUser);
    }
}
