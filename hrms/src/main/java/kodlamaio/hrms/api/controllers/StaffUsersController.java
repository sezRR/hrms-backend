package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.StaffUserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.StaffUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/staffusers")
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
}
