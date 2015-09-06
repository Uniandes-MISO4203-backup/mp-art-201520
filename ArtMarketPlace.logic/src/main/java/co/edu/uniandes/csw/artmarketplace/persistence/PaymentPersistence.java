package co.edu.uniandes.csw.artmarketplace.persistence;

import co.edu.uniandes.csw.artmarketplace.entities.PaymentEntity;
import javax.ejb.Stateless;

/**
 * @generated
 */
@Stateless
public class PaymentPersistence extends CrudPersistence<PaymentEntity> {

    /**
     * @generated
     */
    public PaymentPersistence() {
        this.entityClass = PaymentEntity.class;
    }
}
