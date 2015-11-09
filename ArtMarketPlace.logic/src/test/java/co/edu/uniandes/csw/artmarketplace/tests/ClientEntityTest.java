/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.entities.CartItemEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ClientEntity;
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
public class ClientEntityTest {
    
    public ClientEntityTest() {
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
     * Test of getId method, of class ClientEntity.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ClientEntity instance = new ClientEntity();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class ClientEntity.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        ClientEntity instance = new ClientEntity();
        instance.setId(id);
    }

    /**
     * Test of getCartItem method, of class ClientEntity.
     */
    @Test
    public void testGetCartItem() {
        System.out.println("getCartItem");
        ClientEntity instance = new ClientEntity();
        List<CartItemEntity> expResult = null;
        List<CartItemEntity> result = instance.getCartItem();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCartItem method, of class ClientEntity.
     */
    @Test
    public void testSetCartItem() {
        System.out.println("setCartItem");
        List<CartItemEntity> cartitem = null;
        ClientEntity instance = new ClientEntity();
        instance.setCartItem(cartitem);
    }

    /**
     * Test of getName method, of class ClientEntity.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        ClientEntity instance = new ClientEntity();
        String expResult = "";
        String result = instance.getName();
        assertNotNull(expResult);
    }

    /**
     * Test of setName method, of class ClientEntity.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        ClientEntity instance = new ClientEntity();
        instance.setName(name);
    }

    /**
     * Test of getUserId method, of class ClientEntity.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        ClientEntity instance = new ClientEntity();
        String expResult = "";
        String result = instance.getUserId();
        assertNotNull(expResult);
    }

    /**
     * Test of setUserId method, of class ClientEntity.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        String userId = "";
        ClientEntity instance = new ClientEntity();
        instance.setUserId(userId);
    }
    
}
