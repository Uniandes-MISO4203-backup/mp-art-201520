/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.converters.RemarkConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.RemarkDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
import co.edu.uniandes.csw.artmarketplace.entities.RemarkEntity;
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
public class RemarkConverterTest {
    
    public RemarkConverterTest() {
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
     * Test of refEntity2DTO method, of class RemarkConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        RemarkEntity entity = null;
        RemarkDTO result = RemarkConverter.refEntity2DTO(entity);
        assertNull(entity);
        
        entity = new RemarkEntity();
        result = RemarkConverter.refEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class RemarkConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        RemarkDTO dto = null;
        RemarkEntity result = RemarkConverter.refDTO2Entity(dto);
        assertNull(dto);
        
        dto = new RemarkDTO();
        result = RemarkConverter.refDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of fullEntity2DTO method, of class RemarkConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        RemarkEntity entity = null;
        RemarkDTO result = RemarkConverter.fullEntity2DTO(entity);
        assertNull(entity);
        
        entity = new RemarkEntity();
        result = RemarkConverter.fullEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of fullDTO2Entity method, of class RemarkConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        RemarkDTO dto = null;
        RemarkEntity result = RemarkConverter.fullDTO2Entity(dto);
        assertNull(dto);
        
        dto = new RemarkDTO();
        result = RemarkConverter.fullDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of listEntity2DTO method, of class RemarkConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<RemarkEntity> entities = null;
        List<RemarkDTO> result = RemarkConverter.listEntity2DTO(entities);
        assertNull(entities);
        
        entities = new ArrayList<RemarkEntity>();
        entities.add(new RemarkEntity());
        result = RemarkConverter.listEntity2DTO(entities);
        assertNotNull(entities);
    }

    /**
     * Test of listDTO2Entity method, of class RemarkConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<RemarkDTO> dtos = null;
        List<RemarkEntity> result = RemarkConverter.listDTO2Entity(dtos);
        assertNull(dtos);
        
        dtos = new ArrayList<RemarkDTO>();
        dtos.add(new RemarkDTO());
        result = RemarkConverter.listDTO2Entity(dtos);
        assertNotNull(dtos);
    }

    /**
     * Test of childDTO2Entity method, of class RemarkConverter.
     */
    @Test
    public void testChildDTO2Entity() {
        System.out.println("childDTO2Entity");
        RemarkDTO dto = new RemarkDTO();
        ArtworkEntity parent = new ArtworkEntity();
        RemarkEntity result = RemarkConverter.childDTO2Entity(dto, parent);
        assertNotNull(dto);
    }

    /**
     * Test of childListDTO2Entity method, of class RemarkConverter.
     */
    @Test
    public void testChildListDTO2Entity() {
        System.out.println("childListDTO2Entity");
        List<RemarkDTO> dtos = null;
        ArtworkEntity parent = new ArtworkEntity();
        List<RemarkEntity> result = RemarkConverter.childListDTO2Entity(dtos, parent);
        assertNull(dtos);
        
        dtos = new ArrayList<RemarkDTO>();
        dtos.add(new RemarkDTO());
        result = RemarkConverter.childListDTO2Entity(dtos, parent);
        assertNotNull(dtos);
    }
    
}
