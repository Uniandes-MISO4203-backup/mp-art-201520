package co.edu.uniandes.csw.artmarketplace.dtos;

import enums.PaymentTypeEnum;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @generated
 */
@XmlRootElement
public class PaymentDTO extends BasicDTO {

    private String method;
    private Integer subtotal;
    private Integer taxes;
    private Integer total;
    private String reference;
    private ClientDTO client;
    private PaymentTypeEnum paymentType;

    /**
     * @generated
     */
    public String getMethod() {
        return method;
    }

    /**
     * @generated
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * @generated
     */
    public Integer getSubtotal() {
        return subtotal;
    }

    /**
     * @generated
     */
    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @generated
     */
    public Integer getTaxes() {
        return taxes;
    }

    /**
     * @generated
     */
    public void setTaxes(Integer taxes) {
        this.taxes = taxes;
    }

    /**
     * @generated
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @generated
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * @generated
     */
    public String getReference() {
        return reference;
    }

    /**
     * @generated
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * @generated
     */
    public ClientDTO getClient() {
        return client;
    }

    /**
     * @generated
     */
    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public PaymentTypeEnum getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypeEnum paymentType) {
        this.paymentType = paymentType;
    }
}
