package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.api.IAdminLogic;
import co.edu.uniandes.csw.artmarketplace.converters.AdminConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.AdminDTO;
import co.edu.uniandes.csw.artmarketplace.ejbs.AdminLogic;
import co.edu.uniandes.csw.artmarketplace.entities.AdminEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.AdminPersistence;
import static co.edu.uniandes.csw.artmarketplace.tests._TestUtil.*;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class AdminLogicTest {

    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(AdminEntity.class.getPackage())
                .addPackage(AdminDTO.class.getPackage())
                .addPackage(AdminConverter.class.getPackage())
                .addPackage(AdminLogic.class.getPackage())
                .addPackage(IAdminLogic.class.getPackage())
                .addPackage(AdminPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IAdminLogic adminLogic;

    /**
     * @generated
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    @Inject
    UserTransaction utx;

    /**
     * @generated
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * @generated
     */
    private void clearData() {
        em.createQuery("delete from AdminEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<AdminEntity> data = new ArrayList<AdminEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            AdminEntity entity = new AdminEntity();
            entity.setName(generateRandom(String.class));
            entity.setUserId(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createAdminTest() {
        AdminDTO adminDTO = AdminConverter.refEntity2DTO(data.get(0));
        
        AdminDTO dto = new AdminDTO();
        dto.setId(adminDTO.getId());
        dto.setName(adminDTO.getName());
        dto.setUserId(adminDTO.getUserId());
        
        Assert.assertEquals(dto.getId(), adminDTO.getId());
        Assert.assertEquals(dto.getName(), adminDTO.getName());
        Assert.assertEquals(dto.getUserId(), adminDTO.getUserId());
    }

    @Test
    public void getAdminByUserId() {
        String userId = data.get(0).getUserId();
        AdminDTO dto = adminLogic.getAdminByUserId(userId);
        Assert.assertEquals(dto.getUserId(), userId);
    }
}
