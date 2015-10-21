/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.converters;

import co.edu.uniandes.csw.artmarketplace.dtos.ExperienceDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ExperienceEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ResumeEntity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Convierte los objetos de DTO a Entidades y viceversa. Registro de expereincia
 * o educacion.
 *
 * @author vp.salcedo93
 */
public class ExperienceConverter {

    /**
     * Metodo constructor del conversor entre entidad y DTO del registro.
     */
    private ExperienceConverter() {
    }

    /**
     * Convierte entidad a Dto de los registros de la hoja de vida.
     *
     * @param entity. Entidad de los registros de la hoja de vida a convertir.
     * @return Objeto DTO de los registros de la hoja de vida.
     */
    public static ExperienceDTO refEntity2DTO(ExperienceEntity entity) {
        if (entity != null) {
            ExperienceDTO dto = new ExperienceDTO();
            dto.setId(entity.getId());
            dto.setTitle(entity.getTitle());
            dto.setPlace(entity.getPlace());
            dto.setStartDate(entity.getStartDate());
            dto.setFinishDate(entity.getFinishDate());
            dto.setType(entity.getType());
            return dto;
        } else {
            return null;
        }
    }

    /**
     * Convierte DTO a Entidad de los registros de la hoja de vida.
     *
     * @param dto. Objeto DTO de los registros de la hoja de vida.
     * @return Entidad de los registros de la hoja de vida.
     */
    public static ExperienceEntity refDTO2Entity(ExperienceDTO dto) {
        if (dto != null) {
            ExperienceEntity entity = new ExperienceEntity();
            entity.setId(dto.getId());
            return entity;
        } else {
            return null;
        }
    }

    /**
     * Conversor basico entidad a Dto de los registros de la hoja de vida.
     *
     * @param entity. Entidad de la hoja de vida a convertir.
     * @return Objeto DTO de la hoja de vida.
     */
    public static ExperienceDTO basicEntity2DTO(ExperienceEntity entity) {
        if (entity != null) {
            ExperienceDTO dto = new ExperienceDTO();
            dto.setId(entity.getId());
            dto.setTitle(entity.getTitle());
            dto.setPlace(entity.getPlace());
            dto.setStartDate(entity.getStartDate());
            dto.setFinishDate(entity.getFinishDate());
            dto.setResume(ResumeConverter.refEntity2DTO(entity.getResume()));
            dto.setType(entity.getType());
            return dto;
        } else {
            return null;
        }
    }

    /**
     * Conversor basico DTO a Entidad de los registros de la hoja de vida.
     *
     * @param dto. Objeto DTO de los registros de la hoja de vida.
     * @return Entidad de los registros de la hoja de vida.
     */
    public static ExperienceEntity basicDTO2Entity(ExperienceDTO dto) {
        if (dto != null) {
            ExperienceEntity entity = new ExperienceEntity();
            entity.setId(dto.getId());
            entity.setTitle(dto.getTitle());
            entity.setPlace(dto.getPlace());
            entity.setStartDate(dto.getStartDate());
            entity.setFinishDate(dto.getFinishDate());
            entity.setResume(ResumeConverter.refDTO2Entity(dto.getResume()));
            entity.setType(dto.getType());
            return entity;
        } else {
            return null;
        }
    }

    /**
     * Conversor full entidad a Dto de los registros de la hoja de vida.
     *
     * @param entity. Entidad de los registros de la hoja de vida a convertir.
     * @return Objeto DTO de los registros de la hoja de vida.
     */
    public static ExperienceDTO fullEntity2DTO(ExperienceEntity entity) {
        if (entity != null) {
            return basicEntity2DTO(entity);
        } else {
            return null;
        }
    }

    /**
     * Conversor full DTO a Entidad de los registros de la hoja de vida.
     *
     * @param dto. Objeto DTO de los registros de la hoja de vida.
     * @return Entidad de la los registros de hoja de vida.
     */
    public static ExperienceEntity fullDTO2Entity(ExperienceDTO dto) {
        if (dto != null) {
            return basicDTO2Entity(dto);
        } else {
            return null;
        }
    }

    /**
     * Convierte una lista de DTOs de los registros de hojas de vida a una lista
     * con entidades.
     *
     * @param dtos. Lista de objetos DTOs de los registros de hojas de vida.
     * @return Lista de entidades de los registros de hojas de vida.
     */
    public static List<ExperienceEntity> listDTO2Entity(List<ExperienceDTO> dtos) {
        List<ExperienceEntity> entities = new ArrayList<ExperienceEntity>();
        if (dtos != null) {
            for (ExperienceDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

    /**
     * Convierte una lista de Entidadess de los registros de hojas de vida a una
     * lista con DTOs.
     *
     * @param entities. Lista de entidades de los registros de hojas de vida.
     * @return Lista de objetos DTOs de los registros de hojas de vida.
     */
    public static List<ExperienceDTO> listEntity2DTO(List<ExperienceEntity> entities) {
        List<ExperienceDTO> dtos = new ArrayList<ExperienceDTO>();
        if (entities != null) {
            for (ExperienceEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * Metodo childDTO2Entity ayuda al manejo de la relacion uno a muchas
     * registros de experiencia asociadas a una hoja de vida del artista, en el
     * que su uso asigna a el registro, la hoja de vida a la cual esta asociada.
     *
     * @param dto es el registro.
     * @param parent es la hoja de vida asociada al registro.
     * @return entity es el objeto del tipo ExperienceEntity con la asignacion
     * de la hoja de vida al registro.
     */
    public static ExperienceEntity childDTO2Entity(ExperienceDTO dto, ResumeEntity parent) {
        ExperienceEntity entity = basicDTO2Entity(dto);
        entity.setResume(parent);
        return entity;
    }

    /**
     * Metodo childDTO2Entity que maneja la relacion uno a muchos entre la hoja
     * de vida y los registros de experiencia realizadas por los artistas.
     *
     * @param dtos es el conjunto de registros asociadas a la hoja de vida.
     * @param parent es el registro de experiencia.
     * @return List. Lista de registros convertidos desde DTOs a Entities para
     * su almacenamiento.
     */
    public static List<ExperienceEntity> childListDTO2Entity(List<ExperienceDTO> dtos, ResumeEntity parent) {
        List<ExperienceEntity> entities = new LinkedList<ExperienceEntity>();
        if (dtos != null) {
            for (ExperienceDTO dto : dtos) {
                entities.add(childDTO2Entity(dto, parent));
            }
        }
        return entities;
    }
}