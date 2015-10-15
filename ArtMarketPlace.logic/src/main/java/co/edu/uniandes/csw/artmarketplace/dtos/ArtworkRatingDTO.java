package co.edu.uniandes.csw.artmarketplace.dtos;

import co.edu.uniandes.csw.artmarketplace.entities.ClientEntity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * La clase ArtworkRatingEntity esta disennada para persistir las votaciones realizadas por los compradores
 * frente a las obras de arte de un artista.
 * 
 * @author lf.mendivelso10
 * @version 1.0.0
 */
@XmlRootElement 
public class ArtworkRatingDTO {
    /**
     * Es el identificador unico de la votacion hecha por una comprador frente a una Obra de arte.
     */
    private Long id;
    
    /** 
     * Es el comprador quien realiza la votacion.
     */
    private ClientDTO client;
    
    /**
     * Es la obra de arte a la cual se hace referencia.
     */
    private ArtworkDTO artwork;

    /**
     * Es una metodo de acceso que retorna el identificador unico de la votacion hecha por un comprador frente a una obra de arte.
     * @return el identificador de la votacion.
     */
    public Long getId() {
        return id;
    }

    /**
     * Es un metodo de acceso que modifica el identificador unico de la votacion hecha por un comprador frente a una obra de arte.
     * @param id es el nuevo identificador de la votacion.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Es un metodo de acceso que retorna la informacion del cliente quien hizo la valoracion de la obra de arte.
     * @return el cliente que hizo la votacion.
     */
    public ClientDTO getClient() {
        return client;
    }

    /**
     * Es un metodo de acceso que modifica la informacion del cliente quien hizo la valoracion de la obra de arte.
     * @param client es el cliente que hizo la valoracion.
     */
    public void setClient(ClientDTO client) {
        this.client = client;
    }

    /**
     * Es un metodo de acceso que retorna la referencia de la obra de arte a la cual se hace referencia con
     * la calificacion.
     * @return un objecto de la clase ArtworkDTO con la informacion de referencia.
     */
    public ArtworkDTO getArtwork() {
        return artwork;
    }

    /**
     * Es un metodo de acceso que modifica la referencia de la obra de arte a la cual se hace referencia con
     * la calificacion.
     * @param artwork es la nueva referencia de la calificacion
     */
    public void setArtwork(ArtworkDTO artwork) {
        this.artwork = artwork;
    }
    
}
