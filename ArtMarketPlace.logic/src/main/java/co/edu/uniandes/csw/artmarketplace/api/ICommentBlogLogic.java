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
    public List<CommentBlogDTO> getComments(Integer page, Integer maxRecords);
    public CommentBlogDTO getComment(Long id);
    public CommentBlogDTO createComment(CommentBlogDTO dto);
    //Para traer los comentarios relacionados a un Blog...
    public List<CommentBlogDTO> getCommentBlog(Long idBlog);
}
