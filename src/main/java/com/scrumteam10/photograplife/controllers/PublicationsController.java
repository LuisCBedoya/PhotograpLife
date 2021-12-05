package com.scrumteam10.photograplife.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scrumteam10.photograplife.models.PublicationsModels;

import com.scrumteam10.photograplife.services.PublicationsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PublicationsController {
    @Autowired
    PublicationsServices pbS;

    @PostMapping("/publications")
    public ResponseEntity<Map<String,String>> Save_Publication(@RequestBody PublicationsModels pb){
        Map<String, String> message= new HashMap<>();
        this.pbS.savePublication(pb);;
        message.put("mensaje","Publicada");
        return ResponseEntity.ok(message);
    }

    @GetMapping("/publications")
    public List<PublicationsModels> allPublications(){
        return this.pbS.listAllPublications();
    }

    @DeleteMapping("publications/{id}")
    public ResponseEntity<Map<String,String>> deleteUser(@PathVariable String id){
        Map<String, String> message= new HashMap<>();
        this.pbS.deletePublications(id);
        message.put("mensaje","Publicacion Eliminada");
        return ResponseEntity.ok(message);
    }
  
}
