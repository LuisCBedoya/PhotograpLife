package com.scrumteam10.photograplife.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UsersModels {
    @Id
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private String hash;
    private ImagesModels galleryUserImages;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getHash() {
        return hash;
    }
    public void setHash(String hash) {
        this.hash = hash;
    }
    public ImagesModels getGalleryUserImages() {
        return galleryUserImages;
    }
    public void setGalleryUserImages(ImagesModels galleryUserImages) {
        this.galleryUserImages = galleryUserImages;
    }

    
}
