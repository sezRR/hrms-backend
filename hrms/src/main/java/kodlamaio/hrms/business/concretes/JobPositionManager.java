package kodlamaio.hrms.business.concretes;

import java.util.List;

import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private final JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<>(this.jobPositionDao.findAll(), Messages.jobPositionsListed);
	}

	@Override
	public DataResult<List<JobPosition>> getByPosition(String position) {
		return new SuccessDataResult<>(this.jobPositionDao.findByPosition(position), Messages.jobPositionListedByPositionName);
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if (this.getByPosition(jobPosition.getPosition()).getData().size() != 0){
			return new ErrorResult(Messages.jobPositionAlreadyExists);
		}

		this.jobPositionDao.save(jobPosition);
		return new SuccessResult(Messages.addJobPosition);
	}
}
