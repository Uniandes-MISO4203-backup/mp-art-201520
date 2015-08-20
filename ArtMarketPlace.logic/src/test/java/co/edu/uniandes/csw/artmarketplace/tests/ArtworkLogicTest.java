package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.ejbs.ArtworkLogic;
import co.edu.uniandes.csw.artmarketplace.api.IArtworkLogic;
import co.edu.uniandes.csw.artmarketplace.converters.ArtworkConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkDTO;
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
public class ArtworkLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ArtworkEntity.class.getPackage())
                .addPackage(ArtworkDTO.class.getPackage())
                .addPackage(ArtworkConverter.class.getPackage())
                .addPackage(ArtworkLogic.class.getPackage())
                .addPackage(IArtworkLogic.class.getPackage())
                .addPackage(ArtworkPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IArtworkLogic artworkLogic;

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
        ArtworkDTO dto = new ArtworkDTO();
        dto.setName(generateRandom(String.class));
        dto.setPicture(generateRandom(String.class));
        dto.setPrice(generateRandom(Integer.class));

        ArtworkDTO result = artworkLogic.createArtwork(dto);

        Assert.assertNotNull(result);

        ArtworkEntity entity = em.find(ArtworkEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getPicture(), entity.getPicture());
        Assert.assertEquals(dto.getPrice(), entity.getPrice());
    }

    /**
     * @generated
     */
    @Test
    public void getArtworksTest() {
        List<ArtworkDTO> list = artworkLogic.getArtworks(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (ArtworkDTO dto : list) {
            boolean found = false;
            for (ArtworkEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
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
        ArtworkDTO dto = artworkLogic.getArtwork(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getPicture(), dto.getPicture());
        Assert.assertEquals(entity.getPrice(), dto.getPrice());
    }

    /**
     * @generated
     */
    @Test
    public void deleteArtworkTest() {
        ArtworkEntity entity = data.get(0);
        artworkLogic.deleteArtwork(entity.getId());
        ArtworkEntity deleted = em.find(ArtworkEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateArtworkTest() {
        ArtworkEntity entity = data.get(0);

        ArtworkDTO dto = new ArtworkDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setPicture(generateRandom(String.class));
        dto.setPrice(generateRandom(Integer.class));

        artworkLogic.updateArtwork(dto);

        ArtworkEntity resp = em.find(ArtworkEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getPicture(), resp.getPicture());
        Assert.assertEquals(dto.getPrice(), resp.getPrice());
    }

    /**
     * @generated
     */
    @Test
    public void getArtworkPaginationTest() {
        //Page 1
        List<ArtworkDTO> dto1 = artworkLogic.getArtworks(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<ArtworkDTO> dto2 = artworkLogic.getArtworks(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (ArtworkDTO dto : dto1) {
            boolean found = false;
            for (ArtworkEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (ArtworkDTO dto : dto2) {
            boolean found = false;
            for (ArtworkEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
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
        List<ArtworkDTO> list = artworkLogic.findByName(name);

        for (ArtworkEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (ArtworkDTO dto : list) {
            boolean found = false;
            for (ArtworkEntity cacheEntity : cache) {
                if (cacheEntity.getName().equals(dto.getName())) {
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
