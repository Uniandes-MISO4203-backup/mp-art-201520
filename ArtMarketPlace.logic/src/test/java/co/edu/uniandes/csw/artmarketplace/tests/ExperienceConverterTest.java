/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.converters.ExperienceConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ExperienceDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ExperienceEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ResumeEntity;
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
public class ExperienceConverterTest {
    
    public ExperienceConverterTest() {
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
     * Test of refEntity2DTO method, of class ExperienceConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        ExperienceEntity entity = null;
        ExperienceDTO expResult = null;
        ExperienceDTO result = ExperienceConverter.refEntity2DTO(entity);
        assertEquals(expResult, result);
        
        entity = new ExperienceEntity();
        result = ExperienceConverter.refEntity2DTO(entity);
        
        assertNotNull(entity);
        
    }

    /**
     * Test of refDTO2Entity method, of class ExperienceConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        ExperienceDTO dto = null;
        ExperienceEntity expResult = null;
        ExperienceEntity result = ExperienceConverter.refDTO2Entity(dto);
        assertEquals(expResult, result);
        
        dto = new ExperienceDTO();
        result = ExperienceConverter.refDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of basicEntity2DTO method, of class ExperienceConverter.
     */
    @Test
    public void testBasicEntity2DTO() {
        System.out.println("basicEntity2DTO");
        ExperienceEntity entity = null;
        ExperienceDTO expResult = null;
        ExperienceDTO result = ExperienceConverter.basicEntity2DTO(entity);
        assertEquals(expResult, result);
        
        entity = new ExperienceEntity();
        result = ExperienceConverter.basicEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of basicDTO2Entity method, of class ExperienceConverter.
     */
    @Test
    public void testBasicDTO2Entity() {
        System.out.println("basicDTO2Entity");
        ExperienceDTO dto = null;
        ExperienceEntity expResult = null;
        ExperienceEntity result = ExperienceConverter.basicDTO2Entity(dto);
        assertEquals(expResult, result);
        
        dto = new ExperienceDTO();
        result = ExperienceConverter.basicDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of fullEntity2DTO method, of class ExperienceConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        ExperienceEntity entity = null;
        ExperienceDTO expResult = null;
        ExperienceDTO result = ExperienceConverter.fullEntity2DTO(entity);
        assertEquals(expResult, result);
        
        entity = new ExperienceEntity();
        result = ExperienceConverter.fullEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of fullDTO2Entity method, of class ExperienceConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        ExperienceDTO dto = null;
        ExperienceEntity expResult = null;
        ExperienceEntity result = ExperienceConverter.fullDTO2Entity(dto);
        assertEquals(expResult, result);
        
        dto = new ExperienceDTO();
        result = ExperienceConverter.fullDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of listDTO2Entity method, of class ExperienceConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<ExperienceDTO> dtos = null;
        List<ExperienceEntity> expResult = new ArrayList<ExperienceEntity>();
        List<ExperienceEntity> result = ExperienceConverter.listDTO2Entity(dtos);
        assertEquals(expResult.size(), result.size());
        
        dtos = new ArrayList<ExperienceDTO>();
        dtos.add(new ExperienceDTO());
        result = ExperienceConverter.listDTO2Entity(dtos);
        assertNotNull(dtos);
    }

    /**
     * Test of listEntity2DTO method, of class ExperienceConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<ExperienceEntity> entities = null;
        List<ExperienceDTO> expResult = new ArrayList<ExperienceDTO>();
        List<ExperienceDTO> result = ExperienceConverter.listEntity2DTO(entities);
        assertEquals(expResult.size(), result.size());
        
        entities = new ArrayList<ExperienceEntity>();
        entities.add(new ExperienceEntity());
        result = ExperienceConverter.listEntity2DTO(entities);
        assertNotNull(entities);
    }

    /**
     * Test of childDTO2Entity method, of class ExperienceConverter.
     */
    @Test
    public void testChildDTO2Entity() {
        System.out.println("childDTO2Entity");
        ExperienceDTO dto = new ExperienceDTO();
        ResumeEntity parent = null;
        ExperienceEntity expResult = null;
        ExperienceEntity result = ExperienceConverter.childDTO2Entity(dto, parent);
        
        assertNotNull(dto);
        
        dto = new ExperienceDTO();
        result = ExperienceConverter.childDTO2Entity(dto, parent);
        
    }

    /**
     * Test of childListDTO2Entity method, of class ExperienceConverter.
     */
    @Test
    public void testChildListDTO2Entity() {
        System.out.println("childListDTO2Entity");
        List<ExperienceDTO> dtos = null;
        ResumeEntity parent = null;
        List<ExperienceEntity> expResult = new ArrayList<ExperienceEntity>();
        List<ExperienceEntity> result = ExperienceConverter.childListDTO2Entity(dtos, parent);
        assertEquals(expResult.size(), result.size());
        
        dtos = new ArrayList<ExperienceDTO>();
        dtos.add(new ExperienceDTO());
        result = ExperienceConverter.childListDTO2Entity(dtos, parent);
        assertNotNull(dtos);
    }
    
}
