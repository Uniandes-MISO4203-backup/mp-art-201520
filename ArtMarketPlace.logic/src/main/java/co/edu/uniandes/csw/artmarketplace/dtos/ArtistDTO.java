package co.edu.uniandes.csw.artmarketplace.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @generated
 */
@XmlRootElement
public class ArtistDTO extends PersonDTO {

    private List<ArtworkDTO> artwork;

    public List<ArtworkDTO> getArtwork() {
        return artwork;
    }

    public void setArtwork(List<ArtworkDTO> artwork) {
        this.artwork = artwork;
    }
}
