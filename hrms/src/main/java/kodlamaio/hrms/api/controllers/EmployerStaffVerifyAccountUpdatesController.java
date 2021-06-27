package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployerStaffVerifyAccountUpdateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerStaffVerifyAccountUpdate;
import kodlamaio.hrms.entities.dtos.EmployerStaffVerifyAccountUpdateAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employerstaffverifyaccountupdatescontroller")
@CrossOrigin
public class EmployerStaffVerifyAccountUpdatesController {
    private final EmployerStaffVerifyAccountUpdateService employerStaffVerifyAccountUpdateService;

    @Autowired
    public EmployerStaffVerifyAccountUpdatesController(EmployerStaffVerifyAccountUpdateService employerStaffVerifyAccountUpdateService) {
        this.employerStaffVerifyAccountUpdateService = employerStaffVerifyAccountUpdateService;
    }

    @GetMapping("/getall")
    public DataResult<List<EmployerStaffVerifyAccountUpdate>> getAll() {
        return this.employerStaffVerifyAccountUpdateService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody EmployerStaffVerifyAccountUpdateAddDto employerStaffVerifyAccountUpdateAddDto) {
        return this.employerStaffVerifyAccountUpdateService.add(employerStaffVerifyAccountUpdateAddDto);
    }

    @PutMapping("/confirmemployeraccountchange")
    public Result confirmEmployerAccountChange(@Valid @RequestParam int employerStaffVerifyAccountUpdateId, @Valid @RequestParam int staffUserId) {
        return this.employerStaffVerifyAccountUpdateService.confirmEmployerAccountChange(employerStaffVerifyAccountUpdateId, staffUserId);
    }

    @PutMapping("rejectemployeraccountchange")
    public Result rejectEmployerAccountChange(@Valid @RequestParam int employerStaffVerifyAccountUpdateId, @Valid @RequestParam int staffUserId) {
        return this.employerStaffVerifyAccountUpdateService.rejectEmployerAccountChange(employerStaffVerifyAccountUpdateId, staffUserId);
    }
}
