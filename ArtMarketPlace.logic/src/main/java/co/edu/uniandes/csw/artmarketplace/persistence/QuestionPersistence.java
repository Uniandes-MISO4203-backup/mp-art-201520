package co.edu.uniandes.csw.artmarketplace.persistence;

import co.edu.uniandes.csw.artmarketplace.entities.QuestionEntity;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 * La clase QuestionPersistence esta disennada para gestionar la creacion,
 * modificacion y eleminacion de preguntas realizadas por los comprador sobre
 * las obras de arte.
 *
 * @author lf.mendivelso10
 */
@Stateless
public class QuestionPersistence extends CrudPersistence<QuestionEntity> {
    
    private static final Logger LOGGER = Logger.getLogger(QuestionPersistence.class);

    /**
     * El metodo constructor de QuestionPersistence no contiene parametro, y en
     * su ejecucion, hace la asignacion del tipo de EntityClass requerida para
     * la uso del CrudPersistence.
     */
    public QuestionPersistence() {
        this.entityClass = QuestionEntity.class;
    }

    public List<QuestionEntity> listByArtwork(Long artist) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("artwork_id", artist);
            Query q = em.createNamedQuery("QuestionEntity.listByArtwork");
            q.setParameter("artwork_id", artist);
            return q.getResultList();
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
            return null;
        }
    }

}
