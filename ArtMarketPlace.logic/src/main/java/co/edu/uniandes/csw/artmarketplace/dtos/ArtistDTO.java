package co.edu.uniandes.csw.artmarketplace.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @generated
 */
@XmlRootElement 
public class ArtistDTO {

    private Long id;
    private String name;
    private String userId;
    private List<ArtworkDTO> artwork;
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
    public String getUserId() {
        return userId;
    }

    /**
     * @generated
     */
    public void setUserId(String userid) {
        this.userId = userid;
    }

    /**
     * @generated
     */
    public List<ArtworkDTO> getArtwork() {
        return artwork;
    }

    /**
     * @generated
     */
    public void setArtwork(List<ArtworkDTO> artwork) {
        this.artwork = artwork;
    }

}