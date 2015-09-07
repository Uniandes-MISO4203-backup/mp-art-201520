package co.edu.uniandes.csw.artmarketplace.dtos;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @generated
 */
@XmlRootElement 
public class ArtworkDTO {

    private Long id;
    private String name;
    private String picture;
    private Integer price;
    private ArtistDTO artist;
    
    /**
     * Comentarios de la obra de arte.
     */
    private List<RemarkDTO> remarks;
    
    /**
     * Descuento de una obra
     */
    private Float discount;
    
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
    public String getPicture() {
        return picture;
    }

    /**
     * @generated
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * @generated
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * @generated
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * @generated
     */
    public ArtistDTO getArtist() {
        return artist;
    }

    /**
     * @generated
     */
    public void setArtist(ArtistDTO artist) {
        this.artist = artist;
    }
    
    /**
     * Metodo para obtener el descuento de una obra de arte
     */
    public Float getDiscount()
    {
        return discount;
    }
    /**
     * Metodo para actualizar el descuento de una obra de arte
     * 
     */
    public void setDiscount(Float discount)
    {
        this.discount = discount;
    }
    
    /**
     * Retorna los comentarios de la obra de arte.
     * @return 
     */
    public List<RemarkDTO> getRemarks()
    {
        return remarks;
    }

    /**
     * Establece los comentarios de la obra de arte.
     * @param remarks 
     */
    public void setRemarks(List<RemarkDTO> remarks)
    {
        this.remarks = remarks;
    }
}