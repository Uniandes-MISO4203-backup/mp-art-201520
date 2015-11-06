/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.persistence;

import co.edu.uniandes.csw.artmarketplace.entities.CommentBlogEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 *
 * @author jh.rubiano10
 */
@Stateless
public class CommentBlogPersistence extends CrudPersistence<CommentBlogEntity>{
    public CommentBlogPersistence(){
        this.entityClass = CommentBlogEntity.class;
    }
    
    public List<CommentBlogEntity> getCommentBlog(Long idBlog) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("idBlog", idBlog);
            return executeListNamedQuery("Blog.getCommentBlog", params);
        } catch (NoResultException e) {
            Logger.getLogger(AdminPersistence.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
