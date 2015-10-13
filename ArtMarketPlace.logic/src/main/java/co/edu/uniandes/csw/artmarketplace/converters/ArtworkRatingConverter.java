/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.converters;

import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkRatingDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkRatingEntity;

/**
 * La clase ArtworkRatingConverter tiene como finalidad servir de intermediador entre los objetos DTO
 * y los objeto Entity relacionados con la votacion realizada por un comprador frente a una obra de arte.
 * @author lf.mendivelso10
 * @version 1.0.0
 */
public abstract class ArtworkRatingConverter {
    
    /**
     * Este metodo se encarga de hacer la conversion de un objeto del tipo
     * Entity a un objeto DTO del tipo ArtworkRating.
     * @param artworkRating  es la entidad a convertir
     * @return un objeto del tipo DTO de ArtworkRating
     */
    public static ArtworkRatingDTO basicArtworkRatingEntity2DTO(ArtworkRatingEntity artworkRating){
        if(artworkRating != null){
            ArtworkRatingDTO dto = new ArtworkRatingDTO();
            dto.setId(artworkRating.getId());
            dto.setClient(ClientConverter.fullEntity2DTO(artworkRating.getClient()));
            return dto;
        }
        else{
            return null;
        }
    }
    
    /**
     * Este metodo se encarga de hacer la conversion de un objeto del tipo
     * Entity a un objeto DTO del tipo ArtworkRating solo con fines de referencia.
     * @param artworkRating  es el DTO a convertir
     * @return un objeto del tipo Entity de ArtworkRating
     */
    public static ArtworkRatingEntity basicArtworkRatingDTO2Entity(ArtworkRatingDTO artworkRating){
        if(artworkRating != null){
            ArtworkRatingEntity entity = new ArtworkRatingEntity();
            entity.setId(artworkRating.getId());
            entity.setClient(ClientConverter.fullDTO2Entity(artworkRating.getClient()));
            return entity;
        }
        else{
            return null;
        }
    }
    
}
