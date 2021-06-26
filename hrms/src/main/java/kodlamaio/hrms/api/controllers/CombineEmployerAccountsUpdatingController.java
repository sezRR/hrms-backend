package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CombineEmployerAccountUpdatingService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.EmployerStaffVerifyAccountUpdateAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/employeraccountsupdating")
public class CombineEmployerAccountsUpdatingController {
    private final CombineEmployerAccountUpdatingService combineEmployerAccountUpdatingService;

    @Autowired
    public CombineEmployerAccountsUpdatingController(CombineEmployerAccountUpdatingService combineEmployerAccountUpdatingService) {
        this.combineEmployerAccountUpdatingService = combineEmployerAccountUpdatingService;
    }

    @PostMapping("/makerequestforaccountdetailschange")
    public Result makeRequestForAccountDetailsChange(@Valid @RequestBody EmployerStaffVerifyAccountUpdateAddDto employerStaffVerifyAccountUpdateAddDto) {
        return this.combineEmployerAccountUpdatingService.makeRequestForAccountDetailsChange(employerStaffVerifyAccountUpdateAddDto);
    }

    @PutMapping("/confirmemployeraccountchange")
    public Result confirmEmployerAccountChange(@Valid @RequestParam int employerStaffVerifyAccountUpdateId, @Valid @RequestParam int staffUserId, @Valid @RequestParam int employerId) {
        return this.combineEmployerAccountUpdatingService.confirmEmployerAccountChange(employerStaffVerifyAccountUpdateId, staffUserId, employerId);
    }

    @PutMapping("/rejectemployeraccountchange")
    public Result rejectEmployerAccountChange(@Valid @RequestParam int employerStaffVerifyAccountUpdateId, @Valid @RequestParam int staffUserId) {
        return this.combineEmployerAccountUpdatingService.rejectEmployerAccountChange(employerStaffVerifyAccountUpdateId, staffUserId);
    }
}