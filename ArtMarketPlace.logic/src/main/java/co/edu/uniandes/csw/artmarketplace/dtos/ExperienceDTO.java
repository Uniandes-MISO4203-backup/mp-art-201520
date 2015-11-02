/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.dtos;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO que hace referencia a la experiencia y educacion de un registro dentro de
 * la hoja de vida. Se manejan sus principales atributos y relaciones.
 *
 * @author vp.salcedo93
 */
@XmlRootElement
public class ExperienceDTO extends BasicDTO {

    /**
     * Titulo del registro de experiencia o educacion.
     */
    private String title;

    /**
     * Lugar del registro de experiencia o educacion.
     */
    private String place;

    /**
     * Fecha de inicio del registro de experiencia o educacion.
     */
    private Date startDate;

    /**
     * Fecha de finalizacion del registro de experiencia o educacion.
     */
    private Date finishDate;
    /**
     * Resumen (Hoja de vida) al que pertenece el registro.
     */
    private ResumeDTO resume;
    /**
     * Tipo de registro: puede ser Experiencia Laboral o Educacion.
     */
    private String type;

    /**
     * Metodo que obtiene el tipo de registro.
     *
     * @return String. Cadena de caracteres con el tipo de registro.
     */
    public String getType() {
        return type;
    }

    /**
     * Metodo que actualiza el tipo de registro.
     *
     * @param type. Cadena de caracteres con el tipo de registro.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Metodo para obtener la hoja de vida del registro de experiencia o
     * educacion.
     *
     * @return ResumeEntity. Hoja de vida del registro.
     */
    public ResumeDTO getResume() {
        return resume;
    }

    /**
     * Metodo para actualizar la hoja de vida del registro de experiencia o
     * educacion.
     *
     * @param resume. Hoja de vida del registro.
     */
    public void setResume(ResumeDTO resume) {
        this.resume = resume;
    }

    /**
     * Metodo para obtener el lugar del registro de experiencia o educacion.
     *
     * @return String. Lugar del registro. (Empresa, Universidad, etc...)
     */
    public String getPlace() {
        return place;
    }

    /**
     * Metodo para actualizar el lugar del registro de experiencia o educacion.
     *
     * @param place. String - Lugar del registro. (Empresa, Universidad, etc...)
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * Metodo para obtener el titulo del registro de experiencia o educacion.
     *
     * @return String. Titulo del registro.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Metodo para actualizar el titulo del registro de experiencia o educacion.
     *
     * @param title. String - Titulo del registro.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Metodo para obtener la fecha de fin del registro de experiencia o
     * educacion.
     *
     * @return Date. Fecha de fin del registro.
     */
    public Date getFinishDate() {
        return finishDate;
    }

    /**
     * Metodo para actualizar la fecha de fin del registro de experiencia o
     * educacion.
     *
     * @param finishDate. Date - Fecha de fin del registro.
     */
    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    /**
     * Metodo para obtener la fecha de inicio del registro de experiencia o
     * educacion.
     *
     * @return Date. Fecha de inicio del registro.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Metodo para actualizar la fecha de inicio del registro de experiencia o
     * educacion.
     *
     * @param startDate. Date - Fecha de inicio del registro.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
