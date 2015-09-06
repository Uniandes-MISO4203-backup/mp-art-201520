package co.edu.uniandes.csw.artmarketplace.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @generated
 */
@Entity
public class CartItemEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "CartItem")
    private Long id;

    private String name;
    private String state;

    private Integer quantity;

    @ManyToOne
    private ArtworkEntity artwork;
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
    public String getName(){
        return name;
    }

    /**
     * @generated
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * @generated
     */
    public Integer getQuantity(){
        return quantity;
    }

    /**
     * @generated
     */
    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }

    /**
     * @generated
     */
    public ArtworkEntity getArtwork() {
        return artwork;
    }

    /**
     * @generated
     */
    public void setArtwork(ArtworkEntity artwork) {
        this.artwork = artwork;
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
    
    /**
     * @generated
     */
    public String getState() {
        return state;
    }
    
    /**
     * @generated
     */
    public void setState(String state) {
        this.state = state;
    }
    
    
    

}
