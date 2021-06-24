package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.FavoriteJobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.FavoriteJobAdvert;
import kodlamaio.hrms.entities.dtos.FavoriteJobAdvertAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/favoritejobadvert")
public class FavoriteJobAdvertController {
    private final FavoriteJobAdvertService favoriteJobAdvertService;

    @Autowired
    public FavoriteJobAdvertController(FavoriteJobAdvertService favoriteJobAdvertService) {
        this.favoriteJobAdvertService = favoriteJobAdvertService;
    }

    @GetMapping("/getall")
    public DataResult<List<FavoriteJobAdvert>> getAll(){
        return this.favoriteJobAdvertService.getAll();
    }

    @GetMapping("/getallbycandidateuser")
    public DataResult<List<FavoriteJobAdvert>> getAllByCandidateUser(@Valid @RequestParam int candidateUserId){
        return this.favoriteJobAdvertService.getAllByCandidateUser(candidateUserId);
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody FavoriteJobAdvertAddDto favoriteJobAdvertAddDto){
        return this.favoriteJobAdvertService.add(favoriteJobAdvertAddDto);
    }
}
