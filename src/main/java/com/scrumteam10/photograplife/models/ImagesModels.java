package com.scrumteam10.photograplife.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Images")
public class ImagesModels {
    @Id
    private String id;
    private String Image;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getImage() {
        return Image;
    }
    public void setImage(String image) {
        Image = image;
    }
    
    

    
}
