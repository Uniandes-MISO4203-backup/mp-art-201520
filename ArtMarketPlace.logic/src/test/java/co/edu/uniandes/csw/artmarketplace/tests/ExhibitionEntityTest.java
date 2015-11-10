/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.entities.ExhibitionEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ResumeEntity;
import java.util.Calendar;
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
public class ExhibitionEntityTest {
    
    public ExhibitionEntityTest() {
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
     * Test of getId method, of class ExhibitionEntity.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ExhibitionEntity instance = new ExhibitionEntity();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class ExhibitionEntity.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        ExhibitionEntity instance = new ExhibitionEntity();
        instance.setId(id);
        assertNull(id);
    }

    /**
     * Test of getName method, of class ExhibitionEntity.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        ExhibitionEntity instance = new ExhibitionEntity();
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class ExhibitionEntity.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        ExhibitionEntity instance = new ExhibitionEntity();
        instance.setName(name);
        assertNotNull(name);
    }

    /**
     * Test of getDescription method, of class ExhibitionEntity.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        ExhibitionEntity instance = new ExhibitionEntity();
        String expResult = null;
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class ExhibitionEntity.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        ExhibitionEntity instance = new ExhibitionEntity();
        instance.setDescription(description);
        assertNotNull(description);
    }

    /**
     * Test of getStartDate method, of class ExhibitionEntity.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        ExhibitionEntity instance = new ExhibitionEntity();
        Calendar expResult = null;
        Calendar result = instance.getStartDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStartDate method, of class ExhibitionEntity.
     */
    @Test
    public void testSetStartDate() {
        System.out.println("setStartDate");
        Calendar startDate = null;
        ExhibitionEntity instance = new ExhibitionEntity();
        instance.setStartDate(startDate);
        assertNull(startDate);
    }

    /**
     * Test of getEndDate method, of class ExhibitionEntity.
     */
    @Test
    public void testGetEndDate() {
        System.out.println("getEndDate");
        ExhibitionEntity instance = new ExhibitionEntity();
        Date expResult = null;
        Calendar result = instance.getEndDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEndDate method, of class ExhibitionEntity.
     */
    @Test
    public void testSetEndDate() {
        System.out.println("setEndDate");
        Calendar endDate = null;
        ExhibitionEntity instance = new ExhibitionEntity();
        instance.setEndDate(endDate);
        assertNull(endDate);
    }

    /**
     * Test of getPlace method, of class ExhibitionEntity.
     */
    @Test
    public void testGetPlace() {
        System.out.println("getPlace");
        ExhibitionEntity instance = new ExhibitionEntity();
        String expResult = null;
        String result = instance.getPlace();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPlace method, of class ExhibitionEntity.
     */
    @Test
    public void testSetPlace() {
        System.out.println("setPlace");
        String place = "";
        ExhibitionEntity instance = new ExhibitionEntity();
        instance.setPlace(place);
        assertNotNull(place);
    }

    /**
     * Test of getKindOfEvent method, of class ExhibitionEntity.
     */
    @Test
    public void testGetKindOfEvent() {
        System.out.println("getKindOfEvent");
        ExhibitionEntity instance = new ExhibitionEntity();
        String expResult = null;
        String result = instance.getKindOfEvent();
        assertEquals(expResult, result);
    }

    /**
     * Test of setKindOfEvent method, of class ExhibitionEntity.
     */
    @Test
    public void testSetKindOfEvent() {
        System.out.println("setKindOfEvent");
        String kindOfEvent = "";
        ExhibitionEntity instance = new ExhibitionEntity();
        instance.setKindOfEvent(kindOfEvent);
        assertNotNull(kindOfEvent);
    }

    /**
     * Test of getAwards method, of class ExhibitionEntity.
     */
    @Test
    public void testGetAwards() {
        System.out.println("getAwards");
        ExhibitionEntity instance = new ExhibitionEntity();
        String expResult = null;
        String result = instance.getAwards();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAwards method, of class ExhibitionEntity.
     */
    @Test
    public void testSetAwards() {
        System.out.println("setAwards");
        String awards = "";
        ExhibitionEntity instance = new ExhibitionEntity();
        instance.setAwards(awards);
        assertNotNull(awards);
    }

    /**
     * Test of getResume method, of class ExhibitionEntity.
     */
    @Test
    public void testGetResume() {
        System.out.println("getResume");
        ExhibitionEntity instance = new ExhibitionEntity();
        ResumeEntity expResult = null;
        ResumeEntity result = instance.getResume();
        assertEquals(expResult, result);
    }

    /**
     * Test of setResume method, of class ExhibitionEntity.
     */
    @Test
    public void testSetResume() {
        System.out.println("setResume");
        ResumeEntity resume = null;
        ExhibitionEntity instance = new ExhibitionEntity();
        instance.setResume(resume);
        assertNull(resume);
    }
    
}
