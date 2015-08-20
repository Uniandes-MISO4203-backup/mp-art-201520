package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.ArtworkPersistence;
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
public class ArtworkPersistenceTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ArtworkEntity.class.getPackage())
                .addPackage(ArtworkPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private ArtworkPersistence artworkPersistence;

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
        em.createQuery("delete from ArtworkEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<ArtworkEntity> data = new ArrayList<ArtworkEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ArtworkEntity entity = new ArtworkEntity();
            entity.setName(generateRandom(String.class));
            entity.setPicture(generateRandom(String.class));
            entity.setPrice(generateRandom(Integer.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createArtworkTest() {
        ArtworkEntity newEntity = new ArtworkEntity();
        newEntity.setName(generateRandom(String.class));
        newEntity.setPicture(generateRandom(String.class));
        newEntity.setPrice(generateRandom(Integer.class));

        ArtworkEntity result = artworkPersistence.create(newEntity);

        Assert.assertNotNull(result);

        ArtworkEntity entity = em.find(ArtworkEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getPicture(), entity.getPicture());
        Assert.assertEquals(newEntity.getPrice(), entity.getPrice());
    }

    /**
     * @generated
     */
    @Test
    public void getArtworksTest() {
        List<ArtworkEntity> list = artworkPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (ArtworkEntity ent : list) {
            boolean found = false;
            for (ArtworkEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * @generated
     */
    @Test
    public void getArtworkTest() {
        ArtworkEntity entity = data.get(0);
        ArtworkEntity newEntity = artworkPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getPicture(), newEntity.getPicture());
        Assert.assertEquals(entity.getPrice(), newEntity.getPrice());
    }

    /**
     * @generated
     */
    @Test
    public void deleteArtworkTest() {
        ArtworkEntity entity = data.get(0);
        artworkPersistence.delete(entity.getId());
        ArtworkEntity deleted = em.find(ArtworkEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateArtworkTest() {
        ArtworkEntity entity = data.get(0);

        ArtworkEntity newEntity = new ArtworkEntity();

        newEntity.setId(entity.getId());
        newEntity.setName(generateRandom(String.class));
        newEntity.setPicture(generateRandom(String.class));
        newEntity.setPrice(generateRandom(Integer.class));

        artworkPersistence.update(newEntity);

        ArtworkEntity resp = em.find(ArtworkEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getPicture(), resp.getPicture());
        Assert.assertEquals(newEntity.getPrice(), resp.getPrice());
    }

    /**
     * @generated
     */
    @Test
    public void getArtworkPaginationTest() {
        //Page 1
        List<ArtworkEntity> ent1 = artworkPersistence.findAll(1, 2);
        Assert.assertNotNull(ent1);
        Assert.assertEquals(2, ent1.size());
        //Page 2
        List<ArtworkEntity> ent2 = artworkPersistence.findAll(2, 2);
        Assert.assertNotNull(ent2);
        Assert.assertEquals(1, ent2.size());

        for (ArtworkEntity ent : ent1) {
            boolean found = false;
            for (ArtworkEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (ArtworkEntity ent : ent2) {
            boolean found = false;
            for (ArtworkEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * @generated
     */
    @Test
    public void findByName() {
        String name = data.get(0).getName();
        List<ArtworkEntity> cache = new ArrayList<ArtworkEntity>();
        List<ArtworkEntity> list = artworkPersistence.findByName(name);

        for (ArtworkEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(list.size(), cache.size());
        for (ArtworkEntity ent : list) {
            boolean found = false;
            for (ArtworkEntity cacheEntity : cache) {
                if (cacheEntity.getName().equals(ent.getName())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                Assert.fail();
            }
        }
    }
}
