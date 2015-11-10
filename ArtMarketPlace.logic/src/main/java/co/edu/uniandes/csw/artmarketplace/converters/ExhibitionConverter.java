package co.edu.uniandes.csw.artmarketplace.converters;

import co.edu.uniandes.csw.artmarketplace.dtos.ExhibitionDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ExhibitionEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ResumeEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase ExhibitionConverter tiene como objetivo service de intermediador
 * para el patron DTO de la información correspondiente a exhibiciones
 * registradas en el resumen de un artista.
 *
 * @author lf.mendivelso10
 */
public class ExhibitionConverter {

    /**
     * @generated
     */
    private ExhibitionConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static ExhibitionDTO refEntity2DTO(ExhibitionEntity entity) {
        if (entity != null) {
            ExhibitionDTO dto = new ExhibitionDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setDescription(entity.getDescription());
            dto.setStartDate(entity.getStartDate());
            dto.setEndDate(entity.getEndDate());
            dto.setPlace(entity.getPlace());
            dto.setAwards(entity.getAwards());
            dto.setKindOfEvent(entity.getKindOfEvent());
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
    public static ExhibitionEntity refDTO2Entity(ExhibitionDTO dto) {
        if (dto != null) {
            ExhibitionEntity entity = new ExhibitionEntity();
            entity.setId(dto.getId());
            return entity;
        } else {
            return null;
        }
    }

    /**
     *
     * @param entity
     * @return
     */
    private static ExhibitionDTO basicEntity2DTO(ExhibitionEntity entity) {
        if (entity != null) {
            ExhibitionDTO dto = refEntity2DTO(entity);
            dto.setResume(ResumeConverter.refEntity2DTO(entity.getResume()));
            return dto;
        } else {
            return null;
        }
    }

    /**
     *
     * @param dto
     * @return
     */
    private static ExhibitionEntity basicDTO2Entity(ExhibitionDTO dto) {
        if (dto != null) {
            ExhibitionEntity entity = new ExhibitionEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setDescription(dto.getDescription());
            entity.setStartDate(dto.getStartDate());
            entity.setEndDate(dto.getEndDate());
            entity.setPlace(dto.getPlace());
            entity.setAwards(dto.getAwards());
            entity.setKindOfEvent(dto.getKindOfEvent());
            entity.setResume(ResumeConverter.refDTO2Entity(dto.getResume()));
            return entity;
        } else {
            return null;
        }
    }

    /**
     *
     * @param entity
     * @return
     */
    public static ExhibitionDTO fullEntity2DTO(ExhibitionEntity entity) {
        if (entity != null) {
            return basicEntity2DTO(entity);
        } else {
            return null;
        }
    }

    /**
     *
     * @param dto
     * @return
     */
    public static ExhibitionEntity fullDTO2Entity(ExhibitionDTO dto) {
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
    public static List<ExhibitionDTO> listEntity2DTO(List<ExhibitionEntity> entities) {
        List<ExhibitionDTO> dtos = new ArrayList<ExhibitionDTO>();
        if (entities != null) {
            for (ExhibitionEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     *
     * @param dtos
     * @return
     */
    public static List<ExhibitionEntity> listDTO2Entity(List<ExhibitionDTO> dtos) {
        List<ExhibitionEntity> entities = new ArrayList<ExhibitionEntity>();
        if (dtos != null) {
            for (ExhibitionDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

    /**
     *
     * @param dto
     * @param parent
     * @return
     */
    public static ExhibitionEntity childDTO2Entity(ExhibitionDTO dto, ResumeEntity parent) {
        ExhibitionEntity entity = basicDTO2Entity(dto);
        entity.setResume(parent);
        return entity;
    }

    /**
     *
     * @param dtos
     * @param parent
     * @return
     */
    public static List<ExhibitionEntity> childListDTO2Entity(List<ExhibitionDTO> dtos, ResumeEntity parent) {
        List<ExhibitionEntity> entities = new ArrayList<ExhibitionEntity>();
        if (dtos != null) {
            for (ExhibitionDTO dto : dtos) {
                entities.add(childDTO2Entity(dto, parent));
            }
        }
        return entities;
    }

}
