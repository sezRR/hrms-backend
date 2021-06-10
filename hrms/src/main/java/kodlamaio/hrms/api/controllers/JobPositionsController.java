package kodlamaio.hrms.api.controllers;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
@CrossOrigin
public class JobPositionsController {
	
	private final JobPositionService jobPositionService;

	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		return this.jobPositionService.getAll();
	}

	@PostMapping("/getbyposition")
	public DataResult<List<JobPosition>> getByPosition(@RequestParam String position){
		return this.jobPositionService.getByPosition(position.trim());
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobPosition jobPosition){
		return this.jobPositionService.add(jobPosition);
	}
}
