/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.RemarkDTO;
import java.util.Calendar;
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
public class RemarkDTOTest {
    
    public RemarkDTOTest() {
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
     * Test of getUserType method, of class RemarkDTO.
     */
    @Test
    public void testGetUserType() {
        System.out.println("getUserType");
        RemarkDTO instance = new RemarkDTO();
        String expResult = null;
        String result = instance.getUserType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserType method, of class RemarkDTO.
     */
    @Test
    public void testSetUserType() {
        System.out.println("setUserType");
        String userType = "";
        RemarkDTO instance = new RemarkDTO();
        instance.setUserType(userType);
        
        assertNotNull(userType);
    }

    /**
     * Test of getRemarkUser method, of class RemarkDTO.
     */
    @Test
    public void testGetRemarkUser() {
        System.out.println("getRemarkUser");
        RemarkDTO instance = new RemarkDTO();
        String expResult = null;
        String result = instance.getRemarkUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRemarkUser method, of class RemarkDTO.
     */
    @Test
    public void testSetRemarkUser() {
        System.out.println("setRemarkUser");
        String remarkUser = "";
        RemarkDTO instance = new RemarkDTO();
        instance.setRemarkUser(remarkUser);
        
        assertNotNull(remarkUser);
    }

    /**
     * Test of getRemarkDate method, of class RemarkDTO.
     */
    @Test
    public void testGetRemarkDate() {
        System.out.println("getRemarkDate");
        RemarkDTO instance = new RemarkDTO();
        Calendar expResult = null;
        Calendar result = instance.getRemarkDate();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setRemarkDate method, of class RemarkDTO.
     */
    @Test
    public void testSetRemarkDate() {
        System.out.println("setRemarkDate");
        Calendar remarkDate = null;
        RemarkDTO instance = new RemarkDTO();
        instance.setRemarkDate(remarkDate);
        
        assertNull(remarkDate);
    }

    /**
     * Test of getDescription method, of class RemarkDTO.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        RemarkDTO instance = new RemarkDTO();
        String expResult = null;
        String result = instance.getDescription();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDescription method, of class RemarkDTO.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = null;
        RemarkDTO instance = new RemarkDTO();
        instance.setDescription(description);
        
        assertNull(description);
    }

    /**
     * Test of getArtwork method, of class RemarkDTO.
     */
    @Test
    public void testGetArtwork() {
        System.out.println("getArtwork");
        RemarkDTO instance = new RemarkDTO();
        ArtworkDTO expResult = null;
        ArtworkDTO result = instance.getArtwork();
        assertEquals(expResult, result);
    }

    /**
     * Test of setArtwork method, of class RemarkDTO.
     */
    @Test
    public void testSetArtwork() {
        System.out.println("setArtwork");
        ArtworkDTO artwork = null;
        RemarkDTO instance = new RemarkDTO();
        instance.setArtwork(artwork);
        
        assertNull(artwork);
    }
    
}
