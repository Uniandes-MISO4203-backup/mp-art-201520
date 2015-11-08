/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.converters.CommentBlogConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.CommentBlogDTO;
import co.edu.uniandes.csw.artmarketplace.entities.CommentBlogEntity;
import java.util.ArrayList;
import java.util.List;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author jh.rubiano10
 */
@RunWith(Arquillian.class)
public class CommentBlogConverterTest {
    
    public CommentBlogConverterTest() {
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
     * Test of refEntity2DTO method, of class CommentBlogConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        CommentBlogEntity entity = null;
        CommentBlogDTO result = CommentBlogConverter.refEntity2DTO(entity);
        assertNull(entity);
        
        entity = new CommentBlogEntity();
        result = CommentBlogConverter.refEntity2DTO(entity);
        assertNotNull(entity);
        
        //result.setDateEntry(Calendar.getInstance());
    }

    /**
     * Test of refDTO2Entity method, of class CommentBlogConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        CommentBlogDTO dto = null;
        CommentBlogEntity result = CommentBlogConverter.refDTO2Entity(dto);
        assertNull(dto);
        
        dto = new CommentBlogDTO();
        result = CommentBlogConverter.refDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of fullEntity2DTO method, of class CommentBlogConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        CommentBlogEntity entity = null;
        CommentBlogDTO result = CommentBlogConverter.fullEntity2DTO(entity);
        assertNull(entity);
        
        entity = new CommentBlogEntity();
        result = CommentBlogConverter.fullEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of fullDTO2Entity method, of class CommentBlogConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        CommentBlogDTO dto = null;
        CommentBlogEntity result = CommentBlogConverter.fullDTO2Entity(dto);
        assertNull(dto);
        
        dto = new CommentBlogDTO();
        result = CommentBlogConverter.fullDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of listEntity2DTO method, of class CommentBlogConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<CommentBlogEntity> entities = null;
        List<CommentBlogDTO> result = CommentBlogConverter.listEntity2DTO(entities);
        assertNull(entities);
        
        entities = new ArrayList<CommentBlogEntity>();
        entities.add(new CommentBlogEntity());
        result = CommentBlogConverter.listEntity2DTO(entities);
        assertNotNull(entities);
    }

    /**
     * Test of listDTO2Entity method, of class CommentBlogConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<CommentBlogDTO> dtos = null;
        List<CommentBlogEntity> result = CommentBlogConverter.listDTO2Entity(dtos);
        assertNull(dtos);
        
        dtos = new ArrayList<CommentBlogDTO>();
        dtos.add(new CommentBlogDTO());
        result = CommentBlogConverter.listDTO2Entity(dtos);
        assertNotNull(dtos);
    }
}
