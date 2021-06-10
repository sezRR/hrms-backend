package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployerUserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employerusers")
@CrossOrigin
public class EmployerUsersController {

    private final EmployerUserService employerUserService;

    public EmployerUsersController(EmployerUserService employerUserService) {
        this.employerUserService = employerUserService;
    }

    @GetMapping("/getall")
    public DataResult<List<EmployerUser>> getAll(){
        return this.employerUserService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody EmployerUser employerUser){
        return this.employerUserService.add(employerUser);
    }
}
