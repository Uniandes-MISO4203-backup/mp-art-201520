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
    public List<ArtworkDTO> searchArtistWithCheapestArtwork(String artworkName);
    public List<ArtworkDTO> searchCheapestArtworkOfAnArtist(String artistName);
}
