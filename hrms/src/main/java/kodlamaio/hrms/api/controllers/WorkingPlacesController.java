package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.WorkingPlaceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkingPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/workingplaces")
public class WorkingPlacesController {
    private final WorkingPlaceService workingPlaceService;

    @Autowired
    public WorkingPlacesController(WorkingPlaceService workingPlaceService) {
        this.workingPlaceService = workingPlaceService;
    }

    @GetMapping("/getall")
    public DataResult<List<WorkingPlace>> getAll() {
        return this.workingPlaceService.getAll();
    }
}
