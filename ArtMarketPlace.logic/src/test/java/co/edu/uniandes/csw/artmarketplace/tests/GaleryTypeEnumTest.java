/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import enums.GaleryTypeEnum;
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
public class GaleryTypeEnumTest {
    
    public GaleryTypeEnumTest() {
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
     * Test of values method, of class GaleryTypeEnum.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        GaleryTypeEnum[] expResult = {GaleryTypeEnum.PHOTO,GaleryTypeEnum.VIDEO};
        GaleryTypeEnum[] result = GaleryTypeEnum.values();
        assertArrayEquals(expResult, result);
    }

    

    /**
     * Test of getName method, of class GaleryTypeEnum.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        GaleryTypeEnum instance = GaleryTypeEnum.PHOTO;
        String expResult = "Photo";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class GaleryTypeEnum.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Photo";
        GaleryTypeEnum instance = GaleryTypeEnum.PHOTO;
        instance.setName(name);
    }
    
}
