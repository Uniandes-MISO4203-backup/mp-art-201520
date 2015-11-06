/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import enums.PaymentTypeEnum;
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
public class PaymentTypeEnumTest {
    
    public PaymentTypeEnumTest() {
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
     * Test of values method, of class PaymentTypeEnum.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        PaymentTypeEnum[] expResult = null;
        PaymentTypeEnum[] result = PaymentTypeEnum.values();
        assertNull(expResult);
    }

    /**
     * Test of valueOf method, of class PaymentTypeEnum.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "PSE";
        PaymentTypeEnum result = PaymentTypeEnum.valueOf(name);
        assertNotNull(name);
    }

    /**
     * Test of getName method, of class PaymentTypeEnum.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        PaymentTypeEnum instance = PaymentTypeEnum.PSE;
        String result = instance.getName();
        assertNotNull(instance);
    }

    /**
     * Test of setName method, of class PaymentTypeEnum.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        PaymentTypeEnum instance = PaymentTypeEnum.PSE;
        instance.setName(name);
        assertNotNull(name);
    }
    
}
