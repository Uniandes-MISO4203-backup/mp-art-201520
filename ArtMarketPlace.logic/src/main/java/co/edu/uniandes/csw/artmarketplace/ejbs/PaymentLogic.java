package co.edu.uniandes.csw.artmarketplace.ejbs;

import co.edu.uniandes.csw.artmarketplace.api.IPaymentLogic;
import co.edu.uniandes.csw.artmarketplace.converters.PaymentConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.PaymentDTO;
import co.edu.uniandes.csw.artmarketplace.entities.PaymentEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.PaymentPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class PaymentLogic implements IPaymentLogic {

    @Inject private PaymentPersistence persistence;

    /**
     * @generated
     */
    public int countPayments() {
        return persistence.count();
    }

    /**
     * @generated
     */
    public List<PaymentDTO> getPayments(Integer page, Integer maxRecords) {
        return PaymentConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public PaymentDTO getPayment(Long id) {
        return PaymentConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public PaymentDTO createPayment(PaymentDTO dto) {
        PaymentEntity entity = PaymentConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return PaymentConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public PaymentDTO updatePayment(PaymentDTO dto) {
        PaymentEntity entity = persistence.update(PaymentConverter.fullDTO2Entity(dto));
        return PaymentConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deletePayment(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<PaymentDTO> findByName(String name) {
        return PaymentConverter.listEntity2DTO(persistence.findByName(name));
    }
    
    public List<PaymentDTO> findAll(){
        return PaymentConverter.listEntity2DTO(persistence.findAll(1, 1));
    }
}
