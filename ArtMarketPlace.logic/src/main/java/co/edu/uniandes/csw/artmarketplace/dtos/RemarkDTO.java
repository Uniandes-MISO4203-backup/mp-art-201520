/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.dtos;

import java.util.Calendar;

/**
 * DTO para comentario
 */
public class RemarkDTO extends BasicDTO {

    /*
     Usuario que realizo el comentario.
     */
    private String remarkUser;

    /*
     Tipo de usuario: artista o cliente.
     */
    private String userType;

    /*
     Texto del comentario.
     */
    private String description;

    /*
     Fecha del comentario.
     */
    private Calendar remarkDate;

    /*
     Obra de arte a la que pertenece el comentario.
     */
    private ArtworkDTO artwork;

    /**
     * Retorna el tipo de usuario.
     *
     * @return userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Establece el tipo de usuario.
     *
     * @param userType
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * Retorna el usuario del comentario.
     *
     * @return remarkUser
     */
    public String getRemarkUser() {
        return remarkUser;
    }

    /**
     * Establece el usuario del comentario.
     *
     * @param remarkUser
     */
    public void setRemarkUser(String remarkUser) {
        this.remarkUser = remarkUser;
    }

    /**
     * Retorna la fecha del comentario.
     *
     * @return remarkDate
     */
    public Calendar getRemarkDate() {
        return remarkDate;
    }

    /**
     * Establece la fecha del comentario.
     *
     * @param remarkDate
     */
    public void setRemarkDate(Calendar remarkDate) {
        this.remarkDate = remarkDate;
    }

    /**
     * Retorna la descripcion del comentario.
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Establece la descripcion del comentario.
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retorna la obra de arte a la que pertenece el comentario.
     *
     * @return artwork
     */
    public ArtworkDTO getArtwork() {
        return artwork;
    }

    /**
     * Establece la obra de arte a la que pertenece el comentario.
     *
     * @param artwork
     */
    public void setArtwork(ArtworkDTO artwork) {
        this.artwork = artwork;
    }
}
