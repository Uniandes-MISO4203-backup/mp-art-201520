package co.edu.uniandes.csw.artmarketplace.persistence;

import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 * @generated
 */
@Stateless
public class ArtworkPersistence extends CrudPersistence<ArtworkEntity> {

    /**
     * @generated
     */
    public ArtworkPersistence() {
        this.entityClass = ArtworkEntity.class;
    }

    /**
     * Search artist with cheapest artwork
     *
     * @param artworkName
     * @return
     */
    public List<ArtworkEntity> searchArtistWithCheapestArtwork(String artworkName) {
        List<ArtworkEntity> result = new ArrayList<ArtworkEntity>();
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("artworkName", artworkName);
            List<ArtworkEntity> list = new ArrayList<ArtworkEntity>();
            list = executeListNamedQuery("ArtworkEntity.searchArtistWithCheapestArtwork", params);
            if (list != null && !list.isEmpty()) {
                result = list.subList(0, 1);
            }
        } catch (Exception e) {
            Logger.getLogger(AdminPersistence.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    /**
     * Search cheapest artwork of an artist
     *
     * @param artistName
     * @return
     */
    public List<ArtworkEntity> searchCheapestArtworkOfAnArtist(String artistName) {
        List<ArtworkEntity> result = new ArrayList<ArtworkEntity>();
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("artistName", artistName);
            List<ArtworkEntity> list = new ArrayList<ArtworkEntity>();
            list = executeListNamedQuery("ArtworkEntity.searchCheapestArtworkOfAnArtist", params);
            if (list != null && !list.isEmpty()) {
                result = list.subList(0, 1);
            }
        } catch (Exception e) {
            Logger.getLogger(AdminPersistence.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    /**
     * Search cheapest artwork of an artist
     *
     * @param name
     * @return
     */
    public List<ArtworkEntity> searchArtworksOfAnArtist(String name) {
        List<ArtworkEntity> result = new ArrayList<ArtworkEntity>();
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("name", name);
            result = executeListNamedQuery("ArtworkEntity.searchArtworksOfAnArtist", params);
        } catch (Exception e) {
            Logger.getLogger(AdminPersistence.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    /**
     * Search atrworks between prices
     *
     * @param artworkMinPrice
     * @param artworkMaxPrice
     * @return
     */
    public List<ArtworkEntity> searchArtworksBetweenPrices(int artworkMinPrice, int artworkMaxPrice) {
        List<ArtworkEntity> result = new ArrayList<ArtworkEntity>();
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("artworkMinPrice", artworkMinPrice);
            params.put("artworkMaxPrice", artworkMaxPrice);
            result = executeListNamedQuery("ArtworkEntity.searchArtworksBetweenPrices", params);
        } catch (Exception e) {
            Logger.getLogger(AdminPersistence.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    /**
     * Search artwork by style
     *
     * @param artworkStyle
     * @return
     */
    public List<ArtworkEntity> searchArtworksByStyle(String artworkStyle) {
        List<ArtworkEntity> result = new ArrayList<ArtworkEntity>();
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("artworkStyle", artworkStyle);
            result = executeListNamedQuery("ArtworkEntity.searchArtworksByStyle", params);
        } catch (Exception e) {
            Logger.getLogger(AdminPersistence.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }
    
    /**
     * Search artwork between ratings
     * @param artworkMinRating
     * @param artworkMaxRating
     * @return 
     */
    public List<ArtworkEntity> searchArtworksBetweenRatings(float artworkMinRating, float artworkMaxRating) {
        List<ArtworkEntity> result = new ArrayList<ArtworkEntity>();
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("artworkMinRating", artworkMinRating);
            params.put("artworkMaxRating", artworkMaxRating);
            result = executeListNamedQuery("ArtworkEntity.searchArtworksBetweenRatings", params);
        } catch (Exception e) {
            Logger.getLogger(AdminPersistence.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }
}
