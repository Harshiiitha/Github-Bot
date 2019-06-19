package com.stackroute.githubbot.service;

import com.stackroute.githubbot.domain.Repository;

import java.util.List;

public interface RepoService {

    public Repository saveRepository(Repository repository);

    public List<Repository> getAllRepositories();

    public Repository updateRepositoryDescription(String name,String description);

    public Repository deleteRepository(String name);


}
