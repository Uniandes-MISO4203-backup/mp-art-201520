/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.converters.BlogConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.BlogDTO;
import co.edu.uniandes.csw.artmarketplace.entities.BlogEntity;
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
public class BlogConverterTest {
    
    public BlogConverterTest() {
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
     * Test of refEntity2DTO method, of class BlogConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        BlogEntity entity = null;
        BlogDTO result = BlogConverter.refEntity2DTO(entity);
        assertNull(entity);
        
        entity = new BlogEntity();
        result = BlogConverter.refEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class BlogConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        BlogDTO dto = null;
        BlogEntity result = BlogConverter.refDTO2Entity(dto);
        assertNull(dto);
        
        dto = new BlogDTO();
        result = BlogConverter.refDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of fullEntity2DTO method, of class BlogConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        BlogEntity entity = null;
        BlogDTO result = BlogConverter.fullEntity2DTO(entity);
        assertNull(entity);
        
        entity = new BlogEntity();
        result = BlogConverter.fullEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of fullDTO2Entity method, of class BlogConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        BlogDTO dto = null;
        BlogEntity result = BlogConverter.fullDTO2Entity(dto);
        assertNull(dto);
        
        dto = new BlogDTO();
        result = BlogConverter.fullDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of listEntity2DTO method, of class BlogConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<BlogEntity> entities = null;
        List<BlogDTO> result = BlogConverter.listEntity2DTO(entities);
        assertNull(entities);
        
        entities = new ArrayList<BlogEntity>();
        result = BlogConverter.listEntity2DTO(entities);
        assertNotNull(entities);
    }

    /**
     * Test of listDTO2Entity method, of class BlogConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<BlogDTO> dtos = null;
        List<BlogEntity> result = BlogConverter.listDTO2Entity(dtos);
        assertNull(dtos);
        
        dtos = new ArrayList<BlogDTO>();
        result = BlogConverter.listDTO2Entity(dtos);
        assertNotNull(dtos);
    }
    
}
