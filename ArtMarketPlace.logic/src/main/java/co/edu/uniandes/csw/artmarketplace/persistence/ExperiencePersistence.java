/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.persistence;

import co.edu.uniandes.csw.artmarketplace.entities.ExperienceEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ResumeEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Clase ExperiencePersistence hace referencia al manejo de un registro de
 * experiencia o educacion de la hoja de vida del artista.
 *
 * @author vp.salcedo93
 */
@Stateless
public class ExperiencePersistence extends CrudPersistence<ExperienceEntity> {

    /**
     * Metodo constructor del objeto de persistencia del registro. Hace uso del
     * CrudPersistence de acuerdo a la entidad correspondiente.
     */
    public ExperiencePersistence() {
        this.entityClass = ExperienceEntity.class;
    }

    /**
     * Metodo que maneja el query para obtener la lista de registros para un
     * resumen u hoja de vida de un artista.
     *
     * @param resume. Identificador de la Hoja de vida
     * @return List. Lista con las entidades de los registros de experiencia.
     */
    public List<ExperienceEntity> listByResume(Long resume) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("resume_id", resume);
            Query q = em.createNamedQuery("ExperienceEntity.listByResume");
            q.setParameter("resume_id", resume);
            return q.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo que ejecuta el query para obtener la hoja de vida de un artista.
     *
     * @param id. Identificador del artista.
     * @return Resumeentity. Hoja de vida del artista solicitado.
     */
    public ResumeEntity getResumeByArtistId(Long id) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("artist_id", id);
            List<ResumeEntity> resumes = this.executeListNamedQuery("Resume.getByArtistId", params);
            if (resumes.isEmpty()) {
                return null;
            } else {
                return resumes.get(0);
            }
        } catch (NoResultException e) {
            throw new RuntimeException(e);
        }
    }
}