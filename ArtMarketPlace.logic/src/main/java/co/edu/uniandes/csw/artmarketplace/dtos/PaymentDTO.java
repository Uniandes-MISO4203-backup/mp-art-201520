package co.edu.uniandes.csw.artmarketplace.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @generated
 */
@XmlRootElement 
public class PaymentDTO { 
    
    private Long id;
    private String method;
    private Integer subtotal;
    private Integer taxes;
    private Integer total;
    private String cardNumber;
    private ClientDTO client;

    /**
     * @generated
     */
    public Long getId() {
        return id;
    }

    /**
     * @generated
     */
    public void setId(Long id) {
        this.id = id;
    }

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
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * @generated
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
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
    
}
