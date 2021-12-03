package com.scrumteam10.photograplife.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scrumteam10.photograplife.models.ImagesModels;
import com.scrumteam10.photograplife.services.ImagesServices;

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
public class ImagesController {
    
    @Autowired
    ImagesServices imgS;
    
    @PostMapping("/images")
    public ResponseEntity<Map<String,String>> Save_Publication(@RequestBody ImagesModels img){
        Map<String, String> message= new HashMap<>();
        this.imgS.saveImgs(img);
        message.put("mensaje","Imagen Cargada Con exito");
        return ResponseEntity.ok(message);
    }

    @GetMapping("/images")
    public List<ImagesModels> allImages() {
        return this.imgS.listAllImages();
    }

    @DeleteMapping("images/{id}")
    public ResponseEntity<Map<String,String>> deleteImg(@PathVariable String id){
        Map<String, String> message= new HashMap<>();
        this.imgS.deleteImgs(id);
        message.put("mensaje","Imagen Eliminada");
        return ResponseEntity.ok(message);
    }
}
