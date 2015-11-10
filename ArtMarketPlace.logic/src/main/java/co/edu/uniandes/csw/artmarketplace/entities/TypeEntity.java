package co.edu.uniandes.csw.artmarketplace.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @generated
 */
@Entity
@XmlRootElement
public class TypeEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "ArtworkGaleryItemType")
    private Long id;

    private String name;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String type) {
        this.name = type;
    }
}
