package co.edu.uniandes.csw.artmarketplace.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @generated
 */
@XmlRootElement
public class ArtworkGaleryItemDTO extends BasicDTO {

    private TypeDTO type;
    private String link;
    private ArtworkDTO artwork;

    public TypeDTO getType() {
        return type;
    }

    public void setType(TypeDTO type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ArtworkDTO getArtwork() {
        return artwork;
    }

    public void setArtwork(ArtworkDTO artwork) {
        this.artwork = artwork;
    }
}
