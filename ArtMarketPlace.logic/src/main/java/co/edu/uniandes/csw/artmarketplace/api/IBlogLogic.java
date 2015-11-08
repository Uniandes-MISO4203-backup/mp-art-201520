/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.api;

import co.edu.uniandes.csw.artmarketplace.dtos.BlogDTO;
import java.util.List;

/**
 *
 * @author jh.rubiano10
 */
public interface IBlogLogic {
    public int countBlog();
    /**
     * Método que devuelve todas las antradas de un Blog.
     * @param page
     * @param maxRecords
     * @return 
     */
    public List<BlogDTO> getEntrys(Integer page, Integer maxRecords);
    
    /**
     * Método que devuelve una entrada dado el ID de la misma
     * @param id
     * @return 
     */
    public BlogDTO getEntry(Long id);
    
    /**
     * Método que crea una nueva entrada.
     * @param dto
     * @return 
     */
    public BlogDTO createEntry(BlogDTO dto);
    
    /**
     * Método que trae todas las entradas dado el id del artista que las ha creado.
     * @param idArtist
     * @return 
     */
    public List<BlogDTO> getEntryArtist(Long idArtist);
    
    /**
     * Busca las entradas de un Blog de un artisita dado parte del título de la entrada
     * @param search
     * @param idArtist
     * @return
     */
    public List<BlogDTO> searchBlog(String search, Long idArtist);
}