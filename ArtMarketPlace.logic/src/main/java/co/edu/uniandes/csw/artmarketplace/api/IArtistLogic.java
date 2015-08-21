package co.edu.uniandes.csw.artmarketplace.api;

import co.edu.uniandes.csw.artmarketplace.dtos.ArtistDTO;
import java.util.List;

public interface IArtistLogic {
    public int countArtists();
    public List<ArtistDTO> getArtists(Integer page, Integer maxRecords);
    public ArtistDTO getArtist(Long id);
    public ArtistDTO createArtist(ArtistDTO dto);
    public ArtistDTO updateArtist(ArtistDTO dto);
    public void deleteArtist(Long id);
    public List<ArtistDTO> findByName(String name);
    public ArtistDTO getArtistByUserId(String userId);
}
