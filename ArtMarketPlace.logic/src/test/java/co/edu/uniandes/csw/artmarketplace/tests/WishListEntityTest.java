/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ClientEntity;
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
public class WishListEntityTest {
    
    public WishListEntityTest() {
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
     * Test of getId method, of class WishListEntity.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        WishListEntity instance = new WishListEntity();
        Long expResult = 0L;
        Long result = instance.getId();
        assertNotNull(expResult);
    }

    /**
     * Test of setId method, of class WishListEntity.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 0L;
        WishListEntity instance = new WishListEntity();
        instance.setId(id);
        assertNotNull(id);
    }

    /**
     * Test of getArtwork method, of class WishListEntity.
     */
    @Test
    public void testGetArtwork() {
        System.out.println("getArtwork");
        WishListEntity instance = new WishListEntity();
        ArtworkEntity expResult = null;
        ArtworkEntity result = instance.getArtwork();
        assertNull(expResult);
    }

    /**
     * Test of setArtwork method, of class WishListEntity.
     */
    @Test
    public void testSetArtwork() {
        System.out.println("setArtwork");
        ArtworkEntity artwork = null;
        WishListEntity instance = new WishListEntity();
        instance.setArtwork(artwork);
        assertNull(artwork);
    }

    /**
     * Test of getClient method, of class WishListEntity.
     */
    @Test
    public void testGetClient() {
        System.out.println("getClient");
        WishListEntity instance = new WishListEntity();
        ClientEntity expResult = null;
        ClientEntity result = instance.getClient();
        assertEquals(expResult, result);
        assertNull(expResult);
    }

    /**
     * Test of setClient method, of class WishListEntity.
     */
    @Test
    public void testSetClient() {
        System.out.println("setClient");
        ClientEntity client = null;
        WishListEntity instance = new WishListEntity();
        instance.setClient(client);
        assertNull(client);
    }
    
}
