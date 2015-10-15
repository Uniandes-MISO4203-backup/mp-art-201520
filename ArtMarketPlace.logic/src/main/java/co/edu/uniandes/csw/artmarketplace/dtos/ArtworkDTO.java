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
    
    private List<ArtworkRatingDTO> ratings;
    
    /**
     * Descuento de una obra
     */
    private Float discount;
    
    /**
     * Artwork style
     */
    private String artworkStyle;
    
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

    public String getArtworkStyle() {
        return artworkStyle;
    }

    public void setArtworkStyle(String artworkStyle) {
        this.artworkStyle = artworkStyle;
    }

    /**
     * Es un metodo de acceso que retorna un lista con la calificaciones de obra de arte.
     * @return una lista de objectos ArtworkRatingDTO con la informacion de todas las calificaciones.
     */
    public List<ArtworkRatingDTO> getRatings() {
        return ratings;
    }

    /**
     * Es un meotodo de acceso que modifica la lista de calificaciones de la obra de arte.
     * @param ratings es la nueva referencia de lista para las calificaciones de la obra de arte.
     */
    public void setRatings(List<ArtworkRatingDTO> ratings) {
        this.ratings = ratings;
    }
}