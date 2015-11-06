/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.ejbs;

import co.edu.uniandes.csw.artmarketplace.api.ICommentBlogLogic;
import co.edu.uniandes.csw.artmarketplace.converters.CommentBlogConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.CommentBlogDTO;
import co.edu.uniandes.csw.artmarketplace.entities.CommentBlogEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.CommentBlogPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jh.rubiano10
 */
@Stateless
public class CommentBlogLogic implements ICommentBlogLogic {
    
    @Inject private CommentBlogPersistence persistence;

    /**
     * Metodo encargado de obtener las �rdenes de un cliente
     * @param page
     * @param maxRecords
     * @return 
     */
    @Override
    public List<CommentBlogDTO> getComments(Integer page, Integer maxRecords) {
        return CommentBlogConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    @Override
    public CommentBlogDTO getComment(Long id) {
        return CommentBlogConverter.fullEntity2DTO(persistence.find(id));
    }

    @Override
    public int countComment() {
        return persistence.count();
    }

    /**
     * @param dto
     * @return 
     */
    @Override
    public CommentBlogDTO createComment(CommentBlogDTO dto) {
        CommentBlogEntity entity = CommentBlogConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return CommentBlogConverter.fullEntity2DTO(entity);
    }

    public List<CommentBlogDTO> getCommentBlog(Long idBlog) {
        return CommentBlogConverter.listEntity2DTO(persistence.getCommentBlog(idBlog));
    }
}
