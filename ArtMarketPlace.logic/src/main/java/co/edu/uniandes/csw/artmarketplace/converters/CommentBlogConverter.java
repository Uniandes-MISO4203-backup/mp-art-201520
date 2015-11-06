/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.converters;

import co.edu.uniandes.csw.artmarketplace.dtos.CommentBlogDTO;
import co.edu.uniandes.csw.artmarketplace.entities.CommentBlogEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jh.rubiano10
 */
public abstract class CommentBlogConverter {
    
    private CommentBlogConverter(){
    }

        /**
     * @param entity
     * @return
     * @generated
     */
    public static CommentBlogDTO refEntity2DTO(CommentBlogEntity entity) {
        if (entity != null) {
            CommentBlogDTO dto = new CommentBlogDTO();
            dto.setId(entity.getId());
            dto.setComment(entity.getComment());
            dto.setDateComment(entity.getDateComment());
            dto.setBlogId(entity.getBlogId());
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
    public static CommentBlogEntity refDTO2Entity(CommentBlogDTO dto) {
        if (dto != null) {
            CommentBlogEntity entity = new CommentBlogEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static CommentBlogDTO basicEntity2DTO(CommentBlogEntity entity) {
        if (entity != null) {
            CommentBlogDTO dto = new CommentBlogDTO();
            dto.setId(entity.getId());
            dto.setComment(entity.getComment());
            dto.setDateComment(entity.getDateComment());
            dto.setClientId(entity.getClientId());
            dto.setBlogId(entity.getBlogId());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static CommentBlogEntity basicDTO2Entity(CommentBlogDTO dto) {
        if (dto != null) {
            CommentBlogEntity entity = new CommentBlogEntity();
            entity.setId(dto.getId());
            entity.setComment(dto.getComment());
            entity.setDateComment(dto.getDateComment());
            entity.setClientId(dto.getClientId());
            entity.setBlogId(dto.getBlogId());

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
    public static CommentBlogDTO fullEntity2DTO(CommentBlogEntity entity) {
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
    public static CommentBlogEntity fullDTO2Entity(CommentBlogDTO dto) {
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
    public static List<CommentBlogDTO> listEntity2DTO(List<CommentBlogEntity> entities) {
        List<CommentBlogDTO> dtos = new ArrayList<CommentBlogDTO>();
        if (entities != null) {
            for (CommentBlogEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @param dtos
     * @return 
     */
    public static List<CommentBlogEntity> listDTO2Entity(List<CommentBlogDTO> dtos) {
        List<CommentBlogEntity> entities = new ArrayList<CommentBlogEntity>();
        if (dtos != null) {
            for (CommentBlogDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
    
}
