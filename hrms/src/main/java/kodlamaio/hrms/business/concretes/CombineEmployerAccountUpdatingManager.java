package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CombineEmployerAccountUpdatingService;
import kodlamaio.hrms.business.abstracts.EmployerStaffVerifyAccountUpdateService;
import kodlamaio.hrms.business.abstracts.EmployerUserService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.EmployerStaffVerifyAccountUpdate;
import kodlamaio.hrms.entities.concretes.EmployerUser;
import kodlamaio.hrms.entities.dtos.EmployerStaffVerifyAccountUpdateAddDto;
import org.springframework.stereotype.Service;

@Service
public class CombineEmployerAccountUpdatingManager implements CombineEmployerAccountUpdatingService {

    private final EmployerStaffVerifyAccountUpdateService employerStaffVerifyAccountUpdateService;
    private final EmployerUserService employerUserService;

    public CombineEmployerAccountUpdatingManager(EmployerStaffVerifyAccountUpdateService employerStaffVerifyAccountUpdateService, EmployerUserService employerUserService) {
        this.employerStaffVerifyAccountUpdateService = employerStaffVerifyAccountUpdateService;
        this.employerUserService = employerUserService;
    }

    @Override
    public Result makeRequestForAccountDetailsChange(EmployerStaffVerifyAccountUpdateAddDto employerStaffVerifyAccountUpdateAddDto) {
        this.employerStaffVerifyAccountUpdateService.add(employerStaffVerifyAccountUpdateAddDto);
        return new SuccessResult("Added");
    }

    @Override
    public Result confirmEmployerAccountChange(int employerStaffVerifyAccountUpdateId, int staffUserId, int employerId) {
        this.employerStaffVerifyAccountUpdateService.confirmEmployerAccountChange(employerStaffVerifyAccountUpdateId, staffUserId);
        this.updateEmployerAccountInformation(employerId, employerStaffVerifyAccountUpdateId);

        return new SuccessResult("Updating request confirmed and employer user account details updated successfully.");
    }

    @Override
    public Result rejectEmployerAccountChange(int employerStaffVerifyAccountUpdateId, int staffUserId) {
        this.employerStaffVerifyAccountUpdateService.rejectEmployerAccountChange(employerStaffVerifyAccountUpdateId, staffUserId);

        return new SuccessResult("Updating request rejected and employer user account details not changed.");
    }

    @Override
    public Result updateEmployerAccountInformation(int employerId, int employerStaffVerifyAccountUpdateId) {
        EmployerStaffVerifyAccountUpdate newAccountDetails = this.employerStaffVerifyAccountUpdateService.getById(employerStaffVerifyAccountUpdateId).getData();

        EmployerUser newEmployerUserAccountDetails = new EmployerUser();
        newEmployerUserAccountDetails.setId(newAccountDetails.getEmployer().getId());
        newEmployerUserAccountDetails.setEmail(newAccountDetails.getTempAccountInformation().getEmail());
        newEmployerUserAccountDetails.setPassword(newAccountDetails.getTempAccountInformation().getPassword());
        newEmployerUserAccountDetails.setCompanyName(newAccountDetails.getTempAccountInformation().getCompanyName());
        newEmployerUserAccountDetails.setWebAddress(newAccountDetails.getTempAccountInformation().getWebAddress());
        newEmployerUserAccountDetails.setPhoneNumber(newAccountDetails.getTempAccountInformation().getPhoneNumber());

        this.employerUserService.update(newEmployerUserAccountDetails);

        return new SuccessResult("Updated");
    }
}
