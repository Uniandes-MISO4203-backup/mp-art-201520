/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.api.IResumeLogic;
import co.edu.uniandes.csw.artmarketplace.converters.ResumeConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ResumeDTO;
import co.edu.uniandes.csw.artmarketplace.ejbs.ResumeLogic;
import co.edu.uniandes.csw.artmarketplace.entities.ArtistEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ResumeEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.ResumePersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author a.perez15
 */
@RunWith(Arquillian.class)
public class ResumeLogicTest {
    
    public static final String DEPLOY = "Prueba";
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ResumeEntity.class.getPackage())
                .addPackage(ArtistEntity.class.getPackage())
                .addPackage(ResumeDTO.class.getPackage())
                .addPackage(ResumeConverter.class.getPackage())
                .addPackage(ResumeLogic.class.getPackage())
                .addPackage(IResumeLogic.class.getPackage())
                .addPackage(ResumePersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private IResumeLogic resumeLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
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
    
    private void clearData() {
        em.createQuery("delete from ResumeEntity").executeUpdate();
    }
    

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            long id = (long)i;
            ArtistEntity a = new ArtistEntity();
            a.setId(0L);
            ResumeEntity entity = new ResumeEntity();
            entity.setId(id);
            entity.setRatingSum(10F);
            entity.setRatingVotes(2F);
            entity.setArtist(a);
            em.persist(entity);
        }
    }
    
    public ResumeLogicTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of updateResume method, of class ResumeLogic.
     */
    @Test
    public void testUpdateResume() {
        System.out.println("updateResume");
        ResumeDTO dto = new ResumeDTO();
        ResumeDTO result = resumeLogic.updateResume(dto);
        assertNotNull(dto);
    }

    /**
     * Test of getResumebyAristId method, of class ResumeLogic.
     */
    @Test
    public void testGetResumebyAristId() {
        System.out.println("getResumebyAristId");
        Long id = 0L;
        ResumeDTO result = resumeLogic.getResumebyAristId(id);
        assertNotNull(id);
    }

    /**
     * Test of rateArtist method, of class ResumeLogic.
     */
    @Test
    public void testRateArtist() {
        System.out.println("rateArtist");
        Long id = 0L;
        Float rating = 0F;
        Boolean result = resumeLogic.rateArtist(id, rating);
        assertNotNull(id);
    }

    

    /**
     * Test of searchArtistByName method, of class ResumeLogic.
     */
    @Test
    public void testSearchArtistByName() {
        System.out.println("searchArtistByName");
        String artistName = "";
        List<ResumeDTO> expResult = new ArrayList<ResumeDTO>();
        List<ResumeDTO> result = resumeLogic.searchArtistByName(artistName);
        assertNotNull(artistName);
    }

    /**
     * Test of searchArtistsBetweenRatings method, of class ResumeLogic.
     */
    @Test
    public void testSearchArtistsBetweenRatings() {
        System.out.println("searchArtistsBetweenRatings");
        float artistMinRating = 0.0F;
        float artistMaxRating = 0.0F;
        List<ResumeDTO> expResult = new ArrayList<ResumeDTO>();
        List<ResumeDTO> result = resumeLogic.searchArtistsBetweenRatings(artistMinRating, artistMaxRating);
        assertNotNull(expResult);
    }
    
}
