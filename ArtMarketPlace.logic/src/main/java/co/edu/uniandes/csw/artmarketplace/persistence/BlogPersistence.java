/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.persistence;

import co.edu.uniandes.csw.artmarketplace.entities.BlogEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.NoResultException;

/**
 *
 * @author jh.rubiano10
 */
public class BlogPersistence extends CrudPersistence<BlogEntity>{
    public BlogPersistence(){
        this.entityClass = BlogEntity.class;
    }
    
    public List<BlogEntity> getEntryArtist (Long idArtist)
    {
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("idArtist",idArtist);
            return  executeListNamedQuery("Blog.getEntryArtist", params);
        }
        catch(NoResultException e)
        {
                return null;
        }
    }
}
