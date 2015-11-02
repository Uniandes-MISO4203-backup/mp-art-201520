/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.dtos;

import java.util.Calendar;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jh.rubiano10
 */
@XmlRootElement
public class BlogDTO extends BasicDTO {

    /**
     * Texto de la entrada del Blog.
     */
    private String entry;

    /**
     * Título del Blog.
     */
    private String title;

    /**
     * Fecha de Creación de la entrada
     */
    private Calendar dateEntry;

    /**
     * Id del cliente/artista que realizó la entrada al Blog
     */
    private Long clientId;

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

    public Calendar getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(Calendar dateEntry) {
        this.dateEntry = dateEntry;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
