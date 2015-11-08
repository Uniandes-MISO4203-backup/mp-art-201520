/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.persistence;

import co.edu.uniandes.csw.artmarketplace.entities.BlogEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author jh.rubiano10
 */
@Stateless
public class BlogPersistence extends CrudPersistence<BlogEntity> {

    public BlogPersistence() {
        this.entityClass = BlogEntity.class;
    }

    /**
     * Método que trae las entradas de un artisita dado su ID
     *
     * @param idArtist
     * @return
     */
    public List<BlogEntity> getEntryArtist(Long idArtist) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("idArtist", idArtist);
            return executeListNamedQuery("Blog.getEntryArtist", params);
        } catch (NoResultException e) {
            Logger.getLogger(AdminPersistence.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    //Método para realizar la búsqueda de entradas de un blog de un artista.
    public List<BlogEntity> searchBlog(String search, Long idArtist) {
        try{
            Query q = em.createNamedQuery("Blog.searchBlog");
            String searchObj = search;
            Long idArtistObj = idArtist;
            q.setParameter("search", "%" + searchObj + "%");
            q.setParameter("idArtist", idArtistObj);
            return q.getResultList();
        } catch(NoResultException e){
            Logger.getLogger(AdminPersistence.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}