package co.edu.uniandes.csw.artmarketplace.ejbs;

import co.edu.uniandes.csw.artmarketplace.api.IArtworkLogic;
import co.edu.uniandes.csw.artmarketplace.converters.ArtworkConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.ArtworkPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class ArtworkLogic implements IArtworkLogic {

    @Inject private ArtworkPersistence persistence;

    /**
     * Count Artworks
     * @return 
     */
    @Override
    public int countArtworks() {
        return persistence.count();
    }

    /**
     * Get artworks by page
     * @param page
     * @param maxRecords
     * @return 
     */
    @Override
    public List<ArtworkDTO> getArtworks(Integer page, Integer maxRecords) {
        return ArtworkConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * Get Artwork by id
     * @param id
     * @return 
     */
    @Override
    public ArtworkDTO getArtwork(Long id) {
        return ArtworkConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * Create Artwork
     * @param dto
     * @return 
     */
    @Override
    public ArtworkDTO createArtwork(ArtworkDTO dto) {
        ArtworkEntity entity = ArtworkConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return ArtworkConverter.fullEntity2DTO(entity);
    }

    /**
     * Update artwork
     * @param dto
     * @return 
     */
    @Override
    public ArtworkDTO updateArtwork(ArtworkDTO dto) {
        ArtworkEntity entity = persistence.update(ArtworkConverter.fullDTO2Entity(dto));
        return ArtworkConverter.fullEntity2DTO(entity);
    }

    /**
     * Delete artwork
     * @param id 
     */
    @Override
    public void deleteArtwork(Long id) {
        persistence.delete(id);
    }

    /**
     * Find artwork by namer
     * @param name
     * @return 
     */
    @Override
    public List<ArtworkDTO> findByName(String name) {
        return ArtworkConverter.listEntity2DTO(persistence.findByName(name));
    }
    /**
     * Search artist with cheapest artwork
     * @param artworkName
     * @return
     */
    @Override
    public List<ArtworkDTO> searchArtistWithCheapestArtwork(String artworkName) {
        return ArtworkConverter.listEntity2DTO(persistence.searchArtistWithCheapestArtwork(artworkName));
    }
    /**
     * Search cheapest artwork of an artist
     * @param artistName
     * @return 
     */
    @Override
    public List<ArtworkDTO> searchCheapestArtworkOfAnArtist(String artistName) {
        return ArtworkConverter.listEntity2DTO(persistence.searchCheapestArtworkOfAnArtist(artistName));
    }
    
    /**
     * Search cheapest artwork of an artist
     * @param name
     * @return 
     */
    @Override
    public List<ArtworkDTO> searchArtworksOfAnArtist(String name) {
        return ArtworkConverter.listEntity2DTO(persistence.searchArtworksOfAnArtist(name));
    }
    
    /**
     * Search artworks beteween prices
     * @param artworkMinPrice
     * @param artworkMaxPrice
     * @return 
     */
    @Override
    public List<ArtworkDTO> searchArtworksBetweenPrices(int artworkMinPrice, int artworkMaxPrice) {
        return ArtworkConverter.listEntity2DTO(persistence.searchArtworksBetweenPrices(artworkMinPrice,artworkMaxPrice));
    }
    
}
