/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.converters;

import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkRatingDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkRatingEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase ArtworkRatingConverter tiene como finalidad servir de intermediador
 * entre los objetos DTO y los objeto Entity relacionados con la votacion
 * realizada por un comprador frente a una obra de arte.
 *
 * @author lf.mendivelso10
 * @version 1.0.0
 */
public class ArtworkRatingConverter {

    private ArtworkRatingConverter(){}
    /**
     * Este metodo se encarga de hacer la conversion de un objeto del tipo
     * Entity a un objeto DTO del tipo ArtworkRating.
     *
     * @param artworkRating es la entidad a convertir
     * @return un objeto del tipo DTO de ArtworkRating
     */
    public static ArtworkRatingDTO basicArtworkRatingEntity2DTO(ArtworkRatingEntity artworkRating) {
        if (artworkRating != null) {
            ArtworkRatingDTO dto = new ArtworkRatingDTO();
            dto.setId(artworkRating.getId());
            dto.setClient(ClientConverter.fullEntity2DTO(artworkRating.getClient()));
            dto.setArtwork(ArtworkConverter.refEntity2DTO(artworkRating.getArtwork()));
            return dto;
        } else {
            return null;
        }
    }

    /**
     * Este metodo se encarga de hacer la conversion de un objeto del tipo
     * Entity a un objeto DTO del tipo ArtworkRating solo con fines de
     * referencia.
     *
     * @param artworkRating es el DTO a convertir
     * @return un objeto del tipo Entity de ArtworkRating
     */
    public static ArtworkRatingEntity basicArtworkRatingDTO2Entity(ArtworkRatingDTO artworkRating) {
        if (artworkRating != null) {
            ArtworkRatingEntity entity = new ArtworkRatingEntity();
            entity.setId(artworkRating.getId());
            entity.setClient(ClientConverter.fullDTO2Entity(artworkRating.getClient()));
            entity.setArtwork(ArtworkConverter.refDTO2Entity(artworkRating.getArtwork()));
            return entity;
        } else {
            return null;
        }
    }

    /**
     * Este metodo esta disennado para hacer la conversion de un lista de
     * objectos DTO a un lista de objetos Entity correspondiente a la logica de
     * ArtworkRating.
     *
     * @param list es la lista de Objetos DTO a convertir
     * @return una lista de objectos Entity del tipo ArtworkRatingEntity.
     */
    public static List<ArtworkRatingEntity> listArtworkRatingDTO2Entity(List<ArtworkRatingDTO> list) {
        List<ArtworkRatingEntity> result = new ArrayList<ArtworkRatingEntity>();
        if (list != null && !list.isEmpty()) {
            for (ArtworkRatingDTO dto : list) {
                result.add(basicArtworkRatingDTO2Entity(dto));
            }
        }
        return result;
    }

    /**
     * Este metodo esta disenado para hacer la conversion de un lista de
     * objectos Entity a un lista de objetos DTO correspondiente a la logica de
     * ArtworkRating.
     *
     * @param list es la lista de Objetos DTO a convertir
     * @return una lista de objectos Entity del tipo ArtworkRatingEntity.
     */
    public static List<ArtworkRatingDTO> listArtworkRatingEntity2DTO(List<ArtworkRatingEntity> list) {
        List<ArtworkRatingDTO> result = new ArrayList<ArtworkRatingDTO>();
        if (list != null && !list.isEmpty()) {
            for (ArtworkRatingEntity entity : list) {
                result.add(basicArtworkRatingEntity2DTO(entity));
            }
        }
        return result;
    }
}
