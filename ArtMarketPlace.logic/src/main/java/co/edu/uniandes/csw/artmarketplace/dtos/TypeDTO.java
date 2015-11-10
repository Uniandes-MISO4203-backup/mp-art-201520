package co.edu.uniandes.csw.artmarketplace.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @generated
 */
@XmlRootElement
public class TypeDTO extends BasicDTO {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String type) {
        this.name = type;
    }
}
