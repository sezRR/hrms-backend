package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.GraduateService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.GraduateDao;
import kodlamaio.hrms.entities.concretes.Graduate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraduateManager implements GraduateService {

    private final GraduateDao graduateDao;

    @Autowired
    public GraduateManager(GraduateDao graduateDao) {
        this.graduateDao = graduateDao;
    }

    @Override
    public DataResult<List<Graduate>> getAll() {
        return new SuccessDataResult<>(this.graduateDao.findAll(), "Data listed");
    }

    @Override
    public Result add(Graduate graduate) {
        if(graduateDao.existsByDescription(graduate.getDescription())){
            return new ErrorResult("Already exists.");
        }

        this.graduateDao.save(graduate);
        return new SuccessResult("Saved");
    }
}
