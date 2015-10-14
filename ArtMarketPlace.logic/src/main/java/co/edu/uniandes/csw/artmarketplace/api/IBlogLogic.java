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
    public List<BlogDTO> getEntrys(Integer page, Integer maxRecords);
    public BlogDTO getEntry(Long id);
    public BlogDTO createEntry(BlogDTO dto);
    public List<BlogDTO> getEntryArtist(Long idArtist);
}