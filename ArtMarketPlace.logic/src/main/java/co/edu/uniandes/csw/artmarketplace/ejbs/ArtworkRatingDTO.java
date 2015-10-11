package co.edu.uniandes.csw.artmarketplace.ejbs;

import co.edu.uniandes.csw.artmarketplace.entities.ClientEntity;

/**
 * La clase ArtworkRatingEntity esta disennada para persistir las votaciones realizadas por los compradores
 * frente a las obras de arte de un artista.
 * 
 * @author lf.mendivelso10
 * @version 1.0.0
 */
public class ArtworkRatingDTO {
    /**
     * Es el identificador unico de la votacion hecha por una comprador frente a una Obra de arte.
     */
    private Long id;
    
    /** 
     * Es el comprador quien realiza la votacion.
     */
    private ClientEntity client;

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
    public ClientEntity getClient() {
        return client;
    }

    /**
     * Es un metodo de acceso que modifica la informacion del cliente quien hizo la valoracion de la obra de arte.
     * @param client es el cliente que hizo la valoracion.
     */
    public void setClient(ClientEntity client) {
        this.client = client;
    }
}
