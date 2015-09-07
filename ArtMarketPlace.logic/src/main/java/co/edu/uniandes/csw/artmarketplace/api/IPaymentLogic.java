package co.edu.uniandes.csw.artmarketplace.api;

import co.edu.uniandes.csw.artmarketplace.dtos.PaymentDTO;
import java.util.List;

public interface IPaymentLogic {
    public int countPayments();
    public List<PaymentDTO> getPayments(Integer page, Integer maxRecords);
    public PaymentDTO getPayment(Long id);
    public PaymentDTO createPayment(PaymentDTO dto);
    public PaymentDTO updatePayment(PaymentDTO dto);
    public void deletePayment(Long id);
    public List<PaymentDTO> findByName(String name);
}
