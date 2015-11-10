package co.edu.uniandes.csw.artmarketplace.converters;

import co.edu.uniandes.csw.artmarketplace.dtos.TypeDTO;
import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.artmarketplace.entities.TypeEntity;

/**
 * @generated
 */
public abstract class TypeConverter {

    /**
     * @generated
     */
    private TypeConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static TypeDTO refEntity2DTO(TypeEntity entity) {
        if (entity != null) {
            TypeDTO dto = new TypeDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
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
    public static TypeEntity refDTO2Entity(TypeDTO dto) {
        if (dto != null) {
            TypeEntity entity = new TypeEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
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
    public static TypeDTO basicEntity2DTO(TypeEntity entity) {
        if (entity != null) {
            return refEntity2DTO(entity);
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return
     * @generated
     */
    public static TypeEntity basicDTO2Entity(TypeDTO dto) {
        if (dto != null) {
            return refDTO2Entity(dto);
        } else {
            return null;
        }
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static TypeDTO fullEntity2DTO(TypeEntity entity) {
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
    public static TypeEntity fullDTO2Entity(TypeDTO dto) {
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
    public static List<TypeDTO> listEntity2DTO(List<TypeEntity> entities) {
        List<TypeDTO> dtos = new ArrayList<TypeDTO>();
        if (entities != null) {
            for (TypeEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @param dtos
     * @return
     */
    public static List<TypeEntity> listDTO2Entity(List<TypeDTO> dtos) {
        List<TypeEntity> entities = new ArrayList<TypeEntity>();
        if (dtos != null) {
            for (TypeDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
}
