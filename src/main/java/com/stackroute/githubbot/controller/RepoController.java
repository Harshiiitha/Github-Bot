package com.stackroute.githubbot.controller;

import com.stackroute.githubbot.domain.Repository;
import com.stackroute.githubbot.service.RepoService;
import com.stackroute.githubbot.service.RepoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class RepoController {

    private RepoService repoService;

    @Autowired
    public RepoController(RepoService repoService) {
        this.repoService = repoService;
    }

    @PostMapping("repository")
    public ResponseEntity<?> saveRepositoryToWishlist(@RequestBody Repository repository)
    {

        ResponseEntity responseEntity;
        Repository savedRepository=null;
        savedRepository = repoService.saveRepository(repository);
        responseEntity = new ResponseEntity<Repository>(savedRepository, HttpStatus.CREATED);
        return responseEntity;

    }
    @GetMapping("repositories")
    public ResponseEntity<?> getAllRepositoriesFromWishlist()
    {
        return new ResponseEntity<List>(repoService.getAllRepositories(), HttpStatus.OK);

    }

    @PutMapping("repository/{name}/{description}")
    public ResponseEntity<?> getRepositoryAfterUpdatingDescription(@PathVariable String name, @PathVariable  String description)
    {

        ResponseEntity responseEntity;
        responseEntity=new ResponseEntity<Repository>(repoService.updateRepositoryDescription(name,description), HttpStatus.OK);
        return responseEntity;

    }

    @DeleteMapping("repository/{name}")
    public ResponseEntity<?> getRepositoryAfterDeleting(@PathVariable String name)
    {

        ResponseEntity responseEntity;
        responseEntity=new ResponseEntity<Repository>(repoService.deleteRepository(name), HttpStatus.OK);
        return responseEntity;

    }

}
