package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.StaffUserService;
import kodlamaio.hrms.business.concretes.checkHelper.StaffUserCheckHelper;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.StaffUserDao;
import kodlamaio.hrms.entities.concretes.EmployerUser;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.concretes.StaffUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffUserManager implements StaffUserService {

    private final StaffUserDao staffUserDao;

    @Autowired
    public StaffUserManager(StaffUserDao staffUserDao) {
        this.staffUserDao = staffUserDao;
    }

    @Override
    public DataResult<List<StaffUser>> getAll() {
        return new SuccessDataResult<>(this.staffUserDao.findAll(), Messages.usersListed);
    }

    @Override
    public DataResult<StaffUser> getById(int id) {
        return new SuccessDataResult<>(this.staffUserDao.getById(id));
    }

    @Override
    public DataResult<Boolean> confirmEmployer(StaffUser staffUser, EmployerUser confirmedEmployerUser) {
        return new SuccessDataResult<>(StaffUserCheckHelper.confirmEmployer(confirmedEmployerUser), Messages.staffUserConfirmedEmployer);
    }

    @Override
    public DataResult<Boolean> confirmJobAdvert(StaffUser staffUser, JobAdvert jobAdvert) {
        return new SuccessDataResult<>(StaffUserCheckHelper.confirmJobAdvert(jobAdvert));
    }

    @Override
    public Result add(StaffUser staffUser) {
        this.staffUserDao.save(staffUser);
        return new SuccessResult("Added");
    }

    @Override
    public Result update(StaffUser staffUser) {
        StaffUser tempStaffUser = this.staffUserDao.getOne(staffUser.getId());

        tempStaffUser.setFirstName(staffUser.getFirstName());
        tempStaffUser.setLastName(staffUser.getLastName());
        tempStaffUser.setEmail(staffUser.getEmail());
        tempStaffUser.setPassword(staffUser.getPassword());

        this.staffUserDao.save(tempStaffUser);

        return new SuccessResult("Updated");
    }
}
