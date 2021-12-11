package com.scrumteam10.photograplife.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Publications")
public class PublicationsModels {
    @Id
    private String id;
    private String title;
    private String textPublication;
    private Date fecha = new Date();

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTextPublication() {
        return textPublication;
    }
    public void setTextPublication(String textPublication) {
        this.textPublication = textPublication;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    

    

    
}
