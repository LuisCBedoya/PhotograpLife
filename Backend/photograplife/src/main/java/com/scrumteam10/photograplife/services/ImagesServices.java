package com.scrumteam10.photograplife.services;

import java.util.List;

import com.scrumteam10.photograplife.models.ImagesModels;
import com.scrumteam10.photograplife.repositories.ImagesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagesServices {
    
    @Autowired
    ImagesRepository imgR;

    public void saveImgs(ImagesModels img) {
        this.imgR.save(img);
    }

    public List<ImagesModels> listAllImages() {
       return this.imgR.findAll();
    }

    public void deleteImgs(String id){
        this.imgR.deleteById(id);
    }
}
