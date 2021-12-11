package com.scrumteam10.photograplife.repositories;

import com.scrumteam10.photograplife.models.ImagesModels;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ImagesRepository extends MongoRepository<ImagesModels,String> {
    
}
