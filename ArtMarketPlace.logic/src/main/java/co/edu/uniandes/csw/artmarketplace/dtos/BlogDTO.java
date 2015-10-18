/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.dtos;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jh.rubiano10
 */
@XmlRootElement
public class BlogDTO {
    
    /**
     * id/llave de un a entrada del Blog.
     */
    private Long id;
    
    /**
     * Texto de la entrada del Blog.
     */
    private String entry;
    
    /**
     * Título del Blog.
     */
    private String title;
    
    /**
     * Fecha de Creación de la entrada
     */
    private Date date;
    
    /**
     * Id del cliente/artista que realizó la entrada al Blog
     */
    private Long client_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }
    
}
