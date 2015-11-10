package co.edu.uniandes.csw.artmarketplace.converters;

import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkGaleryItemDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
import java.util.ArrayList;
import java.util.List;
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
     * @param entity
     * @return
     * @generated
     */
    public static ArtworkGaleryItemDTO basicEntity2DTO(ArtworkGaleryItemEntity entity) {
        if (entity != null) {
            ArtworkGaleryItemDTO dto = new ArtworkGaleryItemDTO();
            dto.setId(entity.getId());
            dto.setType(TypeConverter.refEntity2DTO(entity.getType()));
            dto.setLink(entity.getLink());
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
    public static ArtworkGaleryItemEntity basicDTO2Entity(ArtworkGaleryItemDTO dto) {
        if (dto != null) {
            ArtworkGaleryItemEntity entity = new ArtworkGaleryItemEntity();
            entity.setId(dto.getId());
            entity.setType(TypeConverter.refDTO2Entity(dto.getType()));
            entity.setLink(dto.getLink());
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static ArtworkGaleryItemDTO fullEntity2DTO(ArtworkGaleryItemEntity entity) {
        if (entity != null) {
            return basicEntity2DTO(entity);
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return
     * @generated
     */
    public static ArtworkGaleryItemEntity fullDTO2Entity(ArtworkGaleryItemDTO dto) {
        if (dto != null) {
            return basicDTO2Entity(dto);
        } else {
            return null;
        }
    }

    /**
     *
     * @param entities
     * @return
     */
    public static List<ArtworkGaleryItemDTO> listEntity2DTO(List<ArtworkGaleryItemEntity> entities) {
        List<ArtworkGaleryItemDTO> dtos = new ArrayList<ArtworkGaleryItemDTO>();
        if (entities != null) {
            for (ArtworkGaleryItemEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @param dtos
     * @return
     */
    public static List<ArtworkGaleryItemEntity> listDTO2Entity(List<ArtworkGaleryItemDTO> dtos) {
        List<ArtworkGaleryItemEntity> entities = new ArrayList<ArtworkGaleryItemEntity>();
        if (dtos != null) {
            for (ArtworkGaleryItemDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

    /**
     * @param dto
     * @param parent
     * @return
     */
    public static ArtworkGaleryItemEntity childDTO2Entity(ArtworkGaleryItemDTO dto, ArtworkEntity parent) {
        ArtworkGaleryItemEntity entity = basicDTO2Entity(dto);
        entity.setArtwork(parent);
        return entity;
    }

    /**
     * @param dtos
     * @param parent
     * @return
     */
    public static List<ArtworkGaleryItemEntity> childListDTO2Entity(List<ArtworkGaleryItemDTO> dtos, ArtworkEntity parent) {
        List<ArtworkGaleryItemEntity> entities = new ArrayList<ArtworkGaleryItemEntity>();
        if (dtos != null) {
            for (ArtworkGaleryItemDTO dto : dtos) {
                entities.add(childDTO2Entity(dto, parent));
            }
        }
        return entities;
    }
}
