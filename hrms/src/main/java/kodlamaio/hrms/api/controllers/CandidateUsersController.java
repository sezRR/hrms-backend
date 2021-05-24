package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CandidateUserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/candidateusers")
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

    @PostMapping("/findbyemailis")
    public DataResult<List<CandidateUser>> findByEmailIs(@RequestBody String email){
        return this.candidateUserService.findByEmailIs(email.toLowerCase().trim());
    }

    @PostMapping("/findbyidentitynumberis")
    public DataResult<List<CandidateUser>> findByIdentityNumberIs(@RequestBody String identityNumber){
        return this.candidateUserService.findByIdentityNumberIs(identityNumber.trim());
    }

    @PostMapping("/add")
    public Result add(@RequestBody CandidateUser candidateUser){
        return this.candidateUserService.add(candidateUser);
    }
}
