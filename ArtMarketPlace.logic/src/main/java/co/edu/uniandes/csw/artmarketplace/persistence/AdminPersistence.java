/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.persistence;

/**
 *
 * @author ms.lancheros10
 */
import co.edu.uniandes.csw.artmarketplace.entities.AdminEntity;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import org.apache.log4j.Logger;

/**
 * @generated
 */
@Stateless
public class AdminPersistence extends CrudPersistence<AdminEntity> {
    
    private static final Logger LOGGER = Logger.getLogger(AdminPersistence.class);

    /**
     * @generated
     */
    public AdminPersistence() {
        this.entityClass = AdminEntity.class;
    }

    public AdminEntity getAdminByUserId(String userId) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("user_id", userId);
            return this.executeSingleNamedQuery("Admin.getByUserId", params);
        } catch (NoResultException e) {
            LOGGER.info(e.getMessage());
            return null;
        }
    }
}
