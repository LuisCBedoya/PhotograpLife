package com.scrumteam10.photograplife.services;

import java.util.List;
import java.util.Optional;

import com.scrumteam10.photograplife.models.PublicationsModels;
import com.scrumteam10.photograplife.repositories.PublicationsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicationsServices {
    @Autowired
    PublicationsRepository pbR;

    public void savePublication(PublicationsModels pb) {
        this.pbR.save(pb);
    }
    
    public List<PublicationsModels> listAllPublications() {
        return this.pbR.findAll();
     }

     public void deletePublications(String id){
        this.pbR.deleteById(id);
    }

    public Optional<PublicationsModels> searchPublicationId(String id){
        return this.pbR.findById(id);
    }

}
