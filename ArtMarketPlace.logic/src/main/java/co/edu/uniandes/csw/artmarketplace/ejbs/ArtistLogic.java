package co.edu.uniandes.csw.artmarketplace.ejbs;

import co.edu.uniandes.csw.artmarketplace.api.IArtistLogic;
import co.edu.uniandes.csw.artmarketplace.converters.ArtistConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtistDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ArtistEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.ArtistPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class ArtistLogic implements IArtistLogic {

    @Inject private ArtistPersistence persistence;

    /**
     * @generated
     */
    public int countArtists() {
        return persistence.count();
    }

    /**
     * @generated
     */
    public List<ArtistDTO> getArtists(Integer page, Integer maxRecords) {
        return ArtistConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public ArtistDTO getArtist(Long id) {
        return ArtistConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public ArtistDTO createArtist(ArtistDTO dto) {
        ArtistEntity entity = ArtistConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return ArtistConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public ArtistDTO updateArtist(ArtistDTO dto) {
        ArtistEntity entity = persistence.update(ArtistConverter.fullDTO2Entity(dto));
        return ArtistConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteArtist(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<ArtistDTO> findByName(String name) {
        return ArtistConverter.listEntity2DTO(persistence.findByName(name));
    }

    public ArtistDTO getArtistByUserId(String userId) {
        return ArtistConverter.refEntity2DTO(persistence.getArtistByUserId(userId));
    }
}
