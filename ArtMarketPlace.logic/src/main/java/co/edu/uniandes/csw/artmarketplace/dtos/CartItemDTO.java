package co.edu.uniandes.csw.artmarketplace.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @generated
 */
@XmlRootElement 
public class CartItemDTO {

    private Long id;
    private String name;
    private Integer quantity;
    private ArtworkDTO artwork;
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
    public String getName() {
        return name;
    }

    /**
     * @generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @generated
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @generated
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @generated
     */
    public ArtworkDTO getArtwork() {
        return artwork;
    }

    /**
     * @generated
     */
    public void setArtwork(ArtworkDTO artwork) {
        this.artwork = artwork;
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
