package com.scrumteam10.photograplife.services;

import java.util.List;
import java.util.Optional;

import com.scrumteam10.photograplife.models.UsersModels;
import com.scrumteam10.photograplife.repositories.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServices {
    @Autowired
    UsersRepository usersR;

    public void saveUsers(UsersModels user) {
        this.usersR.save(user);
    }

    public List<UsersModels> listUsers() {
        return this.usersR.findAll();
    }

    public Optional<UsersModels> SearchById(String id){
        return this.usersR.findById(id);
    }

    public void deleteuser(String id){
        this.usersR.deleteById(id);
    }
    
    public UsersModels searchUsername(String username) {
        return this.usersR.findByuserName(username).orElse(new UsersModels());
    }
 }
