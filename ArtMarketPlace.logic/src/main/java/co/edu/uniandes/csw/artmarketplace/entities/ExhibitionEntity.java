package co.edu.uniandes.csw.artmarketplace.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 * ExhibitionEntity es una clase disenada para gestionar la informacion
 * correspondente a exhibiciones en las que un artista participado y desea reflejar
 * en su resumen.
 * @version 1.0.0
 * @author lf.mendivelso10
 */
@Entity
public class ExhibitionEntity implements Serializable {
    
    /**
     * Identificador unico de la exhibicion registrado en el resumen del artista
     */
    @Id
    @GeneratedValue(generator = "Exhibition")
    private Long id;
    
    /**
     * Nombre de la exhibicion
     */
    private String name;
    
    /**
     * Descripcion de la exhibicion
     */
    private String description;
    
    /**
     * Fecha de inicio de la exhibicion
     */
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;
    
    /**
     * Fecha de fin de la exhibicion
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endDate;
    
    /**
     * Lugar donde se llevo a cabo el evento
     */
    private String place;
    
    /**
     * Tipo de evento
     */
    private String kindOfEvent;
    
    /**
     * Reconocmiento recibido en el la exhibicion
     */
    private String awards;
    
    @ManyToOne
    private ResumeEntity resume;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getKindOfEvent() {
        return kindOfEvent;
    }

    public void setKindOfEvent(String kindOfEvent) {
        this.kindOfEvent = kindOfEvent;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public ResumeEntity getResume() {
        return resume;
    }

    public void setResume(ResumeEntity resume) {
        this.resume = resume;
    }
    
    
    
}

