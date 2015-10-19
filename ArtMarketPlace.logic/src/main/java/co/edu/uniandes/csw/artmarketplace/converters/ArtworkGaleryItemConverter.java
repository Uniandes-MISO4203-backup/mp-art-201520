package co.edu.uniandes.csw.artmarketplace.converters;

import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkGaleryItemDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.artmarketplace.entities.ArtistEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkGaleryItemEntity;

/**
 * @generated
 */
public abstract class ArtworkGaleryItemConverter {

    /**
     * @generated
     */
    private ArtworkGaleryItemConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static ArtworkGaleryItemDTO refEntity2DTO(ArtworkGaleryItemEntity entity) {
        if (entity != null) {
            ArtworkGaleryItemDTO dto = new ArtworkGaleryItemDTO();
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
    public static ArtworkGaleryItemEntity refDTO2Entity(ArtworkGaleryItemDTO dto) {
        if (dto != null) {
            ArtworkGaleryItemEntity entity = new ArtworkGaleryItemEntity();
            entity.setId(dto.getId());
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static ArtworkGaleryItemDTO fullEntity2DTO(ArtworkGaleryItemEntity entity) {
        if (entity != null) {
            ArtworkGaleryItemDTO dto = new ArtworkGaleryItemDTO();
            dto.setId(entity.getId());
            dto.setType(entity.getType());
            dto.setLink(entity.getLink());
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static ArtworkGaleryItemEntity fullDTO2Entity(ArtworkGaleryItemDTO dto) {
        if (dto != null) {
            ArtworkGaleryItemEntity entity = new ArtworkGaleryItemEntity();
            entity.setId(dto.getId());
            entity.setType(dto.getType());
            entity.setLink(dto.getLink());
            return entity;
        } else {
            return null;
        }
    }
}
