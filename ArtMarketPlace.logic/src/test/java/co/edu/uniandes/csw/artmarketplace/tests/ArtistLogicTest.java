package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.ejbs.ArtistLogic;
import co.edu.uniandes.csw.artmarketplace.api.IArtistLogic;
import co.edu.uniandes.csw.artmarketplace.converters.ArtistConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtistDTO;
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
public class ArtistLogicTest {

    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ArtistEntity.class.getPackage())
                .addPackage(ArtistDTO.class.getPackage())
                .addPackage(ArtistConverter.class.getPackage())
                .addPackage(ArtistLogic.class.getPackage())
                .addPackage(IArtistLogic.class.getPackage())
                .addPackage(ArtistPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IArtistLogic artistLogic;

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
        ArtistDTO dto = new ArtistDTO();
        dto.setName(generateRandom(String.class));
        dto.setUserId(generateRandom(String.class));

        ArtistDTO result = artistLogic.createArtist(dto);

        Assert.assertNotNull(result);

        ArtistEntity entity = em.find(ArtistEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getUserId(), entity.getUserId());
    }

    /**
     * @generated
     */
    @Test
    public void getArtistsTest() {
        List<ArtistDTO> list = artistLogic.getArtists(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (ArtistDTO dto : list) {
            boolean found = false;
            for (ArtistEntity entity : data) {
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
    public void getArtistTest() {
        ArtistEntity entity = data.get(0);
        ArtistDTO dto = artistLogic.getArtist(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getUserId(), dto.getUserId());
    }

    /**
     * @generated
     */
    @Test
    public void deleteArtistTest() {
        ArtistEntity entity = data.get(0);
        artistLogic.deleteArtist(entity.getId());
        ArtistEntity deleted = em.find(ArtistEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateArtistTest() {
        ArtistEntity entity = data.get(0);

        ArtistDTO dto = new ArtistDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setUserId(generateRandom(String.class));

        artistLogic.updateArtist(dto);

        ArtistEntity resp = em.find(ArtistEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getUserId(), resp.getUserId());
    }

    /**
     * @generated
     */
    @Test
    public void getArtistPaginationTest() {
        //Page 1
        List<ArtistDTO> dto1 = artistLogic.getArtists(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<ArtistDTO> dto2 = artistLogic.getArtists(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (ArtistDTO dto : dto1) {
            boolean found = false;
            for (ArtistEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (ArtistDTO dto : dto2) {
            boolean found = false;
            for (ArtistEntity entity : data) {
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
        List<ArtistEntity> cache = new ArrayList<ArtistEntity>();
        List<ArtistDTO> list = artistLogic.findByName(name);

        for (ArtistEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (ArtistDTO dto : list) {
            boolean found = false;
            for (ArtistEntity cacheEntity : cache) {
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

    @Test
    public void aditionalDTOInfo() {
        ArtistDTO dto = new ArtistDTO();

        String firstName = generateRandom(String.class);
        String lastName = generateRandom(String.class);
        String email = generateRandom(String.class);

        dto.setFirstName(firstName);
        dto.setLastname(lastName);
        dto.setEmail(email);

        Assert.assertEquals(dto.getFirstName(), firstName);
        Assert.assertEquals(dto.getLastname(), lastName);
        Assert.assertEquals(dto.getEmail(), email);
    }

    @Test
    public void countArtists() {
        List<ArtistDTO> list = artistLogic.getArtists(null, null);
        Assert.assertEquals(artistLogic.countArtists(), list.size());
    }

    @Test
    public void getArtistByUserId() {
        String userId = data.get(0).getUserId();
        ArtistDTO dto = artistLogic.getArtistByUserId(userId);
        Assert.assertEquals(dto.getUserId(), userId);
    }
}
