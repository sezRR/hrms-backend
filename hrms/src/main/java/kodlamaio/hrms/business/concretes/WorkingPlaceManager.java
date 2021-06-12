package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.WorkingPlaceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkingPlaceDao;
import kodlamaio.hrms.entities.concretes.WorkingPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingPlaceManager implements WorkingPlaceService {
    private final WorkingPlaceDao workingPlaceDao;

    @Autowired
    public WorkingPlaceManager(WorkingPlaceDao workingPlaceDao) {
        this.workingPlaceDao = workingPlaceDao;
    }

    @Override
    public DataResult<List<WorkingPlace>> getAll() {
        return new SuccessDataResult<>(this.workingPlaceDao.findAll());
    }
}
