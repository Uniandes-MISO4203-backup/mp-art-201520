/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.dtos.UserDTO;
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
public class UserDTOTest {
    
    public UserDTOTest() {
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
     * Test of getName method, of class UserDTO.
     */
    @Test
    public void testGetName() {
        UserDTO instance = new UserDTO();
        instance.setName("name");
        instance.setLastName("lastname");
        instance.setEmail("email");
        instance.setPassword("pass");
        instance.setRememberMe(true);
        instance.setRole("role");
        instance.setUserName("username");
        
        assertEquals("name",instance.getName());
        assertEquals("lastname",instance.getLastName());
        assertEquals("email",instance.getEmail());
        assertEquals("pass",instance.getPassword());
        assertTrue(instance.isRememberMe());
        assertEquals("role",instance.getRole());
        assertEquals("username",instance.getUserName());
    }

}
