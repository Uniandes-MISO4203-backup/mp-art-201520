package co.edu.uniandes.csw.artmarketplace.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * @generated
 */
@Entity
@NamedQueries(
{
        @NamedQuery(name = "ArtworkEntity.searchArtworksByStyle", 
                    query = "SELECT a FROM ArtworkEntity a WHERE UPPER(a.artworkStyle) like UPPER(:artworkStyle)"),
    
        @NamedQuery(name = "ArtworkEntity.searchArtworksBetweenPrices", 
                    query = "SELECT a FROM ArtworkEntity a WHERE a.price BETWEEN :artworkMinPrice AND :artworkMaxPrice"),
    
        @NamedQuery(name = "ArtworkEntity.searchArtistWithCheapestArtwork", 
                    query = "SELECT a FROM ArtworkEntity a WHERE UPPER(a.name) like UPPER(:artworkName) ORDER BY a.price"),
    
        @NamedQuery(name = "ArtworkEntity.searchArtworksOfAnArtist", 
                    query = "SELECT a FROM ArtworkEntity a WHERE UPPER(a.artist.name) like UPPER(:name) ORDER BY a.price"),
    
        @NamedQuery(name = "ArtworkEntity.searchCheapestArtworkOfAnArtist", 
                    query = "SELECT a FROM ArtworkEntity a WHERE UPPER(a.artist.name) like UPPER(:artistName) ORDER BY a.price")
}
        
)
public class ArtworkEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Artwork")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "artwork", cascade = CascadeType.ALL, orphanRemoval = true)
    private  List<ArtworkGaleryItemEntity> artworkGaleryItems;

    private Integer price;
    /**
     * Descuento de una obra
     */
    private Float discount;
    
    /**
     * Artwork style
     */
    private String artworkStyle;
 
    /**
     * Comentarios de la obra de arte.
     */
    @OneToMany(mappedBy = "artwork", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RemarkEntity> remarks;

    @ManyToOne
    private ArtistEntity artist;
    
    /**
     * Es la ista de calificaciones recibidas por parte de los clientes.
     */
    @OneToMany(mappedBy = "artwork", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArtworkRatingEntity> ratings;
    
    /**
     * ratingSum es la variable utilizada para acumular las calificaciones recibidas por los clientes hacia la obra de arte, para finales del calculo del promedio.
     */
    private Float ratingSum;
    
    /**
     * ratingVotes es la variable utilizada para totalizar la cantidad de votos recibidos por parte de los clientes hacia la obra de arte, para finles del calculo de su promedio.
     */
    private Float ratingVotes;
    
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

    public List<ArtworkGaleryItemEntity> getArtworkGaleryItems() {
        return artworkGaleryItems;
    }

    public void setArtworkGaleryItems(List<ArtworkGaleryItemEntity> artworkGaleryItems) {
        this.artworkGaleryItems = artworkGaleryItems;
    }


    /**
     * @generated
     */
    public Integer getPrice(){
        return price;
    }

    /**
     * @generated
     */
    public void setPrice(Integer price){
        this.price = price;
    }

    /**
     * @generated
     */
    public ArtistEntity getArtist() {
        return artist;
    }

    /**
     * @generated
     */
    public void setArtist(ArtistEntity artist) {
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
     * Retorna los comentarios de una obra de arte.
     * @return remarks
     */
    public List<RemarkEntity> getRemarks()
    {
       return remarks;
    }

    /**
     * Establece los comentarios de una obra de arte.
     * @param remarks
     */
    public void setRemarks(List<RemarkEntity> remarks)
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
     * Es un metodo de acceso que retorno la lista de votaciones recibidas por los cliente a la obra de arte.
     * @return una lista de objecto ArtworkRatingEntity.
     */
    public List<ArtworkRatingEntity> getRatings() {
        return ratings;
    }

    /**
     * Es un metodo de acceso que modifica la lista de votaciones recibidas por los clientes a la obra de arte.
     * @param ratings es una nueva lista de objetos ArtworkRatingEntity.
     */
    public void setRatings(List<ArtworkRatingEntity> ratings) {
        this.ratings = ratings;
    }

    /**
     * Es un metodo de acceso que tiene como finalidad retornar el valor actual del ratingSum de la obra de arte.
     * @return ratingSum es la sumatoria de calificaciones recibidas por la obra de arte.
     */
    public Float getRatingSum() {
        return ratingSum;
    }

    /**
     * Es un metodo de acceso que tiene como finalidad modificar el valor actual del ratingSum de la obra de arte. 
     * @param ratingSum 
     */
    public void setRatingSum(Float ratingSum) {
        this.ratingSum = ratingSum;
    }

    /**
     * Es un metodo de acceso que tiene como finalidad retornar el valor actual del ratingVotes de la obra de arte.
     * @return ratingVotes es la cantidad de votos de calificaci?n recibidas por la obra de arte.
     */
    public Float getRatingVotes() {
        return ratingVotes;
    }

    /**
     * Es un metodo de acceso que tienen como finalidad modificar el valor actual del ratingVotes de la obra de arte.
     * @param ratingVotes es el nuevo valor del total de votos de calificacion recibidas por la obra de arte.
     */
    public void setRatingVotes(Float ratingVotes) {
        this.ratingVotes = ratingVotes;
    }
    
}