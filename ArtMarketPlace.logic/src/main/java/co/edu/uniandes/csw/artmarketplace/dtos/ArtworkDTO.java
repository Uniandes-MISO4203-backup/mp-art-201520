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
    private List<ArtworkGaleryItemDTO> artworkGaleryItems;
    private Integer price;
    private ArtistDTO artist;

    /**
     * Comentarios de la obra de arte.
     */
    private List<RemarkDTO> remarks;

    /**
     *
     */
    private List<ArtworkRatingDTO> ratings;
    /**
     * ratingSum es la variable utilizada para acumular las calificaciones
     * recibidas por los clientes hacia la obra de arte, para finales del
     * calculo del promedio.
     */
    private Float ratingSum;

    /**
     * ratingVotes es la variable utilizada para totalizar la cantidad de votos
     * recibidos por parte de los clientes hacia la obra de arte, para finles
     * del calculo de su promedio.
     */
    private Float ratingVotes;

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

    public List<ArtworkGaleryItemDTO> getArtworkGaleryItems() {
        return artworkGaleryItems;
    }

    public void setArtworkGaleryItems(List<ArtworkGaleryItemDTO> artworkGaleryItems) {
        this.artworkGaleryItems = artworkGaleryItems;
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
    public Float getDiscount() {
        return discount;
    }

    /**
     * Metodo para actualizar el descuento de una obra de arte
     *
     */
    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    /**
     * Retorna los comentarios de la obra de arte.
     *
     * @return
     */
    public List<RemarkDTO> getRemarks() {
        return remarks;
    }

    /**
     * Establece los comentarios de la obra de arte.
     *
     * @param remarks
     */
    public void setRemarks(List<RemarkDTO> remarks) {
        this.remarks = remarks;
    }

    public String getArtworkStyle() {
        return artworkStyle;
    }

    public void setArtworkStyle(String artworkStyle) {
        this.artworkStyle = artworkStyle;
    }

    /**
     * Es un metodo de acceso que retorna un lista con la calificaciones de obra
     * de arte.
     *
     * @return una lista de objectos ArtworkRatingDTO con la informacion de
     * todas las calificaciones.
     */
    public List<ArtworkRatingDTO> getRatings() {
        return ratings;
    }

    /**
     * Es un meotodo de acceso que modifica la lista de calificaciones de la
     * obra de arte.
     *
     * @param ratings es la nueva referencia de lista para las calificaciones de
     * la obra de arte.
     */
    public void setRatings(List<ArtworkRatingDTO> ratings) {
        this.ratings = ratings;
    }

    /**
     * Es un metodo de acceso que tiene como finalidad retornar el valor actual
     * del ratingSum de la obra de arte.
     *
     * @return ratingSum es la sumatoria de calificaciones recibidas por la obra
     * de arte.
     */
    public Float getRatingSum() {
        return ratingSum;
    }

    /**
     * Es un metodo de acceso que tiene como finalidad modificar el valor actual
     * del ratingSum de la obra de arte.
     *
     * @param ratingSum
     */
    public void setRatingSum(Float ratingSum) {
        this.ratingSum = ratingSum;
    }

    /**
     * Es un metodo de acceso que tiene como finalidad retornar el valor actual
     * del ratingVotes de la obra de arte.
     *
     * @return ratingVotes es la cantidad de votos de calificaci?n recibidas por
     * la obra de arte.
     */
    public Float getRatingVotes() {
        return ratingVotes;
    }

    /**
     * Es un metodo de acceso que tienen como finalidad modificar el valor
     * actual del ratingVotes de la obra de arte.
     *
     * @param ratingVotes es el nuevo valor del total de votos de calificacion
     * recibidas por la obra de arte.
     */
    public void setRatingVotes(Float ratingVotes) {
        this.ratingVotes = ratingVotes;
    }
}
