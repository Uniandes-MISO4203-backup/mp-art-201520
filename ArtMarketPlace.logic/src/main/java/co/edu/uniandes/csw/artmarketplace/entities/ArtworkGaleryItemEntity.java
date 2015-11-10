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
@NamedQueries(
        {
            @NamedQuery(name = "ArtworkGaleryItemEntity.searchArtworksByFormat",
                    query = "SELECT DISTINCT a.artwork FROM ArtworkGaleryItemEntity a WHERE a.type.name = :type")
        }
)
public class ArtworkGaleryItemEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "ArtworkGaleryItem")
    private Long id;

    @ManyToOne
    private TypeEntity type;

    private String link;

    @ManyToOne
    private ArtworkEntity artwork;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeEntity getType() {
        return type;
    }

    public void setType(TypeEntity type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ArtworkEntity getArtwork() {
        return artwork;
    }

    public void setArtwork(ArtworkEntity artwork) {
        this.artwork = artwork;
    }
}
