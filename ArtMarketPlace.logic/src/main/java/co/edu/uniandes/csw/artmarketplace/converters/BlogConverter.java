/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.converters;

import co.edu.uniandes.csw.artmarketplace.dtos.BlogDTO;
import co.edu.uniandes.csw.artmarketplace.entities.BlogEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jh.rubiano10
 */
public class BlogConverter {

    private BlogConverter() {
    }

    /**
     * Método encarga ddoe hacer la conversion de un objeto del tipo Entity a un
     * objeto DTO del tipo BlogEntity.
     *
     * @param entity
     * @return un objeto del tipo DTO de BlogEntity
     */
    public static BlogDTO refEntity2DTO(BlogEntity entity) {
        if (entity != null) {
            BlogDTO dto = new BlogDTO();
            dto.setId(entity.getId());
            dto.setEntry(entity.getEntry());
            dto.setTitle(entity.getTitle());
            dto.setDateEntry(entity.getDateEntry());
            dto.setClientId(entity.getClientId());
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
    public static BlogEntity refDTO2Entity(BlogDTO dto) {
        if (dto != null) {
            BlogEntity entity = new BlogEntity();
            entity.setId(dto.getId());
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static BlogDTO basicEntity2DTO(BlogEntity entity) {
        if (entity != null) {
            return refEntity2DTO(entity);
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static BlogEntity basicDTO2Entity(BlogDTO dto) {
        if (dto != null) {
            BlogEntity entity = new BlogEntity();
            entity.setId(dto.getId());
            entity.setEntry(dto.getEntry());
            entity.setTitle(dto.getTitle());
            dto.setDateEntry(entity.getDateEntry());
            entity.setClientId(dto.getClientId());
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
    public static BlogDTO fullEntity2DTO(BlogEntity entity) {
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
    public static BlogEntity fullDTO2Entity(BlogDTO dto) {
        if (dto != null) {
            return basicDTO2Entity(dto);
        } else {
            return null;
        }
    }

    /**
     * @param entities
     * @return
     */
    public static List<BlogDTO> listEntity2DTO(List<BlogEntity> entities) {
        List<BlogDTO> dtos = new ArrayList<BlogDTO>();
        if (entities != null) {
            for (BlogEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @param dtos
     * @return
     */
    public static List<BlogEntity> listDTO2Entity(List<BlogDTO> dtos) {
        List<BlogEntity> entities = new ArrayList<BlogEntity>();
        if (dtos != null) {
            for (BlogDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
}
