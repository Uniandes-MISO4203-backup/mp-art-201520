package co.edu.uniandes.csw.artmarketplace.persistence;

import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
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

    public List<ArtworkEntity> searchArtistWithCheapestArtwork(String artworkName) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("artworkName", artworkName);
            List<ArtworkEntity> list = new ArrayList<ArtworkEntity>();
            list = executeListNamedQuery("ArtworkEntity.searchArtistWithCheapestArtwork", params);
            return list.subList(0, 1);
        } catch (Exception e) {
            return null;
        }
    }

    public List<ArtworkEntity> searchCheapestArtworkOfAnArtist(String artistName) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("artistName", artistName);
            List<ArtworkEntity> list = new ArrayList<ArtworkEntity>();
            list = executeListNamedQuery("ArtworkEntity.searchCheapestArtworkOfAnArtist", params);
            return list.subList(0, 1);
        } catch (Exception e) {
            return null;
        }
    }
}
