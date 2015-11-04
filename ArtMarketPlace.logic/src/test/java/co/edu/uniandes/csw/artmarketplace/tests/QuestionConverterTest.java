/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.converters.QuestionConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.QuestionDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
import co.edu.uniandes.csw.artmarketplace.entities.QuestionEntity;
import java.util.ArrayList;
import java.util.List;
import org.jboss.arquillian.junit.Arquillian;
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
public class QuestionConverterTest {
    
    public QuestionConverterTest() {
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
     * Test of refEntity2DTO method, of class QuestionConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        QuestionEntity entity = null;
        QuestionDTO expResult = null;
        
        QuestionDTO result = QuestionConverter.refEntity2DTO(entity);
        assertNull(entity);
        
        entity = new QuestionEntity();
        result = QuestionConverter.refEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class QuestionConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        QuestionDTO dto = null;
        QuestionEntity result = QuestionConverter.refDTO2Entity(dto);
        assertNull(dto);
        
        dto = new QuestionDTO() ;
        result = QuestionConverter.refDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of basicDTO2Entity method, of class QuestionConverter.
     */
    @Test
    public void testBasicDTO2Entity() {
        System.out.println("basicDTO2Entity");
        QuestionDTO dto = null;
        QuestionEntity result = QuestionConverter.basicDTO2Entity(dto);
        assertNull(dto);
        
        dto = new QuestionDTO();
        result = QuestionConverter.basicDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of basicEntity2DTO method, of class QuestionConverter.
     */
    @Test
    public void testBasicEntity2DTO() {
        System.out.println("basicEntity2DTO");
        QuestionEntity entity = null;
        QuestionDTO result = QuestionConverter.basicEntity2DTO(entity);
        assertNull(entity);
        
        entity = new QuestionEntity();
        result = QuestionConverter.basicEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of fullDTO2Entity method, of class QuestionConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        QuestionDTO dto = null;
        QuestionEntity result = QuestionConverter.fullDTO2Entity(dto);
        assertNull(dto);
        
        dto = new QuestionDTO();
        result = QuestionConverter.fullDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of fullEntity2DTO method, of class QuestionConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        QuestionEntity entity = null;
        QuestionDTO result = QuestionConverter.fullEntity2DTO(entity);
        assertNull(entity);
        
        entity = new QuestionEntity();
        result = QuestionConverter.fullEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of listEntity2DTO method, of class QuestionConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<QuestionEntity> entities = null;
        List<QuestionDTO> result = QuestionConverter.listEntity2DTO(entities);
        assertNull(entities);
        
        entities = new ArrayList<QuestionEntity>();
        result = QuestionConverter.listEntity2DTO(entities);
        assertNotNull(entities);
    }

    /**
     * Test of listDTO2Entity method, of class QuestionConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<QuestionDTO> dtos = null;
        List<QuestionEntity> result = QuestionConverter.listDTO2Entity(dtos);
        assertNull(dtos);
        
        dtos = new ArrayList<QuestionDTO>();
        result = QuestionConverter.listDTO2Entity(dtos);
        assertNotNull(dtos);
    }

    /**
     * Test of childDTO2Entity method, of class QuestionConverter.
     */
    @Test
    public void testChildDTO2Entity() {
        System.out.println("childDTO2Entity");
        QuestionDTO question = new QuestionDTO();
        ArtworkEntity artwork = new ArtworkEntity();
        QuestionEntity expResult = null;
        QuestionEntity result = QuestionConverter.childDTO2Entity(question, artwork);
        assertNotNull(question);
    }

    /**
     * Test of childListDTO2Entity method, of class QuestionConverter.
     */
    @Test
    public void testChildListDTO2Entity() {
        System.out.println("childListDTO2Entity");
        List<QuestionDTO> questions = null;
        ArtworkEntity artwork = new ArtworkEntity();
        List<QuestionEntity> result = QuestionConverter.childListDTO2Entity(questions, artwork);
        assertNull(questions);
        
        questions = new ArrayList<QuestionDTO>();
        result = QuestionConverter.childListDTO2Entity(questions, artwork);
        assertNotNull(questions);
    }
    
}
