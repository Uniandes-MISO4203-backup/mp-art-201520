/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.api.IQuestionLogic;
import co.edu.uniandes.csw.artmarketplace.converters.QuestionConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.QuestionDTO;
import co.edu.uniandes.csw.artmarketplace.ejbs.QuestionLogic;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ClientEntity;
import co.edu.uniandes.csw.artmarketplace.entities.QuestionEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.QuestionPersistence;
import java.util.List;
import java.util.Properties;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;


/**
 *
 * @author a.perez15
 */
@RunWith(Arquillian.class)
public class QuestionLogicTest {
    
    public static final String DEPLOY = "Prueba";
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(QuestionEntity.class.getPackage())
                .addPackage(ClientEntity.class.getPackage())
                .addPackage(ArtworkEntity.class.getPackage())
                .addPackage(QuestionDTO.class.getPackage())
                .addPackage(QuestionConverter.class.getPackage())
                .addPackage(QuestionLogic.class.getPackage())
                .addPackage(IQuestionLogic.class.getPackage())
                .addPackage(QuestionPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private IQuestionLogic questionLogic;
    
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
        em.createQuery("delete from QuestionEntity").executeUpdate();
    }
    

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            long id = (long)i;
            ClientEntity c = new ClientEntity();
            c.setName("");
            ArtworkEntity a = new ArtworkEntity();
            a.setName("");
            QuestionEntity entity = new QuestionEntity();
            entity.setId(id);
            entity.setArtwork(a);
            entity.setClient(c);
            entity.setDate(new Date());
            entity.setQuestion("");
            entity.setArtistEmail("");
            em.persist(entity);
        }
    }

    
    public QuestionLogicTest() {
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
     * Test of countQuestions method, of class QuestionLogic.
     */
    @Test
    public void testCountQuestions() throws Exception {
        System.out.println("countQuestions");
        int expResult = 0;
        int result = questionLogic.countQuestions();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQuestions method, of class QuestionLogic.
     */
    @Test
    public void testGetQuestions() throws Exception {
        System.out.println("getQuestions");
        Integer page = null;
        Integer maxRecords = null;
        List<QuestionDTO> expResult = new ArrayList<QuestionDTO>();
        List<QuestionDTO> result = questionLogic.getQuestions(page, maxRecords);
        assertNotNull(expResult);
    }

    /**
     * Test of getQuestion method, of class QuestionLogic.
     */
    @Test
    public void testGetQuestion() throws Exception {
        System.out.println("getQuestion");
        Long id = 0L;
        QuestionDTO expResult = new QuestionDTO();
        QuestionDTO result = questionLogic.getQuestion(id);
        assertNotNull(id);
    }

    /**
     * Test of createQuestion method, of class QuestionLogic.
     */
    @Test
    public void testCreateQuestion() throws Exception {
        System.out.println("createQuestion");
        QuestionDTO dto = new QuestionDTO();
        QuestionDTO result = questionLogic.createQuestion(dto);
        assertNotNull(dto);
    }

    /**
     * Test of updateQuestion method, of class QuestionLogic.
     */
    @Test
    public void testUpdateQuestion() throws Exception {
        System.out.println("updateQuestion");
        QuestionDTO dto = new QuestionDTO();
        QuestionDTO result = questionLogic.updateQuestion(dto);
        assertNotNull(dto);
    }
    
}
