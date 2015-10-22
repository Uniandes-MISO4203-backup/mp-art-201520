package co.edu.uniandes.csw.artmarketplace.persistence;

import co.edu.uniandes.csw.artmarketplace.entities.ArtistEntity;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 * @generated
 */
@Stateless
public class ArtistPersistence extends CrudPersistence<ArtistEntity> {

    /**
     * @generated
     */
    public ArtistPersistence() {
        this.entityClass = ArtistEntity.class;
    }

    public ArtistEntity getArtistByUserId(String userId) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("user_id", userId);
            return this.executeSingleNamedQuery("Artist.getByUserId", params);
        } catch (NoResultException e) {
            Logger.getLogger(AdminPersistence.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
