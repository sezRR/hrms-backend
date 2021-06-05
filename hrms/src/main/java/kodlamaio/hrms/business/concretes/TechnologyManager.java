package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.converter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.TechnologyDao;
import kodlamaio.hrms.entities.concretes.Technology;
import kodlamaio.hrms.entities.dtos.TechnologyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {

    private final TechnologyDao technologyDao;
    private final DtoConverterService dtoConverterService;

    @Autowired
    public TechnologyManager(TechnologyDao technologyDao, DtoConverterService dtoConverterService) {
        this.technologyDao = technologyDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public DataResult<List<Technology>> getAll() {
        return new SuccessDataResult<>(this.technologyDao.findAll());
    }

    @Override
    public Result add(TechnologyDto technologyDto) {
        this.technologyDao.save((Technology)this.dtoConverterService.dtoToBaseClassConverter(technologyDto, Technology.class));
        return new SuccessResult("Added");
    }
}
