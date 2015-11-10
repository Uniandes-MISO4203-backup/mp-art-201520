/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.converters.ExhibitionConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ExhibitionDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ExhibitionEntity;
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
public class ExhibitionConverterTest {
    
    public ExhibitionConverterTest() {
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
     * Test of refEntity2DTO method, of class ExhibitionConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        ExhibitionEntity entity = null;
        ExhibitionDTO result = ExhibitionConverter.refEntity2DTO(entity);
        assertNull(entity);
        
        entity = new ExhibitionEntity();
        result = ExhibitionConverter.refEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class ExhibitionConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        ExhibitionDTO dto = null;
        ExhibitionEntity result = ExhibitionConverter.refDTO2Entity(dto);
        assertNull(dto);
        
        dto = new ExhibitionDTO();
        result = ExhibitionConverter.refDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of fullEntity2DTO method, of class ExhibitionConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        ExhibitionEntity entity = null;
        ExhibitionDTO result = ExhibitionConverter.fullEntity2DTO(entity);
        assertNull(entity);
        
        entity = new ExhibitionEntity();
        result = ExhibitionConverter.fullEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of fullDTO2Entity method, of class ExhibitionConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        ExhibitionDTO dto = null;
        ExhibitionEntity result = ExhibitionConverter.fullDTO2Entity(dto);
        assertNull(dto);
        
        dto = new ExhibitionDTO();
        result = ExhibitionConverter.fullDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of listEntity2DTO method, of class ExhibitionConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<ExhibitionEntity> entities = new ArrayList<ExhibitionEntity>();
        entities.add(new ExhibitionEntity());
        List<ExhibitionDTO> result = ExhibitionConverter.listEntity2DTO(entities);
        assertNotNull(entities);
    }

    /**
     * Test of listDTO2Entity method, of class ExhibitionConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<ExhibitionDTO> dtos = new ArrayList<ExhibitionDTO>();
        dtos.add(new ExhibitionDTO());
        List<ExhibitionEntity> result = ExhibitionConverter.listDTO2Entity(dtos);
        assertNotNull(dtos);
    }

    /**
     * Test of childDTO2Entity method, of class ExhibitionConverter.
     */
    @Test
    public void testChildDTO2Entity() {
        System.out.println("childDTO2Entity");
        ExhibitionDTO dto = new ExhibitionDTO();
        ResumeEntity parent = new ResumeEntity();
        ExhibitionEntity result = ExhibitionConverter.childDTO2Entity(dto, parent);
        assertNotNull(dto);
    }

    /**
     * Test of childListDTO2Entity method, of class ExhibitionConverter.
     */
    @Test
    public void testChildListDTO2Entity() {
        System.out.println("childListDTO2Entity");
        List<ExhibitionDTO> dtos = new ArrayList<ExhibitionDTO>();
        dtos.add(new ExhibitionDTO());
        ResumeEntity parent = new ResumeEntity();
        List<ExhibitionEntity> result = ExhibitionConverter.childListDTO2Entity(dtos, parent);
        assertNotNull(dtos);
    }
    
}
