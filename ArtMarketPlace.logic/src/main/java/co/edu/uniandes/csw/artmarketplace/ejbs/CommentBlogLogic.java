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
     * Metodo encargado de traer todos los comentarios de un blog.
     * @param page
     * @param maxRecords
     * @return 
     */
    @Override
    public List<CommentBlogDTO> getComments(Integer page, Integer maxRecords) {
        return CommentBlogConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }
    
    //Método que trae un comentario.
    @Override
    public CommentBlogDTO getComment(Long id) {
        return CommentBlogConverter.fullEntity2DTO(persistence.find(id));
    }

    //Método que cuenta el número de comentarios de un blog.
    @Override
    public int countComment() {
        return persistence.count();
    }

    /**
     * Método que crea un comentario de un blog.
     * @param dto
     * @return 
     */
    @Override
    public CommentBlogDTO createComment(CommentBlogDTO dto) {
        CommentBlogEntity entity = CommentBlogConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return CommentBlogConverter.fullEntity2DTO(entity);
    }
    //Método que traer todos los comentarios de un blog, dado su id.
    @Override
    public List<CommentBlogDTO> getCommentBlog(Long idBlog) {
        return CommentBlogConverter.listEntity2DTO(persistence.getCommentBlog(idBlog));
    }
}
