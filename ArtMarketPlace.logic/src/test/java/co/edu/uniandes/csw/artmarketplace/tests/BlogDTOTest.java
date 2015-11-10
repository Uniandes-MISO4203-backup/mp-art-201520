/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.dtos.BlogDTO;
import java.util.Calendar;
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
public class BlogDTOTest {
    
    public BlogDTOTest() {
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
     * Test of getTitle method, of class BlogDTO.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        BlogDTO instance = new BlogDTO();
        String expResult = null;
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitle method, of class BlogDTO.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        BlogDTO instance = new BlogDTO();
        instance.setTitle(title);
    }

    /**
     * Test of getEntry method, of class BlogDTO.
     */
    @Test
    public void testGetEntry() {
        System.out.println("getEntry");
        BlogDTO instance = new BlogDTO();
        String expResult = null;
        String result = instance.getEntry();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEntry method, of class BlogDTO.
     */
    @Test
    public void testSetEntry() {
        System.out.println("setEntry");
        String entry = "";
        BlogDTO instance = new BlogDTO();
        instance.setEntry(entry);
    }

    /**
     * Test of getClientId method, of class BlogDTO.
     */
    @Test
    public void testGetClientId() {
        System.out.println("getClientId");
        BlogDTO instance = new BlogDTO();
        Long expResult = null;
        Long result = instance.getClientId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setClientId method, of class BlogDTO.
     */
    @Test
    public void testSetClientId() {
        System.out.println("setClientId");
        Long clientId = null;
        BlogDTO instance = new BlogDTO();
        instance.setClientId(clientId);
    }

    /**
     * Test of getDateEntry method, of class BlogDTO.
     */
    @Test
    public void testGetDateEntry() {
        System.out.println("getDateEntry");
        BlogDTO instance = new BlogDTO();
        Calendar expResult = null;
        Calendar result = instance.getDateEntry();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDateEntry method, of class BlogDTO.
     */
    @Test
    public void testSetDateEntry() {
        System.out.println("setDateEntry");
        Calendar dateEntry = null;
        BlogDTO instance = new BlogDTO();
        instance.setDateEntry(dateEntry);
    }
    
}
