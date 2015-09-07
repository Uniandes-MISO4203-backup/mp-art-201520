/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 * Representa un comentario de una obra de arte.
 */
@Entity
public class RemarkEntity implements Serializable
{
    
    @Id
    @GeneratedValue(generator = "Remark")
    private Long id;
    
    /*
    Usuario que realizó el comentario.
    */
    private String remarkUser;
    
    /*
    Texto del comentario.
    */
    private String description;
    
    /*
    Fecha del comentario.
    */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date remarkDate;

    /*
    Obra de arte a la que pertenece el comentario.
    */
    @ManyToOne
    private ArtworkEntity artwork;

    /**
     * Retorna el Id del comentario.
     * @return id
     */
    public Long getId()
    {
        return id;
    }

    /**
     * Establece el Id del comentario.
     * @param id 
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * Retorna el usuario del comentario.
     * @return remarkUser
     */
    public String getRemarkUser()
    {
        return remarkUser;
    }

    /**
     * Establece el usuario del comentario.
     * @param remarkUser
     */
    public void setRemarkUser(String remarkUser)
    {
        this.remarkUser = remarkUser;
    }

    /**
     * Retorna la descripción del comentario.
     * @return description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Establece la descripción del comentario.
     * @param description 
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Retorna la fecha del comentario.
     * @return remarkDate
     */
    public Date getRemarkDate()
    {
        return remarkDate;
    }

    /**
     * Establece la fecha del comentario.
     * @param remarkDate
     */
    public void setRemarkDate(Date remarkDate)
    {
        this.remarkDate = remarkDate;
    }

    /**
     * Retorna la obra de arte a la que pertenece el comentario.
     * @return artwork
     */
    public ArtworkEntity getArtwork()
    {
        return artwork;
    } 

    /**
     * Establece la obra de arte a la que pertenece el comentario.
     * @param artwork 
     */
    public void setArtwork(ArtworkEntity artwork)
    {
        this.artwork = artwork;
    }
}