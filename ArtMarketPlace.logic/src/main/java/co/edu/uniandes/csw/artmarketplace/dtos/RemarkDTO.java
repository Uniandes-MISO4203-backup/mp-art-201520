/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.dtos;

import java.util.Date;

/**
 * DTO para comentario
 */
 public class RemarkDTO
 {
     
    private Long id;
    
    /*
    Usuario que realiz� el comentario.
    */
    private String remarkUser;
    
    /*
    Texto del comentario.
    */
    private String description;
    
    /*
    Fecha del comentario.
    */
    private Date remarkDate;

    /*
    Obra de arte a la que pertenece el comentario.
    */
    private ArtworkDTO artwork;

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
     * Retorna la descripci�n del comentario.
     * @return description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Establece la descripci�n del comentario.
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
    public ArtworkDTO getArtwork()
    {
        return artwork;
    } 

    /**
     * Establece la obra de arte a la que pertenece el comentario.
     * @param artwork 
     */
    public void setArtwork(ArtworkDTO artwork)
    {
        this.artwork = artwork;
    }
 }