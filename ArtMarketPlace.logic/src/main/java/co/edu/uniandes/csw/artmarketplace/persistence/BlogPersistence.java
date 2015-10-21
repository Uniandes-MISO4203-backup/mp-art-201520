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
import javax.persistence.NoResultException;
import org.apache.log4j.Logger;

/**
 *
 * @author jh.rubiano10
 */
public class BlogPersistence extends CrudPersistence<BlogEntity> {
    
    private static final Logger LOGGER = Logger.getLogger(BlogPersistence.class);

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
            LOGGER.info(e.getMessage());
            return null;
        }
    }
}
