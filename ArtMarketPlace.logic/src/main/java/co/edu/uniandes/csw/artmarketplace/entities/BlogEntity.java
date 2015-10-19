/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jh.rubiano10
 */

/**
 * Query que trae las entradas de un artisita dado el id del mismo.
 * @author jh.rubiano10
 */

@Entity
@NamedQueries({
    @NamedQuery(name = "Blog.getEntryArtist", query = "select u from BlogEntity u WHERE u.client_id = :idArtist")
})
public class BlogEntity implements Serializable {
    
    
    
    /**
     * Id de la entrada
     */
    @Id
    @GeneratedValue(generator = "Blog")
    private Long id;
    
    /**
     * Texto de la entrada, en este caso de tipo TEXT para permitir más de 255 carácteres
     */
    @Column(columnDefinition="TEXT")
    private String entry;
    
    private String title;
    
    @Temporal(TemporalType.DATE)
    private Date date;

    private Long client_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }
}
