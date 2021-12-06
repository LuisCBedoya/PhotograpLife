package com.scrumteam10.photograplife.repositories;

import com.scrumteam10.photograplife.models.PublicationsModels;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PublicationsRepository extends MongoRepository<PublicationsModels,String> {
    
}
