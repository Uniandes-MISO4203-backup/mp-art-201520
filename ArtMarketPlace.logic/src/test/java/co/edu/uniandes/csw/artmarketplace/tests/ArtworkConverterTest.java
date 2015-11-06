/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.converters.ArtworkConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ArtistEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
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
public class ArtworkConverterTest {
    
    public ArtworkConverterTest() {
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
     * Test of refEntity2DTO method, of class ArtworkConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        ArtworkEntity entity = null;
        ArtworkDTO result = ArtworkConverter.refEntity2DTO(entity);
        assertNull(entity);
        
        entity = new ArtworkEntity();
        result = ArtworkConverter.refEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class ArtworkConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        ArtworkDTO dto = null;
        ArtworkEntity result = ArtworkConverter.refDTO2Entity(dto);
        assertNull(dto);
        
        dto = new ArtworkDTO();
        result = ArtworkConverter.refDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of basicEntity2DTO method, of class ArtworkConverter.
     */
    @Test
    public void testBasicEntity2DTO() {
        System.out.println("basicEntity2DTO");
        ArtworkEntity entity = null;
        ArtworkDTO result = ArtworkConverter.basicEntity2DTO(entity);
        assertNull(entity);
        
        entity = new ArtworkEntity();
        result = ArtworkConverter.basicEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of basicDTO2Entity method, of class ArtworkConverter.
     */
    @Test
    public void testBasicDTO2Entity() {
        System.out.println("basicDTO2Entity");
        ArtworkDTO dto = null;
        ArtworkEntity result = ArtworkConverter.basicDTO2Entity(dto);
        assertNull(dto);
        
        dto = new ArtworkDTO();
        result = ArtworkConverter.basicDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of fullEntity2DTO method, of class ArtworkConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        ArtworkEntity entity = null;
        ArtworkDTO result = ArtworkConverter.fullEntity2DTO(entity);
        assertNull(entity);
        
        entity = new ArtworkEntity();
        result = ArtworkConverter.fullEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of fullDTO2Entity method, of class ArtworkConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        ArtworkDTO dto = null;
        ArtworkEntity result = ArtworkConverter.fullDTO2Entity(dto);
        assertNull(dto);
        
        dto = new ArtworkDTO();
        result = ArtworkConverter.fullDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of listEntity2DTO method, of class ArtworkConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<ArtworkEntity> entities = null;
        List<ArtworkDTO> result = ArtworkConverter.listEntity2DTO(entities);
        assertNull(entities);
        
        entities = new ArrayList<ArtworkEntity>();
        entities.add(new ArtworkEntity());
        result = ArtworkConverter.listEntity2DTO(entities);
        assertNotNull(entities);
    }

    /**
     * Test of listDTO2Entity method, of class ArtworkConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<ArtworkDTO> dtos = null;
        List<ArtworkEntity> result = ArtworkConverter.listDTO2Entity(dtos);
        assertNull(dtos);
        
        dtos = new ArrayList<ArtworkDTO>();
        dtos.add(new ArtworkDTO());
        result = ArtworkConverter.listDTO2Entity(dtos);
        assertNotNull(dtos);
    }

    /**
     * Test of childDTO2Entity method, of class ArtworkConverter.
     */
    @Test
    public void testChildDTO2Entity() {
        System.out.println("childDTO2Entity");
        ArtistEntity parent = new ArtistEntity();
        ArtworkDTO dto = new ArtworkDTO();
        ArtworkEntity result = ArtworkConverter.childDTO2Entity(dto, parent);
        assertNotNull(dto);
    }

    /**
     * Test of childListDTO2Entity method, of class ArtworkConverter.
     */
    @Test
    public void testChildListDTO2Entity() {
        System.out.println("childListDTO2Entity");
        ArtistEntity parent = new ArtistEntity();
        List<ArtworkDTO> dtos = null;
        List<ArtworkEntity> result = ArtworkConverter.childListDTO2Entity(dtos, parent);
        assertNull(dtos);
        
        dtos = new ArrayList<ArtworkDTO>();
        dtos.add(new ArtworkDTO());
        result = ArtworkConverter.childListDTO2Entity(dtos, parent);
        assertNotNull(dtos);
    }
    
}
