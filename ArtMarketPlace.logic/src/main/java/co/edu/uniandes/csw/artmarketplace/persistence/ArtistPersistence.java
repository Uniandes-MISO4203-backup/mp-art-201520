package co.edu.uniandes.csw.artmarketplace.persistence;

import co.edu.uniandes.csw.artmarketplace.entities.ArtistEntity;
import javax.ejb.Stateless;

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
}
