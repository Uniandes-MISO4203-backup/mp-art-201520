package co.edu.uniandes.csw.artmarketplace.persistence;

import co.edu.uniandes.csw.artmarketplace.entities.ArtistEntity;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import org.apache.log4j.Logger;

/**
 * @generated
 */
@Stateless
public class ArtistPersistence extends CrudPersistence<ArtistEntity> {
    
    private static final Logger LOGGER = Logger.getLogger(ArtistPersistence.class);

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
            LOGGER.info(e.getMessage());
            return null;
        }
    }
}
