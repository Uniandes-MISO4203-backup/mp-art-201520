package co.edu.uniandes.csw.artmarketplace.tests;

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
public class AdminPersistenceTest {

    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(AdminEntity.class.getPackage())
                .addPackage(AdminPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private AdminPersistence adminPersistence;

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
        AdminEntity newEntity = new AdminEntity();
        newEntity.setName(generateRandom(String.class));
        newEntity.setUserId(generateRandom(String.class));

        AdminEntity result = adminPersistence.create(newEntity);

        Assert.assertNotNull(result);

        AdminEntity entity = em.find(AdminEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getUserId(), entity.getUserId());
    }
    
    @Test
    public void updateAdminTest() {
        AdminEntity entity = data.get(0);

        AdminEntity newEntity = new AdminEntity();

        newEntity.setId(entity.getId());
        newEntity.setName(generateRandom(String.class));
        newEntity.setUserId(generateRandom(String.class));

        adminPersistence.update(newEntity);

        AdminEntity resp = em.find(AdminEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getUserId(), resp.getUserId());
    }

    @Test
    public void findByUserId() {
        String userId = data.get(0).getUserId();
        AdminEntity entity = adminPersistence.getAdminByUserId(userId);
        Assert.assertEquals(entity.getUserId(), userId);

        entity = adminPersistence.getAdminByUserId("-1");
        Assert.assertEquals(entity, null);
    }
}
