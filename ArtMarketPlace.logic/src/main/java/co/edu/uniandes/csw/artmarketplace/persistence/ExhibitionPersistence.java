/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.persistence;

import co.edu.uniandes.csw.artmarketplace.entities.ExhibitionEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ResumeEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * La clase ExhibitionPersistence tiene como finalidad hacer la persistencia
 * de la información de las exhibiciones del artista.
 * @author lf.mendivelso10
 */
@Stateless
public class ExhibitionPersistence  extends CrudPersistence<ExhibitionEntity>{
    
    /**
     * Metodo constructor de la clase ExhibitionPersistence. Permite asignar al
     * entityClass del crud la entidad del resumen (hoja de vida).
     */
    public ExhibitionPersistence() {
        this.entityClass = ExhibitionEntity.class;
    }

    /**
     * Metodo que maneja el query para obtener la lista de registros para un
     * resumen u hoja de vida de un artista.
     *
     * @param resume. Identificador de la Hoja de vida
     * @return List. Lista con las entidades de los registros de exhibicion.
     */
    public List<ExhibitionEntity> listByResume(Long resume) {
        List<ExhibitionEntity> exhibitions = new ArrayList<ExhibitionEntity>();
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("resume_id", resume);
            Query q = em.createNamedQuery("ExhibitionEntity.listByResume");
            q.setParameter("resume_id", resume);
            exhibitions=q.getResultList();
        } catch (Exception e) {
            Logger.getLogger(AdminPersistence.class.getName()).log(Level.SEVERE, null, e);
        }
        return exhibitions;
    }
    
    /**
     * Metodo que ejecuta el query para obtener la hoja de vida de un artista.
     *
     * @param id. Identificador del artista.
     * @return Resumeentity. Hoja de vida del artista solicitado.
     */
    public ResumeEntity getResumeByArtistId(Long id) {
        ResumeEntity result=null;
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("artist_id", id);
            List<ResumeEntity> resumes = this.executeListNamedQuery("Resume.getByArtistId", params);
            if (!resumes.isEmpty()) {
                result= resumes.get(0);
            }
        } catch (NoResultException e) {
            Logger.getLogger(AdminPersistence.class.getName()).log(Level.SEVERE, null, e); 
        }
        return result;
    }

}
