/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.converters.ArtistConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtistDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ArtistEntity;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author a.perez15
 */
public class ArtistConverterTest {
    
    public ArtistConverterTest() {
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
     * Test of refEntity2DTO method, of class ArtistConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        ArtistEntity entity = null;
        ArtistDTO result = ArtistConverter.refEntity2DTO(entity);
        assertNull(entity);
        
        entity = new ArtistEntity();
        result = ArtistConverter.refEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class ArtistConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        ArtistDTO dto = null;
        ArtistEntity result = ArtistConverter.refDTO2Entity(dto);
        assertNull(dto);
        
        dto = new ArtistDTO();
        result = ArtistConverter.refDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of fullEntity2DTO method, of class ArtistConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        ArtistEntity entity = null;
        ArtistDTO result = ArtistConverter.fullEntity2DTO(entity);
        assertNull(entity);
        
        entity = new ArtistEntity();
        result = ArtistConverter.fullEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of fullDTO2Entity method, of class ArtistConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        ArtistDTO dto = null;
        ArtistEntity result = ArtistConverter.fullDTO2Entity(dto);
        assertNull(dto);
        
        dto = new ArtistDTO();
        result = ArtistConverter.fullDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of listEntity2DTO method, of class ArtistConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<ArtistEntity> entities = null;
        List<ArtistDTO> result = ArtistConverter.listEntity2DTO(entities);
        assertNull(entities);
        
        entities = new ArrayList<ArtistEntity>();
        result = ArtistConverter.listEntity2DTO(entities);
        assertNotNull(entities);
    }

    /**
     * Test of listDTO2Entity method, of class ArtistConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<ArtistDTO> dtos = null;
        List<ArtistEntity> result = ArtistConverter.listDTO2Entity(dtos);
        assertNull(dtos);
        
        dtos = new ArrayList<ArtistDTO>();
        result = ArtistConverter.listDTO2Entity(dtos);
        assertNotNull(dtos);
    }
    
}
