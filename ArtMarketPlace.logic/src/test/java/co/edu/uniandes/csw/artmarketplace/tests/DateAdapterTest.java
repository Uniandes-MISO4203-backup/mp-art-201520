/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.dtos.DateAdapter;
import java.util.Date;
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
public class DateAdapterTest {
    
    public DateAdapterTest() {
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
     * Test of unmarshal method, of class DateAdapter.
     */
    @Test
    public void testUnmarshal() throws Exception {
        System.out.println("unmarshal");
        String v = "2015-08-15";
        DateAdapter instance = new DateAdapter();
        Date result = instance.unmarshal(v);
        assertNotNull(v);
    }

    /**
     * Test of marshal method, of class DateAdapter.
     */
    @Test
    public void testMarshal() throws Exception {
        System.out.println("marshal");
        Date v = null;
        DateAdapter instance = new DateAdapter();
        String expResult = "";
        String result = instance.marshal(v);
        assertNull(v);
        
        v = new Date();
        result = instance.marshal(v);
        assertNotNull(v);
    }
    
}
