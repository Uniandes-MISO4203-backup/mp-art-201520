/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.converters;

import co.edu.uniandes.csw.artmarketplace.dtos.ResumeDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ResumeEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Convierte los objetos de DTO a Entidades y viceversa.
 * Hoja de vida
 * @author vp.salcedo93
 */
public abstract class ResumeConverter {
    /**
     * Metodo constructor del conversor entre entidad y DTO de la hoja de vida.
     */
    private ResumeConverter() { 
    }
    
    /**
     * Convierte entidad a Dto de la hoja de vida.
     * @param entity. Entidad de la hoja de vida a convertir.
     * @return Objeto DTO de la hoja de vida.
     */
    public static ResumeDTO refEntity2DTO(ResumeEntity entity) {
        if(entity != null) {
            ResumeDTO dto = new ResumeDTO();
            dto.setId(entity.getId());
            dto.setCity(entity.getCity());
            dto.setCountry(entity.getCountry());
            dto.setWebsite(entity.getWebsite());
            dto.setLastName(entity.getLastName());
            dto.setPhoto(entity.getPhoto());
            dto.setRatingSum(entity.getRatingSum());
            dto.setRatingVotes(entity.getRatingVotes());

            return dto;
        } else {
            System.err.println("Entidad de Hoja de vida vacia");
            return null;
        }
    }
    /**
     * Convierte DTO a Entidad de la hoja de vida.
     * @param dto. Objeto DTO de la hoja de vida.
     * @return Entidad de la hoja de vida.
     */
    public static ResumeEntity refDTO2Entity(ResumeDTO dto) {
        if (dto != null) {
            ResumeEntity entity = new ResumeEntity();
            entity.setId(dto.getId());
            
            return entity;
        }else {
            System.err.println("DTO de Hoja de vida vacia");
            return null;
        }
    }
    
    /**
     * Conversor basico entidad a Dto de la hoja de vida.
     * @param entity. Entidad de la hoja de vida a convertir.
     * @return Objeto DTO de la hoja de vida.
     */
    public static ResumeDTO basicEntity2DTO(ResumeEntity entity) {
        if(entity != null) {
            ResumeDTO dto = new ResumeDTO();
            dto.setId(entity.getId());
            dto.setCity(entity.getCity());
            dto.setCountry(entity.getCountry());
            dto.setWebsite(entity.getWebsite());
            dto.setLastName(entity.getLastName());
            dto.setPhoto(entity.getPhoto());
            dto.setRatingSum(entity.getRatingSum());
            dto.setRatingVotes(entity.getRatingVotes());
            
            return dto;
        } else {
            System.err.println("Entidad de Hoja de vida vacia");
            return null;
        }
    }
    /**
     * Conversor basico DTO a Entidad de la hoja de vida.
     * @param dto. Objeto DTO de la hoja de vida.
     * @return Entidad de la hoja de vida.
     */
    public static ResumeEntity basicDTO2Entity(ResumeDTO dto) {
        if (dto != null) {
            ResumeEntity entity = new ResumeEntity();
            entity.setId(dto.getId());
            entity.setCity(dto.getCity());
            entity.setCountry(dto.getCountry());
            entity.setWebsite(dto.getWebsite());
            entity.setLastName(dto.getLastName());
            entity.setPhoto(dto.getPhoto());
            entity.setRatingSum(dto.getRatingSum());
            entity.setRatingVotes(dto.getRatingVotes());
            
            return entity;
        }else {
            System.err.println("DTO de Hoja de vida vacia");
            return null;
        }
    }
    /**
     * Conversor full entidad a Dto de la hoja de vida.
     * @param entity. Entidad de la hoja de vida a convertir.
     * @return Objeto DTO de la hoja de vida.
     */
    public static ResumeDTO fullEntity2DTO(ResumeEntity entity) {
        if(entity != null) {
            ResumeDTO dto = basicEntity2DTO(entity);
            dto.setArtist(ArtistConverter.refEntity2DTO(entity.getArtist()));
            dto.setExperience(ExperienceConverter.listEntity2DTO(entity.getExperience()));
            return dto;
        } else {
            System.err.println("Entidad de Hoja de vida vacia");
            return null;
        }
    }
    
    /**
     * Conversor full DTO a Entidad de la hoja de vida.
     * @param dto. Objeto DTO de la hoja de vida.
     * @return Entidad de la hoja de vida.
     */
    public static ResumeEntity fullDTO2Entity (ResumeDTO dto) {
        if (dto != null) {
            ResumeEntity entity = basicDTO2Entity(dto);
            entity.setArtist(ArtistConverter.refDTO2Entity(dto.getArtist()));
            entity.setExperience(ExperienceConverter.childListDTO2Entity(dto.getExperience(), entity));
            return entity;
        } else {
            System.err.println("DTO de Hoja de vida vacia");
            return null;
        }
    }
    
    /**
     * Convierte una lista de DTOs de hojas de vida a una lista con entidades.
     * @param dtos. Lista de objetos DTOs de hojas de vida.
     * @return Lista de entidades de hojas de vida.
     */
    public static List<ResumeEntity> listDTO2Entity(List<ResumeDTO> dtos) {
        List<ResumeEntity> entities = new ArrayList<ResumeEntity>();
        if (dtos != null) {
            for (ResumeDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
    
    /**
     * Convierte una lista de Entidadess de hojas de vida a una lista con DTOs.
     * @param entities. Lista de entidades de hojas de vida.
     * @return Lista de objetos DTOs de hojas de vida.
     */
    public static List<ResumeDTO> listEntity2DTO (List<ResumeEntity> entities) {
        List <ResumeDTO> dtos = new ArrayList<ResumeDTO>();
        if (entities != null) {
            for (ResumeEntity entity: entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }        
        
}
