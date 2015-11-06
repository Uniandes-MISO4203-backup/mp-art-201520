/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.converters.ResumeConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ResumeDTO;
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
public class ResumeConverterTest {
    
    public ResumeConverterTest() {
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
     * Test of refEntity2DTO method, of class ResumeConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        ResumeEntity entity = null;
        ResumeDTO result = ResumeConverter.refEntity2DTO(entity);
        assertNull(entity);
        
        entity = new ResumeEntity();
        result = ResumeConverter.refEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class ResumeConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        ResumeDTO dto = null;
        ResumeEntity result = ResumeConverter.refDTO2Entity(dto);
        assertNull(dto);
        
        dto = new ResumeDTO();
        result = ResumeConverter.refDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of basicEntity2DTO method, of class ResumeConverter.
     */
    @Test
    public void testBasicEntity2DTO() {
        System.out.println("basicEntity2DTO");
        ResumeEntity entity = null;
        ResumeDTO result = ResumeConverter.basicEntity2DTO(entity);
        assertNull(entity);
        
        entity = new ResumeEntity();
        result = ResumeConverter.basicEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of basicDTO2Entity method, of class ResumeConverter.
     */
    @Test
    public void testBasicDTO2Entity() {
        System.out.println("basicDTO2Entity");
        ResumeDTO dto = null;
        ResumeEntity result = ResumeConverter.basicDTO2Entity(dto);
        assertNull(dto);
        
        dto = new ResumeDTO();
        result = ResumeConverter.basicDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of fullEntity2DTO method, of class ResumeConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        ResumeEntity entity = null;
        ResumeDTO result = ResumeConverter.fullEntity2DTO(entity);
        assertNull(entity);
        
        entity = new ResumeEntity();
        result = ResumeConverter.fullEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of fullDTO2Entity method, of class ResumeConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        ResumeDTO dto = null;
        ResumeEntity result = ResumeConverter.fullDTO2Entity(dto);
        assertNull(dto);
        
        dto = new ResumeDTO();
        result = ResumeConverter.fullDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of listDTO2Entity method, of class ResumeConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<ResumeDTO> dtos = null;
        List<ResumeEntity> result = ResumeConverter.listDTO2Entity(dtos);
        assertNull(dtos);
        
        dtos = new ArrayList<ResumeDTO>();
        result = ResumeConverter.listDTO2Entity(dtos);
        assertNotNull(dtos);
    }

    /**
     * Test of listEntity2DTO method, of class ResumeConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<ResumeEntity> entities = null;
        List<ResumeDTO> result = ResumeConverter.listEntity2DTO(entities);
        assertNull(entities);
        
        entities = new ArrayList<ResumeEntity>();
        result = ResumeConverter.listEntity2DTO(entities);
        assertNotNull(entities);
    }
    
}
