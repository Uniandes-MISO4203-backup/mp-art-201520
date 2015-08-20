package co.edu.uniandes.csw.artmarketplace.persistence;

import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
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
}
