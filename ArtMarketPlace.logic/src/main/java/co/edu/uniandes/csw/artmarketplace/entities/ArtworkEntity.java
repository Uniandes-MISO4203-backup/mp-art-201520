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
public class ArtworkEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Artwork")
    private Long id;

    private String name;

    private String picture;

    private Integer price;

    @ManyToOne
    private ArtistEntity artist;
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
    public String getPicture(){
        return picture;
    }

    /**
     * @generated
     */
    public void setPicture(String picture){
        this.picture = picture;
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

}
