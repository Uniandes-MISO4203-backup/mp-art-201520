package co.edu.uniandes.csw.artmarketplace.converters;

import co.edu.uniandes.csw.artmarketplace.dtos.ArtistDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ArtistEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @generated
 */
public abstract class ArtistConverter {

    /**
     * @generated
     */
    private ArtistConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static ArtistDTO refEntity2DTO(ArtistEntity entity) {
        if (entity != null) {
            ArtistDTO dto = new ArtistDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setUserId(entity.getUserId());

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
    public static ArtistEntity refDTO2Entity(ArtistDTO dto) {
        if (dto != null) {
            ArtistEntity entity = new ArtistEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static ArtistDTO basicEntity2DTO(ArtistEntity entity) {
        if (entity != null) {
            ArtistDTO dto = new ArtistDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setUserId(entity.getUserId());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static ArtistEntity basicDTO2Entity(ArtistDTO dto) {
        if (dto != null) {
            ArtistEntity entity = new ArtistEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setUserId(dto.getUserId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static ArtistDTO fullEntity2DTO(ArtistEntity entity) {
        if (entity != null) {
            ArtistDTO dto = basicEntity2DTO(entity);
            dto.setArtwork(ArtworkConverter.listEntity2DTO(entity.getArtwork()));
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static ArtistEntity fullDTO2Entity(ArtistDTO dto) {
        if (dto != null) {
            ArtistEntity entity = basicDTO2Entity(dto);
            entity.setArtwork(ArtworkConverter.childListDTO2Entity(dto.getArtwork(), entity));
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<ArtistDTO> listEntity2DTO(List<ArtistEntity> entities) {
        List<ArtistDTO> dtos = new ArrayList<ArtistDTO>();
        if (entities != null) {
            for (ArtistEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<ArtistEntity> listDTO2Entity(List<ArtistDTO> dtos) {
        List<ArtistEntity> entities = new ArrayList<ArtistEntity>();
        if (dtos != null) {
            for (ArtistDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

}
