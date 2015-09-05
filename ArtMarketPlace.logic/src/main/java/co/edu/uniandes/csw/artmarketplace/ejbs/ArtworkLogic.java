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
     * @generated
     */
    public int countArtworks() {
        return persistence.count();
    }

    /**
     * @generated
     */
    public List<ArtworkDTO> getArtworks(Integer page, Integer maxRecords) {
        return ArtworkConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public ArtworkDTO getArtwork(Long id) {
        return ArtworkConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public ArtworkDTO createArtwork(ArtworkDTO dto) {
        ArtworkEntity entity = ArtworkConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return ArtworkConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public ArtworkDTO updateArtwork(ArtworkDTO dto) {
        ArtworkEntity entity = persistence.update(ArtworkConverter.fullDTO2Entity(dto));
        return ArtworkConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteArtwork(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<ArtworkDTO> findByName(String name) {
        return ArtworkConverter.listEntity2DTO(persistence.findByName(name));
    }

    public List<ArtworkDTO> searchArtistWithCheapestArtwork(String artworkName) {
        return ArtworkConverter.listEntity2DTO(persistence.searchArtistWithCheapestArtwork(artworkName));
    }

    public List<ArtworkDTO> searchCheapestArtworkOfAnArtist(String artistName) {
        return ArtworkConverter.listEntity2DTO(persistence.searchCheapestArtworkOfAnArtist(artistName));
    }
}
