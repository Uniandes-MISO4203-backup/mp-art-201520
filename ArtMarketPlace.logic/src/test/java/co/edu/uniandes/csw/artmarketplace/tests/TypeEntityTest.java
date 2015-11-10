/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.entities.TypeEntity;
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
public class TypeEntityTest {
    
    public TypeEntityTest() {
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
     * Test of getId method, of class TypeEntity.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        TypeEntity instance = new TypeEntity();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class TypeEntity.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        TypeEntity instance = new TypeEntity();
        instance.setId(id);
    }

    /**
     * Test of getName method, of class TypeEntity.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        TypeEntity instance = new TypeEntity();
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class TypeEntity.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String type = "";
        TypeEntity instance = new TypeEntity();
        instance.setName(type);
    }
    
}
