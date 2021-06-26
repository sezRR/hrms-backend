package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerStaffVerifyAccountUpdateService;
import kodlamaio.hrms.core.utilities.converter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerStaffVerifyAccountUpdateDao;
import kodlamaio.hrms.dataAccess.abstracts.StaffUserDao;
import kodlamaio.hrms.entities.concretes.EmployerStaffVerifyAccountUpdate;
import kodlamaio.hrms.entities.dtos.EmployerStaffVerifyAccountUpdateAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployerStaffVerifyAccountUpdateManager implements EmployerStaffVerifyAccountUpdateService {

    private final EmployerStaffVerifyAccountUpdateDao employerStaffVerifyAccountUpdateDao;
    private final StaffUserDao staffUserDao;

    private final DtoConverterService dtoConverterService;

    @Autowired
    public EmployerStaffVerifyAccountUpdateManager(EmployerStaffVerifyAccountUpdateDao employerStaffVerifyAccountUpdateDao, StaffUserDao staffUserDao, DtoConverterService dtoConverterService) {
        this.employerStaffVerifyAccountUpdateDao = employerStaffVerifyAccountUpdateDao;
        this.staffUserDao = staffUserDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public DataResult<List<EmployerStaffVerifyAccountUpdate>> getAll() {
        return new SuccessDataResult<>(this.employerStaffVerifyAccountUpdateDao.findAll());
    }

    @Override
    public DataResult<EmployerStaffVerifyAccountUpdate> getById(int employerStaffVerifyAccountUpdateId) {
        return new SuccessDataResult<>(this.employerStaffVerifyAccountUpdateDao.getOne(employerStaffVerifyAccountUpdateId));
    }

    @Override
    public Result add(EmployerStaffVerifyAccountUpdateAddDto employerStaffVerifyAccountUpdateAddDto) {
        EmployerStaffVerifyAccountUpdate employerStaffVerifyAccountUpdate = (EmployerStaffVerifyAccountUpdate) this.dtoConverterService.dtoToBaseClassConverter(employerStaffVerifyAccountUpdateAddDto, EmployerStaffVerifyAccountUpdate.class);
        employerStaffVerifyAccountUpdate.setCreatedDate(LocalDate.now());

        this.employerStaffVerifyAccountUpdateDao.save(employerStaffVerifyAccountUpdate);

        return new SuccessResult("Added");
    }

    @Override
    public Result confirmEmployerAccountChange(int employerStaffVerifyAccountUpdateId, int staffUserId) {
        EmployerStaffVerifyAccountUpdate employerStaffVerifyAccountUpdate = this.employerStaffVerifyAccountUpdateDao.getOne(employerStaffVerifyAccountUpdateId);
        employerStaffVerifyAccountUpdate.setStaffUser(this.staffUserDao.getOne(staffUserId));
        employerStaffVerifyAccountUpdate.setConfirmDate(LocalDate.now());
        employerStaffVerifyAccountUpdate.setConfirmed(true);

        this.employerStaffVerifyAccountUpdateDao.save(employerStaffVerifyAccountUpdate);

        return new SuccessResult("Confirmed");
    }

    @Override
    public Result rejectEmployerAccountChange(int employerStaffVerifyAccountUpdateId, int staffUserId) {

        EmployerStaffVerifyAccountUpdate employerStaffVerifyAccountUpdate = this.employerStaffVerifyAccountUpdateDao.getOne(employerStaffVerifyAccountUpdateId);
        employerStaffVerifyAccountUpdate.setStaffUser(this.staffUserDao.getOne(staffUserId));

        this.employerStaffVerifyAccountUpdateDao.save(employerStaffVerifyAccountUpdate);

        return new SuccessResult("Rejected");
    }
}
