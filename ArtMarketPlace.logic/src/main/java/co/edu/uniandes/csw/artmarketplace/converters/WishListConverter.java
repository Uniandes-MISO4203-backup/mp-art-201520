/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.converters;

import co.edu.uniandes.csw.artmarketplace.dtos.WishListDTO;
import co.edu.uniandes.csw.artmarketplace.entities.WishListEntity;

/**
 *
 * @author ms.lancheros10
 */
public class WishListConverter {

    private WishListConverter() {
    }
    
    /**
     * @param entity
     * @return
     * @generated
     */
    public static WishListDTO refEntity2DTO(WishListEntity entity) {
        if (entity != null) {
            WishListDTO dto = new WishListDTO();
            dto.setId(entity.getId());
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return
     * @generated
     */
    public static WishListEntity refDTO2Entity(WishListDTO dto) {
        if (dto != null) {
            WishListEntity entity = new WishListEntity();
            entity.setId(dto.getId());
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static WishListDTO basicEntity2DTO(WishListEntity entity) {
        if (entity != null) {
            WishListDTO dto = new WishListDTO();
            dto.setId(entity.getId());
            dto.setClient(ClientConverter.refEntity2DTO(entity.getClient()));
            dto.setArtwork(ArtworkConverter.basicEntity2DTO(entity.getArtwork()));
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static WishListEntity basicDTO2Entity(WishListDTO dto) {
        if (dto != null) {
            WishListEntity entity = new WishListEntity();
            entity.setId(dto.getId());
            entity.setClient(ClientConverter.refDTO2Entity(dto.getClient()));
            entity.setArtwork(ArtworkConverter.refDTO2Entity(dto.getArtwork()));
            return entity;
        } else {
            return null;
        }
    }
 
}
