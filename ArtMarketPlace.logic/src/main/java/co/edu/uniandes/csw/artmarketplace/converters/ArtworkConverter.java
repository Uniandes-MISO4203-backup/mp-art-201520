package co.edu.uniandes.csw.artmarketplace.converters;

import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.artmarketplace.entities.ArtistEntity;

/**
 * @generated
 */
public abstract class ArtworkConverter {

    /**
     * @generated
     */
    private ArtworkConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static ArtworkDTO refEntity2DTO(ArtworkEntity entity) {
        if (entity != null) {
            ArtworkDTO dto = new ArtworkDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setPicture(entity.getPicture());
            dto.setPrice(entity.getPrice());

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
    public static ArtworkEntity refDTO2Entity(ArtworkDTO dto) {
        if (dto != null) {
            ArtworkEntity entity = new ArtworkEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static ArtworkDTO basicEntity2DTO(ArtworkEntity entity) {
        if (entity != null) {
            ArtworkDTO dto = new ArtworkDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setPicture(entity.getPicture());
            dto.setPrice(entity.getPrice());
            dto.setArtist(ArtistConverter.refEntity2DTO(entity.getArtist()));

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static ArtworkEntity basicDTO2Entity(ArtworkDTO dto) {
        if (dto != null) {
            ArtworkEntity entity = new ArtworkEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setPicture(dto.getPicture());
            entity.setPrice(dto.getPrice());
            entity.setArtist(ArtistConverter.refDTO2Entity(dto.getArtist()));

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static ArtworkDTO fullEntity2DTO(ArtworkEntity entity) {
        if (entity != null) {
            ArtworkDTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static ArtworkEntity fullDTO2Entity(ArtworkDTO dto) {
        if (dto != null) {
            ArtworkEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<ArtworkDTO> listEntity2DTO(List<ArtworkEntity> entities) {
        List<ArtworkDTO> dtos = new ArrayList<ArtworkDTO>();
        if (entities != null) {
            for (ArtworkEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<ArtworkEntity> listDTO2Entity(List<ArtworkDTO> dtos) {
        List<ArtworkEntity> entities = new ArrayList<ArtworkEntity>();
        if (dtos != null) {
            for (ArtworkDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

    /**
     * @generated
     */
    public static ArtworkEntity childDTO2Entity(ArtworkDTO dto, ArtistEntity parent){
        ArtworkEntity entity = basicDTO2Entity(dto);
        entity.setArtist(parent);
        return entity;
    }

    /**
     * @generated
     */
    public static List<ArtworkEntity> childListDTO2Entity(List<ArtworkDTO> dtos, ArtistEntity parent) {
        List<ArtworkEntity> entities = new ArrayList<ArtworkEntity>();
        if (dtos != null) {
            for (ArtworkDTO dto : dtos) {
                entities.add(childDTO2Entity(dto, parent));
            }
        }
        return entities;
    }
}
