package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.ejbs.ArtworkLogic;
import co.edu.uniandes.csw.artmarketplace.api.IArtworkLogic;
import co.edu.uniandes.csw.artmarketplace.converters.ArtworkConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ArtistEntity;
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
            entity.setPrice(generateRandom(Integer.class));
            em.persist(entity);
            data.add(entity);
        }
        insertArtworksForSearch();
    }

    private void insertArtworksForSearch() {

        ArtistEntity artistEntityOne = new ArtistEntity();
        artistEntityOne.setName("Artista1");
        em.persist(artistEntityOne);

        ArtistEntity artistEntityTwo = new ArtistEntity();
        artistEntityTwo.setName("Artista2");
        em.persist(artistEntityTwo);

        ArtworkEntity entityOne = new ArtworkEntity();
        entityOne.setName("Pintura1");
        entityOne.setPrice(10000);
        entityOne.setArtworkStyle("Realismo");
        entityOne.setRatingSum(8F);
        entityOne.setRatingVotes(2F);
        entityOne.setArtist(artistEntityOne);
        em.persist(entityOne);
        data.add(entityOne);

        ArtworkEntity entityTwo = new ArtworkEntity();
        entityTwo.setName("Pintura2");
        entityTwo.setPrice(20000);
        entityTwo.setArtworkStyle("Impresionismo");
        entityTwo.setRatingSum(10F);
        entityTwo.setRatingVotes(2F);
        entityTwo.setArtist(artistEntityOne);
        em.persist(entityTwo);
        data.add(entityTwo);

        ArtworkEntity entityThree = new ArtworkEntity();
        entityThree.setName("Pintura3");
        entityThree.setPrice(30000);
        entityThree.setArtworkStyle("Realismo");
        entityThree.setRatingSum(9F);
        entityThree.setRatingVotes(2F);
        entityThree.setArtist(artistEntityTwo);
        em.persist(entityThree);
        data.add(entityThree);

        ArtworkEntity entityFour = new ArtworkEntity();
        entityFour.setName("Pintura3");
        entityFour.setPrice(40000);
        entityFour.setArtworkStyle("Impresionismo");
        entityFour.setRatingSum(6F);
        entityFour.setRatingVotes(2F);
        entityFour.setArtist(artistEntityOne);
        em.persist(entityFour);
        data.add(entityFour);
    }

    /**
     * @generated
     */
    @Test
    public void createArtworkTest() {
        ArtworkDTO dto = new ArtworkDTO();
        dto.setName(generateRandom(String.class));
        dto.setPrice(generateRandom(Integer.class));

        ArtworkDTO result = artworkLogic.createArtwork(dto);

        Assert.assertNotNull(result);

        ArtworkEntity entity = em.find(ArtworkEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
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
        dto.setPrice(generateRandom(Integer.class));

        artworkLogic.updateArtwork(dto);

        ArtworkEntity resp = em.find(ArtworkEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
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
        Assert.assertEquals(2, dto2.size());

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

    /**
     * Test for search Artist With Cheapest Artwork
     */
    @Test
    public void searchArtistWithCheapestArtwork() {
        List<ArtworkDTO> artworkEntitys = artworkLogic.searchArtistWithCheapestArtwork("");
        Assert.assertEquals(0, artworkEntitys.size());

        artworkEntitys = artworkLogic.searchArtistWithCheapestArtwork("Pintura3");
        Assert.assertEquals(1, artworkEntitys.size());
        Assert.assertEquals("Pintura3", artworkEntitys.get(0).getName());
        Assert.assertEquals(30000, artworkEntitys.get(0).getPrice(), 0.1D);
        Assert.assertEquals("Artista2", artworkEntitys.get(0).getArtist().getName());

        artworkEntitys = artworkLogic.searchArtistWithCheapestArtwork("Pintura1");
        Assert.assertEquals(1, artworkEntitys.size());
        Assert.assertEquals("Pintura1", artworkEntitys.get(0).getName());
        Assert.assertEquals(10000, artworkEntitys.get(0).getPrice(), 0.1D);
        Assert.assertEquals("Artista1", artworkEntitys.get(0).getArtist().getName());

    }

    /**
     * Test for search Cheapest Artwork Of An Artist
     */
    @Test
    public void searchCheapestArtworkOfAnArtist() {
        List<ArtworkDTO> artworkEntitys = artworkLogic.searchCheapestArtworkOfAnArtist("");
        Assert.assertEquals(0, artworkEntitys.size());

        artworkEntitys = artworkLogic.searchCheapestArtworkOfAnArtist("Artista1");
        Assert.assertEquals(1, artworkEntitys.size());
        Assert.assertEquals("Pintura1", artworkEntitys.get(0).getName());
        Assert.assertEquals(10000, artworkEntitys.get(0).getPrice(), 0.1D);
        Assert.assertEquals("Artista1", artworkEntitys.get(0).getArtist().getName());

        artworkEntitys = artworkLogic.searchCheapestArtworkOfAnArtist("Artista2");
        Assert.assertEquals(1, artworkEntitys.size());
        Assert.assertEquals("Pintura3", artworkEntitys.get(0).getName());
        Assert.assertEquals(30000, artworkEntitys.get(0).getPrice(), 0.1D);
        Assert.assertEquals("Artista2", artworkEntitys.get(0).getArtist().getName());
    }

    /**
     * Test for search Artworks Between Prices
     */
    @Test
    public void searchArtworksBetweenPrices() {
        List<ArtworkDTO> artworkEntitys = artworkLogic.searchArtworksBetweenPrices(0, 1);
        Assert.assertEquals(0, artworkEntitys.size());

        artworkEntitys = artworkLogic.searchArtworksBetweenPrices(0, 10000);
        Assert.assertEquals(1, artworkEntitys.size());
        for (ArtworkDTO a : artworkEntitys) {
            Assert.assertTrue(a.getPrice() >= 0 && a.getPrice() <= 10000);
        }

        artworkEntitys = artworkLogic.searchArtworksBetweenPrices(0, 20000);
        Assert.assertEquals(2, artworkEntitys.size());
        for (ArtworkDTO a : artworkEntitys) {
            Assert.assertTrue(a.getPrice() >= 0 && a.getPrice() <= 20000);
        }

        artworkEntitys = artworkLogic.searchArtworksBetweenPrices(0, 30000);
        Assert.assertEquals(3, artworkEntitys.size());
        for (ArtworkDTO a : artworkEntitys) {
            Assert.assertTrue(a.getPrice() >= 0 && a.getPrice() <= 30000);
        }

        artworkEntitys = artworkLogic.searchArtworksBetweenPrices(0, 40000);
        Assert.assertEquals(4, artworkEntitys.size());
        for (ArtworkDTO a : artworkEntitys) {
            Assert.assertTrue(a.getPrice() >= 0 && a.getPrice() <= 40000);
        }

        artworkEntitys = artworkLogic.searchArtworksBetweenPrices(25000, 35000);
        Assert.assertEquals(1, artworkEntitys.size());
        for (ArtworkDTO a : artworkEntitys) {
            Assert.assertTrue(a.getPrice() >= 25000 && a.getPrice() <= 35000);
        }

        artworkEntitys = artworkLogic.searchArtworksBetweenPrices(50000, 90000);
        Assert.assertEquals(0, artworkEntitys.size());
    }
    /**
     * Test search Artworks Between Ratings
     */
    @Test
    public void searchArtworksBetweenRatings() {
        List<ArtworkDTO> artworkEntitys = artworkLogic.searchArtworksBetweenRatings(0F, 1F);
        Assert.assertEquals(0, artworkEntitys.size());

        artworkEntitys = artworkLogic.searchArtworksBetweenRatings(1F, 3F);
        Assert.assertEquals(1, artworkEntitys.size());

        artworkEntitys = artworkLogic.searchArtworksBetweenRatings(1F, 4F);
        Assert.assertEquals(2, artworkEntitys.size());

        artworkEntitys = artworkLogic.searchArtworksBetweenRatings(1F, 4.5F);
        Assert.assertEquals(3, artworkEntitys.size());
        
        artworkEntitys = artworkLogic.searchArtworksBetweenRatings(1F, 5F);
        Assert.assertEquals(4, artworkEntitys.size());
    }
    
    /**
     * Test for search Artworks By Style
     */
    @Test
    public void searchArtworksByStyle() {
        List<ArtworkDTO> artworkDTOs = artworkLogic.searchArtworksByStyle("");
        Assert.assertEquals(0, artworkDTOs.size());

        artworkDTOs = artworkLogic.searchArtworksByStyle("Nada");
        Assert.assertEquals(0, artworkDTOs.size());

        artworkDTOs = artworkLogic.searchArtworksByStyle("Realismo");
        Assert.assertEquals(2, artworkDTOs.size());
        for (ArtworkDTO a : artworkDTOs) {
            Assert.assertTrue(a.getArtworkStyle().equals("Realismo"));
        }

        artworkDTOs = artworkLogic.searchArtworksByStyle("Impresionismo");
        Assert.assertEquals(2, artworkDTOs.size());
        for (ArtworkDTO a : artworkDTOs) {
            Assert.assertTrue(a.getArtworkStyle().equals("Impresionismo"));
        }
    }

}
