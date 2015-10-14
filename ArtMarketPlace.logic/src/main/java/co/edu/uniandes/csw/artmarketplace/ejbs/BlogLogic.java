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
    
    @Override
    public List<BlogDTO> getEntrys(Integer page, Integer maxRecords) {
        return BlogConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }
    
    @Override
    public BlogDTO getEntry(Long id) {
        return BlogConverter.fullEntity2DTO(persistence.find(id));
    }
    
    @Override
    public BlogDTO createEntry(BlogDTO dto) {
        BlogEntity entity = BlogConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return BlogConverter.fullEntity2DTO(entity);
    }

    public List<BlogDTO> getEntryArtist(Long idArtist) {
        return BlogConverter.listEntity2DTO(persistence.getEntryArtist(idArtist));
    }
   
}