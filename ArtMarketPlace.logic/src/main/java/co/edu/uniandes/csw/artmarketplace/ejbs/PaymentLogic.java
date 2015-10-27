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

    @Inject
    private PaymentPersistence persistence;

    /**
     * @generated
     */
    @Override
    public int countPayments() {
        return persistence.count();
    }

    /**
     * @generated
     */
    @Override
    public List<PaymentDTO> getPayments(Integer page, Integer maxRecords) {
        return PaymentConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    @Override
    public PaymentDTO getPayment(Long id) {
        return PaymentConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    @Override
    public PaymentDTO createPayment(PaymentDTO dto) {
        PaymentEntity entity = PaymentConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return PaymentConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    @Override
    public PaymentDTO updatePayment(PaymentDTO dto) {
        PaymentEntity entity = persistence.update(PaymentConverter.fullDTO2Entity(dto));
        return PaymentConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    @Override
    public void deletePayment(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    @Override
    public List<PaymentDTO> findByName(String name) {
        return PaymentConverter.listEntity2DTO(persistence.findByName(name));
    }

}
