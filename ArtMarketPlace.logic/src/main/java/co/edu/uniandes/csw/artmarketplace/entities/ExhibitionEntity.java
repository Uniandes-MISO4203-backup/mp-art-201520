package co.edu.uniandes.csw.artmarketplace.entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ExhibitionEntity es una clase disenada para gestionar la informacion
 * correspondente a exhibiciones en las que un artista participado y desea
 * reflejar en su resumen.
 *
 * @version 1.0.0
 * @author lf.mendivelso10
 */
@Entity
@NamedQueries(
        {
            @NamedQuery(name = "Exhibition.getResumeByArtistId", query = "SELECT r FROM ResumeEntity r left join fetch r.exhibitions WHERE r.artist.id=:artist_id"),
            @NamedQuery(name = "ExhibitionEntity.listByResume", query = "SELECT r FROM ExhibitionEntity r WHERE r.resume.id=:resume_id")
        }
)
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
    @Temporal(TemporalType.DATE)
    private Calendar startDate;

    /**
     * Fecha de fin de la exhibicion
     */
    @Temporal(TemporalType.DATE)
    private Calendar endDate;

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

    /**
     * Resumen al cual pertenece el registro de la exhibicion.
     */
    @ManyToOne
    private ResumeEntity resume;

    /**
     * Metodo de acceso para la variable id.
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo de modificación para la variable id.
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Metodo de acceso para la variable description.
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Metodo de modificación para la variable description.
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Metodo de acceso para la variable name.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo de modificación para la variable name.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo de acceso para la variable endDate.
     *
     * @return
     */
    public Calendar getEndDate() {
        return endDate;
    }

    /**
     * Metodo de modificación para la variable endDate.
     *
     * @param endDate
     */
    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    /**
     * Metodo de acceso para la variable startDate.
     *
     * @return
     */
    public Calendar getStartDate() {
        return startDate;
    }

    /**
     * Metodo de modificación para la variable startDate.
     *
     * @param startDate
     */
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    /**
     * Metodo de acceso para la variable kindOfEvent.
     *
     * @return
     */
    public String getKindOfEvent() {
        return kindOfEvent;
    }

    /**
     * Metodo de modificación para la variable kindOfEvent.
     *
     * @param kindOfEvent
     */
    public void setKindOfEvent(String kindOfEvent) {
        this.kindOfEvent = kindOfEvent;
    }

    /**
     * Metodo de acceso para la variable place.
     *
     * @return
     */
    public String getPlace() {
        return place;
    }

    /**
     * Metodo de modificación para la variable place.
     *
     * @param place
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * Metodo de acceso para la variable resume.
     *
     * @return
     */
    public ResumeEntity getResume() {
        return resume;
    }

    /**
     * Metodo de modificación para la variable resume.
     *
     * @param resume
     */
    public void setResume(ResumeEntity resume) {
        this.resume = resume;
    }

    /**
     * Metodo de acceso para la variable awards.
     *
     * @return
     */
    public String getAwards() {
        return awards;
    }

    /**
     * Metodo de modificación para la variable awards.
     *
     * @param awards
     */
    public void setAwards(String awards) {
        this.awards = awards;
    }
}
