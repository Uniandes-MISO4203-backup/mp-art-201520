package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.entities.ArtistEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.ArtistPersistence;
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
public class ArtistPersistenceTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ArtistEntity.class.getPackage())
                .addPackage(ArtistPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private ArtistPersistence artistPersistence;

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
        em.createQuery("delete from ArtistEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<ArtistEntity> data = new ArrayList<ArtistEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ArtistEntity entity = new ArtistEntity();
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
    public void createArtistTest() {
        ArtistEntity newEntity = new ArtistEntity();
        newEntity.setName(generateRandom(String.class));
        newEntity.setUserId(generateRandom(String.class));

        ArtistEntity result = artistPersistence.create(newEntity);

        Assert.assertNotNull(result);

        ArtistEntity entity = em.find(ArtistEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getUserId(), entity.getUserId());
    }

    /**
     * @generated
     */
    @Test
    public void getArtistsTest() {
        List<ArtistEntity> list = artistPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (ArtistEntity ent : list) {
            boolean found = false;
            for (ArtistEntity entity : data) {
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
    public void getArtistTest() {
        ArtistEntity entity = data.get(0);
        ArtistEntity newEntity = artistPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getUserId(), newEntity.getUserId());
    }

    /**
     * @generated
     */
    @Test
    public void deleteArtistTest() {
        ArtistEntity entity = data.get(0);
        artistPersistence.delete(entity.getId());
        ArtistEntity deleted = em.find(ArtistEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateArtistTest() {
        ArtistEntity entity = data.get(0);

        ArtistEntity newEntity = new ArtistEntity();

        newEntity.setId(entity.getId());
        newEntity.setName(generateRandom(String.class));
        newEntity.setUserId(generateRandom(String.class));

        artistPersistence.update(newEntity);

        ArtistEntity resp = em.find(ArtistEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getUserId(), resp.getUserId());
    }

    /**
     * @generated
     */
    @Test
    public void getArtistPaginationTest() {
        //Page 1
        List<ArtistEntity> ent1 = artistPersistence.findAll(1, 2);
        Assert.assertNotNull(ent1);
        Assert.assertEquals(2, ent1.size());
        //Page 2
        List<ArtistEntity> ent2 = artistPersistence.findAll(2, 2);
        Assert.assertNotNull(ent2);
        Assert.assertEquals(1, ent2.size());

        for (ArtistEntity ent : ent1) {
            boolean found = false;
            for (ArtistEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (ArtistEntity ent : ent2) {
            boolean found = false;
            for (ArtistEntity entity : data) {
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
        List<ArtistEntity> cache = new ArrayList<ArtistEntity>();
        List<ArtistEntity> list = artistPersistence.findByName(name);

        for (ArtistEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(list.size(), cache.size());
        for (ArtistEntity ent : list) {
            boolean found = false;
            for (ArtistEntity cacheEntity : cache) {
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
