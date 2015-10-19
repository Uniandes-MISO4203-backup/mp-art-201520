/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.ejbs;

import co.edu.uniandes.csw.artmarketplace.api.IBlogLogic;
import co.edu.uniandes.csw.artmarketplace.converters.BlogConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.BlogDTO;
import co.edu.uniandes.csw.artmarketplace.entities.BlogEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.BlogPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jh.rubiano10
 */
@Stateless
public class BlogLogic implements IBlogLogic {
    
    @Inject private BlogPersistence persistence;
    

    @Override
    public int countBlog() {
        return persistence.count();
    }
    
    /**
     * Trae todas las entradas del Blog
     * @param page
     * @param maxRecords
     * @return 
     */
    @Override
    public List<BlogDTO> getEntrys(Integer page, Integer maxRecords) {
        return BlogConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }
    
    /**
     * Trae una entrada dado el id de la misma
     * @param id
     * @return 
     */
    @Override
    public BlogDTO getEntry(Long id) {
        return BlogConverter.fullEntity2DTO(persistence.find(id));
    }
    
    /**
     * Crea una nueva entrada del Blog
     * @param dto
     * @return 
     */
    @Override
    public BlogDTO createEntry(BlogDTO dto) {
        BlogEntity entity = BlogConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return BlogConverter.fullEntity2DTO(entity);
    }
    
    /**
     * Lista las entradas de un artista
     * @param idArtist
     * @return 
     */
    @Override
    public List<BlogDTO> getEntryArtist(Long idArtist) {
        return BlogConverter.listEntity2DTO(persistence.getEntryArtist(idArtist));
    }
   
}