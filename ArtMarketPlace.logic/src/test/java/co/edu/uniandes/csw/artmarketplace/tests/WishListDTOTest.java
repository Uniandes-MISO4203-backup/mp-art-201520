/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ClientDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.WishListDTO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ms.lancheros10
 */
public class WishListDTOTest {
    
    public WishListDTOTest() {
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
     * Test of getId method, of class WishListDTO.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        WishListDTO instance = new WishListDTO();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class WishListDTO.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        WishListDTO instance = new WishListDTO();
        instance.setId(id);
    }

    /**
     * Test of getArtwork method, of class WishListDTO.
     */
    @Test
    public void testGetArtwork() {
        System.out.println("getArtwork");
        WishListDTO instance = new WishListDTO();
        ArtworkDTO expResult = null;
        ArtworkDTO result = instance.getArtwork();
        assertEquals(expResult, result);
    }

    /**
     * Test of setArtwork method, of class WishListDTO.
     */
    @Test
    public void testSetArtwork() {
        System.out.println("setArtwork");
        ArtworkDTO artwork = null;
        WishListDTO instance = new WishListDTO();
        instance.setArtwork(artwork);
    }

    /**
     * Test of getClient method, of class WishListDTO.
     */
    @Test
    public void testGetClient() {
        System.out.println("getClient");
        WishListDTO instance = new WishListDTO();
        ClientDTO expResult = null;
        ClientDTO result = instance.getClient();
        assertEquals(expResult, result);
    }

    /**
     * Test of setClient method, of class WishListDTO.
     */
    @Test
    public void testSetClient() {
        System.out.println("setClient");
        ClientDTO client = null;
        WishListDTO instance = new WishListDTO();
        instance.setClient(client);
    }
    
}
