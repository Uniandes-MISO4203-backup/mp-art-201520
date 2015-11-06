/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.converters.AdminConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.AdminDTO;
import co.edu.uniandes.csw.artmarketplace.entities.AdminEntity;
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
public class AdminConverterTest {
    
    public AdminConverterTest() {
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
     * Test of refEntity2DTO method, of class AdminConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        AdminEntity entity = null;
        AdminDTO result = AdminConverter.refEntity2DTO(entity);
        assertNull(entity);
        
        entity = new AdminEntity();
        result = AdminConverter.refEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class AdminConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        AdminDTO dto = null;
        AdminEntity result = AdminConverter.refDTO2Entity(dto);
        assertNull(dto);
        
        dto = new AdminDTO();
        result = AdminConverter.refDTO2Entity(dto);
        assertNotNull(dto);
    }
    
}
