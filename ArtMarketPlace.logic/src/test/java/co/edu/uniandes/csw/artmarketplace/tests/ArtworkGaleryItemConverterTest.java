/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.converters.ArtworkGaleryItemConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkGaleryItemDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkGaleryItemEntity;
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
public class ArtworkGaleryItemConverterTest {
    
    public ArtworkGaleryItemConverterTest() {
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
     * Test of refEntity2DTO method, of class ArtworkGaleryItemConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        ArtworkGaleryItemEntity entity = null;
        ArtworkGaleryItemDTO result = ArtworkGaleryItemConverter.refEntity2DTO(entity);
        assertNull(entity);
        
        entity = new ArtworkGaleryItemEntity();
        result = ArtworkGaleryItemConverter.refEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class ArtworkGaleryItemConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        ArtworkGaleryItemDTO dto = null;
        ArtworkGaleryItemEntity result = ArtworkGaleryItemConverter.refDTO2Entity(dto);
        assertNull(dto);
        
        dto = new ArtworkGaleryItemDTO();
        result = ArtworkGaleryItemConverter.refDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of basicEntity2DTO method, of class ArtworkGaleryItemConverter.
     */
    @Test
    public void testBasicEntity2DTO() {
        System.out.println("basicEntity2DTO");
        ArtworkGaleryItemEntity entity = null;
        ArtworkGaleryItemDTO result = ArtworkGaleryItemConverter.basicEntity2DTO(entity);
        assertNull(entity);
        
        entity = new ArtworkGaleryItemEntity();
        result = ArtworkGaleryItemConverter.basicEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of basicDTO2Entity method, of class ArtworkGaleryItemConverter.
     */
    @Test
    public void testBasicDTO2Entity() {
        System.out.println("basicDTO2Entity");
        ArtworkGaleryItemDTO dto = null;
        ArtworkGaleryItemEntity result = ArtworkGaleryItemConverter.basicDTO2Entity(dto);
        assertNull(dto);
        
        dto = new ArtworkGaleryItemDTO();
        result = ArtworkGaleryItemConverter.basicDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of fullEntity2DTO method, of class ArtworkGaleryItemConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        ArtworkGaleryItemEntity entity = null;
        ArtworkGaleryItemDTO result = ArtworkGaleryItemConverter.fullEntity2DTO(entity);
        assertNull(entity);
        
        entity = new ArtworkGaleryItemEntity();
        result = ArtworkGaleryItemConverter.fullEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of fullDTO2Entity method, of class ArtworkGaleryItemConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        ArtworkGaleryItemDTO dto = null;
        ArtworkGaleryItemEntity result = ArtworkGaleryItemConverter.fullDTO2Entity(dto);
        assertNull(dto);
        
        dto = new ArtworkGaleryItemDTO();
        result = ArtworkGaleryItemConverter.fullDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of listEntity2DTO method, of class ArtworkGaleryItemConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<ArtworkGaleryItemEntity> entities = null;
        List<ArtworkGaleryItemDTO> result = ArtworkGaleryItemConverter.listEntity2DTO(entities);
        assertNull(entities);
        
        entities = new ArrayList<ArtworkGaleryItemEntity>();
        entities.add(new ArtworkGaleryItemEntity());
        result = ArtworkGaleryItemConverter.listEntity2DTO(entities);
        assertNotNull(entities);
    }

    /**
     * Test of listDTO2Entity method, of class ArtworkGaleryItemConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<ArtworkGaleryItemDTO> dtos = null;
        List<ArtworkGaleryItemEntity> result = ArtworkGaleryItemConverter.listDTO2Entity(dtos);
        assertNull(dtos);
        
        dtos = new ArrayList<ArtworkGaleryItemDTO>();
        dtos.add(new ArtworkGaleryItemDTO());
        result = ArtworkGaleryItemConverter.listDTO2Entity(dtos);
        assertNotNull(dtos);
    }

    /**
     * Test of childDTO2Entity method, of class ArtworkGaleryItemConverter.
     */
    @Test
    public void testChildDTO2Entity() {
        System.out.println("childDTO2Entity");
        
        ArtworkEntity parent = new ArtworkEntity();
        ArtworkGaleryItemDTO dto = new ArtworkGaleryItemDTO();
        ArtworkGaleryItemEntity result = ArtworkGaleryItemConverter.childDTO2Entity(dto, parent);
        assertNotNull(dto);
        
    }

    /**
     * Test of childListDTO2Entity method, of class ArtworkGaleryItemConverter.
     */
    @Test
    public void testChildListDTO2Entity() {
        System.out.println("childListDTO2Entity");
        ArtworkEntity parent = new ArtworkEntity();
        List<ArtworkGaleryItemDTO> dtos = null;
        List<ArtworkGaleryItemEntity> result = ArtworkGaleryItemConverter.childListDTO2Entity(dtos, parent);
        assertNull(dtos);
        
        dtos = new ArrayList<ArtworkGaleryItemDTO>();
        dtos.add(new ArtworkGaleryItemDTO());
        result = ArtworkGaleryItemConverter.childListDTO2Entity(dtos, parent);
        assertNotNull(dtos);
    }
    
}
