package co.edu.uniandes.csw.artmarketplace.api;

import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkDTO;
import java.util.List;

public interface IArtworkLogic {
    public int countArtworks();
    public List<ArtworkDTO> getArtworks(Integer page, Integer maxRecords);
    public ArtworkDTO getArtwork(Long id);
    public ArtworkDTO createArtwork(ArtworkDTO dto);
    public ArtworkDTO updateArtwork(ArtworkDTO dto);
    public void deleteArtwork(Long id);
    public List<ArtworkDTO> findByName(String name);
    /**
     * Search artist with cheapest artwork
     * @param artworkName
     * @return 
     */
    public List<ArtworkDTO> searchArtistWithCheapestArtwork(String artworkName);
    /**
     * Search cheapest artwork of an artist
     * @param artistName
     * @return 
     */
    public List<ArtworkDTO> searchCheapestArtworkOfAnArtist(String artistName);
    /**
     * Search artworks betewwn prices
     * @param artworkMinPrice
     * @param artworkMaxPrice
     * @return 
     */
    public List<ArtworkDTO> searchArtworksBetweenPrices(int artworkMinPrice,int artworkMaxPrice);

    public List<ArtworkDTO> searchArtworksOfAnArtist(String artistId);
}
