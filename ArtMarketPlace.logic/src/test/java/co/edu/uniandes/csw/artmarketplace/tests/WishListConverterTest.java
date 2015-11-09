/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.converters.WishListConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.WishListDTO;
import co.edu.uniandes.csw.artmarketplace.entities.WishListEntity;
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
public class WishListConverterTest {
    
    public WishListConverterTest() {
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
     * Test of refEntity2DTO method, of class WishListConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        WishListEntity entity = null;
        WishListDTO result = WishListConverter.refEntity2DTO(entity);
        assertNull(entity);
        
        entity = new WishListEntity();
        result = WishListConverter.refEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class WishListConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        WishListDTO dto = null;
        WishListEntity result = WishListConverter.refDTO2Entity(dto);
        assertNull(dto);
        
        dto = new WishListDTO();
        result = WishListConverter.refDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of basicEntity2DTO method, of class WishListConverter.
     */
    @Test
    public void testBasicEntity2DTO() {
        System.out.println("basicEntity2DTO");
        WishListEntity entity = null;
        WishListDTO result = WishListConverter.basicEntity2DTO(entity);
        assertNull(entity);
        
        entity = new WishListEntity();
        result = WishListConverter.basicEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of basicDTO2Entity method, of class WishListConverter.
     */
    @Test
    public void testBasicDTO2Entity() {
        System.out.println("basicDTO2Entity");
        WishListDTO dto = null;
        WishListEntity result = WishListConverter.basicDTO2Entity(dto);
        assertNull(dto);
        
        dto = new WishListDTO();
        result = WishListConverter.basicDTO2Entity(dto);
        assertNotNull(dto);
    }
    
}
