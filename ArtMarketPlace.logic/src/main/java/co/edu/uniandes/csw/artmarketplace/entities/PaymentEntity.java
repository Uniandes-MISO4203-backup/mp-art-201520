package co.edu.uniandes.csw.artmarketplace.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @generated
 */
@Entity
public class PaymentEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Payment")
    private Long id;

    private String method;

    private Integer subtotal;

    private Integer taxes;

    private Integer total;

    private String cardNumber;

    @ManyToOne
    private ClientEntity client;
    /**
     * @generated
     */
    public Long getId(){
        return id;
    }

    /**
     * @generated
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * @generated
     */
    public String getMethod(){
        return method;
    }

    /**
     * @generated
     */
    public void setMethod(String method){
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
    public ClientEntity getClient() {
        return client;
    }

    /**
     * @generated
     */
    public void setClient(ClientEntity client) {
        this.client = client;
    }   

}
