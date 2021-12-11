package com.scrumteam10.photograplife.repositories;


import java.util.Optional;

import com.scrumteam10.photograplife.models.UsersModels;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsersRepository extends MongoRepository<UsersModels,String> {
    public Optional<UsersModels> findByuserName(String username);
}
