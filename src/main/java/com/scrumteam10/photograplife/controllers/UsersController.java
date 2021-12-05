package com.scrumteam10.photograplife.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.scrumteam10.photograplife.models.UsersModels;

import com.scrumteam10.photograplife.services.UsersServices;
import com.scrumteam10.photograplife.utils.Authorization;
import com.scrumteam10.photograplife.utils.BCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    UsersServices userS;

    @PostMapping("/user")
    public ResponseEntity<Map<String, String>> Save_User_data(@RequestBody UsersModels user) {
        Map<String, String> message = new HashMap<>();

        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        UsersModels u = this.userS.searchUsername(user.getUserName());

        if (u.getId() == null) {
            this.userS.saveUsers(user);
            message.put("mensaje", "Registro Exitoso");
        } else {
            message.put("mensaje", "Usuario existente");
        }

        return ResponseEntity.ok(message);
    }

    @PostMapping("/user/upload")
    public ResponseEntity<Map<String, String>> upload(@RequestParam("file") MultipartFile file,
            @RequestParam("id") String id) {
        Map<String, String> message = new HashMap<>();
        UsersModels user = this.userS.SearchById(id).orElse(new UsersModels());
        if (!file.isEmpty()) {
            String nameFile = UUID.randomUUID().toString() + "_" + file.getOriginalFilename().replace(" ", "");
            Path rutaFila = Paths.get("UserImages").resolve(nameFile).toAbsolutePath();

            try {
                Files.copy(file.getInputStream(), rutaFila);
            } catch (Exception e) {
                message.put("mensaje", "No se pudo subir imagen" + nameFile);
            }
            String previousImage = user.getUserImage();
            if (previousImage != null && previousImage.length() > 0) {
                Path rutaPreviousImage = Paths.get("UserImages").resolve(previousImage).toAbsolutePath();
                File previousImageFile = rutaPreviousImage.toFile();
                if (previousImageFile.exists() && previousImageFile.canRead()) {
                    previousImageFile.delete();
                }
            }

            user.setUserImage(nameFile);
            this.userS.saveUsers(user);
        }
        message.put("mensaje", "Imagen de usuario cargada con exito");
        return ResponseEntity.ok(message);
    }

    @PostMapping("/user/login")
    public ResponseEntity<Map<String, String>> user_Account(@RequestBody UsersModels user) {
        Map<String, String> message = new HashMap<>();
        UsersModels aux = this.userS.searchUsername(user.getUserName());
        if (aux.getUserName() == null) {
            message.put("mensaje", "Usuario o contraseña incorrectos");
        } else {
            if (!BCrypt.checkpw(user.getPassword(), aux.getPassword())) {
                message.put("mensaje", "Usuario o contraseña incorrectos");
            } else {
                String hash = "";
                long time = System.currentTimeMillis();
                if (aux.getId() != null) {
                    hash = Jwts.builder().signWith(SignatureAlgorithm.HS256, Authorization.KEY)
                            .setSubject(aux.getName()).setIssuedAt(new Date(time))
                            .setExpiration(new Date(time + 900000)).claim("userName", aux.getUserName())
                            .claim("email", aux.getEmail()).compact();
                }
                aux.setHash(hash);
                message.put("mensaje", "Se accedió correctamente");
                message.put("token", hash);
            }

        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("/user")
    public List<UsersModels> showUsers() {
        return this.userS.listUsers();
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable String id) {
        Map<String, String> message = new HashMap<>();
        UsersModels user = this.userS.SearchById(id).orElse(new UsersModels());
        String previousImage = user.getUserImage();
        if (previousImage != null && previousImage.length() > 0) {
            Path rutaPreviousImage = Paths.get("UserImages").resolve(previousImage).toAbsolutePath();
            File previousImageFile = rutaPreviousImage.toFile();
            if (previousImageFile.exists() && previousImageFile.canRead()) {
                previousImageFile.delete();
            }
        }
        this.userS.deleteuser(id);
        message.put("mensaje", "Cuenta borrada");
        return ResponseEntity.ok(message);
    }
}
