package co.edu.uniandes.csw.artmarketplace.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 * @generated
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Artist.getByUserId", query = "select u from ArtistEntity u WHERE u.userId = :user_id")
})
public class ArtistEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Artist")
    private Long id;

    private String name;

    private String userId;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArtworkEntity> artwork;
    
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
    public String getUserId(){
        return userId;
    }

    /**
     * @generated
     */
    public void setUserId(String userId){
        this.userId = userId;
    }

    /**
     * @generated
     */
    public List<ArtworkEntity> getArtwork() {
        return artwork;
    }

    /**
     * @generated
     */
    public void setArtwork(List<ArtworkEntity> artwork) {
        this.artwork = artwork;
    }

}
