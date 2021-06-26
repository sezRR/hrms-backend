package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertStaffVerifyService;
import kodlamaio.hrms.core.utilities.converter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertStaffVerifyDao;
import kodlamaio.hrms.dataAccess.abstracts.StaffUserDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.concretes.JobAdvertStaffVerify;
import kodlamaio.hrms.entities.dtos.JobAdvertStaffVerifyAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobAdvertStaffVerifyManager implements JobAdvertStaffVerifyService {

    private final JobAdvertStaffVerifyDao jobAdvertStaffVerifyDao;
    private final StaffUserDao staffUserDao;
    private final JobAdvertDao jobAdvertDao;

    private final DtoConverterService dtoConverterService;

    @Autowired
    public JobAdvertStaffVerifyManager(JobAdvertStaffVerifyDao jobAdvertStaffVerifyDao, StaffUserDao staffUserDao, JobAdvertDao jobAdvertDao, DtoConverterService dtoConverterService) {
        this.jobAdvertStaffVerifyDao = jobAdvertStaffVerifyDao;
        this.staffUserDao = staffUserDao;
        this.jobAdvertDao = jobAdvertDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public DataResult<List<JobAdvertStaffVerify>> getAll() {
        return new SuccessDataResult<>(this.jobAdvertStaffVerifyDao.findAll());
    }

    @Override
    public DataResult<List<JobAdvertStaffVerify>> getByStaffUserIsNull() {
        return new SuccessDataResult<>(this.jobAdvertStaffVerifyDao.getByStaffUserIsNull());
    }

    @Override
    public Result add(JobAdvertStaffVerifyAddDto jobAdvertStaffVerifyAddDto) {
        this.jobAdvertStaffVerifyDao.save((JobAdvertStaffVerify) this.dtoConverterService.dtoToBaseClassConverter(jobAdvertStaffVerifyAddDto, JobAdvertStaffVerify.class));
        return new SuccessResult("Added");
    }

    @Override
    public Result confirmJobAdvert(int jobAdvertStaffVerifyId, int jobAdvertId, int staffUserId) {
        JobAdvert tempJobAdvert = this.jobAdvertDao.getOne(jobAdvertId);
        tempJobAdvert.setActive(true);

        this.jobAdvertDao.save(tempJobAdvert);

        JobAdvertStaffVerify tempJobAdvertStaffVerify = this.jobAdvertStaffVerifyDao.getOne(jobAdvertStaffVerifyId);
        tempJobAdvertStaffVerify.setStaffUser(this.staffUserDao.getOne(staffUserId));
        tempJobAdvertStaffVerify.setConfirmDate(LocalDate.now());
        tempJobAdvertStaffVerify.setConfirmed(true);

        this.jobAdvertStaffVerifyDao.save(tempJobAdvertStaffVerify);

        return new SuccessResult("Confirmed");
    }

    @Override
    public Result rejectJobAdvert(int jobAdvertStaffVerifyId, int staffUserId) {
        JobAdvertStaffVerify tempJobAdvertStaffVerify = this.jobAdvertStaffVerifyDao.getOne(jobAdvertStaffVerifyId);
        tempJobAdvertStaffVerify.setStaffUser(this.staffUserDao.getOne(staffUserId));

        this.jobAdvertStaffVerifyDao.save(tempJobAdvertStaffVerify);

        return new SuccessResult("Rejected");
    }
}
