/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.api;

import co.edu.uniandes.csw.artmarketplace.dtos.CommentBlogDTO;
import java.util.List;

/**
 *
 * @author jh.rubiano10
 */
public interface ICommentBlogLogic {
    public int countComment();

    /**
     * Traer todos los comentarios del BlogDTO
     * @param page
     * @param maxRecords
     * @return
     */
    public List<CommentBlogDTO> getComments(Integer page, Integer maxRecords);

    /**
     * Traer un comemtario dado el id del mismo
     * @param id
     * @return
     */
    public CommentBlogDTO getComment(Long id);

    /**
     * Crear un nuevo comentario.
     * @param dto
     * @return
     */
    public CommentBlogDTO createComment(CommentBlogDTO dto);

    /**
     * Traer los comentarios de un blog específico dado su id
     * @param idBlog
     * @return
     */
    public List<CommentBlogDTO> getCommentBlog(Long idBlog);
}
