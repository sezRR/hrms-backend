package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.StaffUserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.StaffUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/staffusers")
@CrossOrigin
public class StaffUsersController {

    private final StaffUserService staffUserService;

    @Autowired
    public StaffUsersController(StaffUserService staffUserService) {
        this.staffUserService = staffUserService;
    }

    @GetMapping("/getall")
    public DataResult<List<StaffUser>> getAll(){
        return this.staffUserService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<StaffUser> getById(@Valid @RequestParam int id){
        return this.staffUserService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody StaffUser staffUser){
        return this.staffUserService.add(staffUser);
    }

    @PutMapping("/update")
    public Result update(@Valid @RequestBody StaffUser staffUser){
        return this.staffUserService.update(staffUser);
    }
}
