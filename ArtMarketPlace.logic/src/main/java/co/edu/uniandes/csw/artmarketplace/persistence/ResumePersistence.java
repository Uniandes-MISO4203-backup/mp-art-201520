package co.edu.uniandes.csw.artmarketplace.persistence;

import co.edu.uniandes.csw.artmarketplace.entities.ResumeEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 * La clase Resume hace referencia a la hoja de vida que tiene un artista. En
 * esta se manejan sus principales atributos y relaciones.
 *
 * @author vp.salcedo93
 */
@Stateless
public class ResumePersistence extends CrudPersistence<ResumeEntity> {

    /**
     * Metodo constructor de la clase ResumePersistence. Permite asignar al
     * entityClass del crud la entidad del resumen (hoja de vida).
     */
    public ResumePersistence() {
        this.entityClass = ResumeEntity.class;
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
            Logger.getLogger(AdminPersistence.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public List<ResumeEntity> searchArtistByName(String artistName) {
        List<ResumeEntity> result = new ArrayList<ResumeEntity>();
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("artistName", artistName);
            result = executeListNamedQuery("Resume.searchArtistsByName", params);
        } catch (Exception e) {
            Logger.getLogger(AdminPersistence.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }
    
    public List<ResumeEntity> searchArtistsBetweenRatings(float artistMinRating,float artistMaxRating) {
        List<ResumeEntity> result = new ArrayList<ResumeEntity>();
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("artistMinRating", artistMinRating);
            params.put("artistMaxRating", artistMaxRating);
            result = executeListNamedQuery("Resume.searchArtistsBetweenRatings", params);
        } catch (Exception e) {
            Logger.getLogger(AdminPersistence.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }
    
}
