package co.edu.uniandes.csw.artmarketplace.ejbs;

import co.edu.uniandes.csw.artmarketplace.api.IArtworkLogic;
import co.edu.uniandes.csw.artmarketplace.converters.ArtworkConverter;
import co.edu.uniandes.csw.artmarketplace.converters.ArtworkRatingConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkRatingDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ClientDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkRatingEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ClientEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.ArtworkPersistence;
import co.edu.uniandes.csw.artmarketplace.persistence.ArtworkRatingPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class ArtworkLogic implements IArtworkLogic {

    @Inject
    private ArtworkPersistence persistence;

    /**
     *
     */
    @Inject
    private ArtworkRatingPersistence ratingPersistence;

    /**
     * Count Artworks
     *
     * @return
     */
    @Override
    public int countArtworks() {
        return persistence.count();
    }

    /**
     * Get artworks by page
     *
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
     *
     * @param id
     * @return
     */
    @Override
    public ArtworkDTO getArtwork(Long id) {
        return ArtworkConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * Create Artwork
     *
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
     *
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
     *
     * @param id
     */
    @Override
    public void deleteArtwork(Long id) {
        persistence.delete(id);
    }

    /**
     * Find artwork by namer
     *
     * @param name
     * @return
     */
    @Override
    public List<ArtworkDTO> findByName(String name) {
        return ArtworkConverter.listEntity2DTO(persistence.findByName(name));
    }

    /**
     * Search artist with cheapest artwork
     *
     * @param artworkName
     * @return
     */
    @Override
    public List<ArtworkDTO> searchArtistWithCheapestArtwork(String artworkName) {
        return ArtworkConverter.listEntity2DTO(persistence.searchArtistWithCheapestArtwork(artworkName));
    }

    /**
     * Search cheapest artwork of an artist
     *
     * @param artistName
     * @return
     */
    @Override
    public List<ArtworkDTO> searchCheapestArtworkOfAnArtist(String artistName) {
        return ArtworkConverter.listEntity2DTO(persistence.searchCheapestArtworkOfAnArtist(artistName));
    }

    /**
     * Search cheapest artwork of an artist
     *
     * @param name
     * @return
     */
    @Override
    public List<ArtworkDTO> searchArtworksOfAnArtist(String name) {
        return ArtworkConverter.listEntity2DTO(persistence.searchArtworksOfAnArtist(name));
    }

    /**
     * Search artworks beteween prices
     *
     * @param artworkMinPrice
     * @param artworkMaxPrice
     * @return
     */
    @Override
    public List<ArtworkDTO> searchArtworksBetweenPrices(int artworkMinPrice, int artworkMaxPrice) {
        return ArtworkConverter.listEntity2DTO(persistence.searchArtworksBetweenPrices(artworkMinPrice, artworkMaxPrice));
    }

    /**
     * Search artworks by style
     *
     * @param artworkStyle
     * @return
     */
    @Override
    public List<ArtworkDTO> searchArtworksByStyle(String artworkStyle) {
        return ArtworkConverter.listEntity2DTO(persistence.searchArtworksByStyle(artworkStyle));
    }
    
    /**
     * Search artworks by type
     * @param artworkType
     * @return
     */
    @Override
    public List<ArtworkDTO> searchArtworksByType(String artworkType) {
        return ArtworkConverter.listEntity2DTO(persistence.searchArtworksByType(artworkType));
    }
    
    /**
     * Search artworks by format
     * @param artworkFormat
     * @return
     */
    @Override
    public List<ArtworkDTO> searchArtworksByFormat(String artworkFormat) {
        return ArtworkConverter.listEntity2DTO(persistence.searchArtworksByFormat(artworkFormat));
    }

    /**
     * Este metodo esta disennado para recibir la votacion realizar por un
     * cliente frente a una obra de arte en especifico.
     *
     * @param rating es la valoracion hecha por el cliente.
     * @param id es el identificador unico del obra de arte.
     * @return confirmation es la variable designada para confirmar que se ha
     * hecho la calificacion de una obra de arte.
     */
    @Override
    public Boolean rateArtwork(Long id, ClientDTO client, Float rating) {
        Boolean confirmation = false;
        ArtworkEntity artwork = persistence.find(id);
        if (artwork != null && checkPreviewRatingByClient(client, artwork.getRatings())) {
            if (artwork.getRatingVotes() != null && artwork.getRatingSum() != null) {
                artwork.setRatingSum(artwork.getRatingSum() + rating);
                artwork.setRatingVotes((float) 1 + artwork.getRatingVotes());

            } else {
                artwork.setRatingSum(rating);
                artwork.setRatingVotes(1.0000f);
            }
            persistence.update(artwork);
            ArtworkRatingDTO artworkRating = new ArtworkRatingDTO();
            artworkRating.setArtwork(ArtworkConverter.refEntity2DTO(artwork));
            artworkRating.setClient(client);
            ratingPersistence.create(ArtworkRatingConverter.basicArtworkRatingDTO2Entity(artworkRating));
            confirmation = true;
        }
        return confirmation;
    }

    /**
     * Este metodo esta disennado para la calificacion actual de la obra de arte
     * en especifico.
     *
     * @param id es el identificador unico de la obra de arte.
     * @return rating es la variable designada para retornar la calificacion de
     * la obra de arte.
     */
    @Override
    public Float getRatingArtwork(Long id) {
        ArtworkEntity artwork = persistence.find(id);
        Float rating = 0.0000f;
        if (artwork.getRatingVotes() != null && artwork.getRatingSum() != null && artwork.getRatingVotes() > 0) {
            rating = artwork.getRatingSum() / artwork.getRatingVotes();
        }
        return rating;
    }

    /**
     * Este metodo esta disennado para verificar si un cliente previamente ha
     * calificado una obra de arte.
     *
     * @param client es el cliente a verificar
     * @param list es la lista de clientes que han calificado la obra de arte
     * previamente.
     * @return retorna falso si el cliente con anterioridad ha calificado la
     * obra, y true si no lo ha hecho.
     */
    @Override
    public Boolean checkPreviewRatingByClient(ClientDTO client, List<ArtworkRatingEntity> list) {
        Boolean result = true;
        for (int i = 0; i < list.size() && result; i++) {
            ClientEntity c = list.get(i).getClient();
            if (c.getUserId().equals(client.getUserId())) {
                result = false;
            }
        }
        return result;
    }

    /**
     * search atrworks between ratings
     * @param artworkMinRating
     * @param artworkMaxRating
     * @return 
     */
    @Override
    public List<ArtworkDTO> searchArtworksBetweenRatings(float artworkMinRating, float artworkMaxRating) {
        return ArtworkConverter.listEntity2DTO(persistence.searchArtworksBetweenRatings(artworkMinRating, artworkMaxRating));
    }
}
