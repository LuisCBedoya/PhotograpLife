package com.scrumteam10.photograplife.controllers;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import com.scrumteam10.photograplife.models.ImagesModels;
import com.scrumteam10.photograplife.services.ImagesServices;
import com.scrumteam10.photograplife.services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class ImagesController {
    
    @Autowired
    ImagesServices imgS;
    UsersServices userS;
    
    @PostMapping("/images")
    public ResponseEntity<Map<String,String>> upload(@RequestParam("file") MultipartFile file, ImagesModels img){
        Map<String, String> message= new HashMap<>();
        if(!file.isEmpty()){
            String nameFile = UUID.randomUUID().toString() + "_" + file.getOriginalFilename().replace(" ","");
            Path rutaFila = Paths.get("uploads").resolve(nameFile).toAbsolutePath();

            try {
                Files.copy(file.getInputStream(), rutaFila);
            } catch (Exception e) {
                message.put("mensaje","No se pudo subir imagen" + nameFile);
            }
            img.setImage(nameFile);
            imgS.saveImgs(img);
        }
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
