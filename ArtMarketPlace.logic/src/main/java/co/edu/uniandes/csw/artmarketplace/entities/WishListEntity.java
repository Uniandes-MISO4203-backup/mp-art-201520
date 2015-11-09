/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author ms.lancheros10
 */
@Entity
@NamedQueries(
        {
            @NamedQuery(name = "WishList.getByClientId", query = "SELECT w FROM WishListEntity w WHERE w.client.id=:client_id"),
            @NamedQuery(name = "WishList.getByClientIdAndArtWorkId", query = "SELECT w FROM WishListEntity w WHERE w.client.id=:client_id and w.artwork.id=:artwork_id")
        }
)
public class WishListEntity implements Serializable {
    
    @Id
    @GeneratedValue(generator = "CartItem")
    private Long id;
    
    @ManyToOne
    private ArtworkEntity artwork;
    
    @ManyToOne
    private ClientEntity client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArtworkEntity getArtwork() {
        return artwork;
    }

    public void setArtwork(ArtworkEntity artwork) {
        this.artwork = artwork;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }
    
    
    
}
