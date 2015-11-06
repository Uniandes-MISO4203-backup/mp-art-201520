/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.dtos.ExhibitionDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ResumeDTO;
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
public class ExhibitionDTOTest {
    
    public ExhibitionDTOTest() {
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
     * Test of getId method, of class ExhibitionDTO.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ExhibitionDTO instance = new ExhibitionDTO();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class ExhibitionDTO.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        ExhibitionDTO instance = new ExhibitionDTO();
        instance.setId(id);
        assertNull(id);
    }

    /**
     * Test of getName method, of class ExhibitionDTO.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        ExhibitionDTO instance = new ExhibitionDTO();
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class ExhibitionDTO.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        ExhibitionDTO instance = new ExhibitionDTO();
        instance.setName(name);
        assertNotNull(name);
    }

    /**
     * Test of getDescription method, of class ExhibitionDTO.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        ExhibitionDTO instance = new ExhibitionDTO();
        String expResult = null;
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class ExhibitionDTO.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        ExhibitionDTO instance = new ExhibitionDTO();
        instance.setDescription(description);
        assertNotNull(description);
    }

    /**
     * Test of getStartDate method, of class ExhibitionDTO.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        ExhibitionDTO instance = new ExhibitionDTO();
        Date expResult = null;
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStartDate method, of class ExhibitionDTO.
     */
    @Test
    public void testSetStartDate() {
        System.out.println("setStartDate");
        Date startDate = null;
        ExhibitionDTO instance = new ExhibitionDTO();
        instance.setStartDate(startDate);
        assertNull(startDate);
    }

    /**
     * Test of getEndDate method, of class ExhibitionDTO.
     */
    @Test
    public void testGetEndDate() {
        System.out.println("getEndDate");
        ExhibitionDTO instance = new ExhibitionDTO();
        Date expResult = null;
        Date result = instance.getEndDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEndDate method, of class ExhibitionDTO.
     */
    @Test
    public void testSetEndDate() {
        System.out.println("setEndDate");
        Date endDate = null;
        ExhibitionDTO instance = new ExhibitionDTO();
        instance.setEndDate(endDate);
        assertNull(endDate);
    }

    /**
     * Test of getPlace method, of class ExhibitionDTO.
     */
    @Test
    public void testGetPlace() {
        System.out.println("getPlace");
        ExhibitionDTO instance = new ExhibitionDTO();
        String expResult = null;
        String result = instance.getPlace();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPlace method, of class ExhibitionDTO.
     */
    @Test
    public void testSetPlace() {
        System.out.println("setPlace");
        String place = "";
        ExhibitionDTO instance = new ExhibitionDTO();
        instance.setPlace(place);
        assertNotNull(place);
    }

    /**
     * Test of getKindOfEvent method, of class ExhibitionDTO.
     */
    @Test
    public void testGetKindOfEvent() {
        System.out.println("getKindOfEvent");
        ExhibitionDTO instance = new ExhibitionDTO();
        String expResult = null;
        String result = instance.getKindOfEvent();
        assertEquals(expResult, result);
    }

    /**
     * Test of setKindOfEvent method, of class ExhibitionDTO.
     */
    @Test
    public void testSetKindOfEvent() {
        System.out.println("setKindOfEvent");
        String kindOfEvent = "";
        ExhibitionDTO instance = new ExhibitionDTO();
        instance.setKindOfEvent(kindOfEvent);
        assertNotNull(kindOfEvent);
    }

    /**
     * Test of getAwards method, of class ExhibitionDTO.
     */
    @Test
    public void testGetAwards() {
        System.out.println("getAwards");
        ExhibitionDTO instance = new ExhibitionDTO();
        String expResult = null;
        String result = instance.getAwards();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAwards method, of class ExhibitionDTO.
     */
    @Test
    public void testSetAwards() {
        System.out.println("setAwards");
        String awards = "";
        ExhibitionDTO instance = new ExhibitionDTO();
        instance.setAwards(awards);
        assertNotNull(awards);
    }

    /**
     * Test of getResume method, of class ExhibitionDTO.
     */
    @Test
    public void testGetResume() {
        System.out.println("getResume");
        ExhibitionDTO instance = new ExhibitionDTO();
        ResumeDTO expResult = null;
        ResumeDTO result = instance.getResume();
        assertEquals(expResult, result);
    }

    /**
     * Test of setResume method, of class ExhibitionDTO.
     */
    @Test
    public void testSetResume() {
        System.out.println("setResume");
        ResumeDTO resume = null;
        ExhibitionDTO instance = new ExhibitionDTO();
        instance.setResume(resume);
        assertNull(resume);
    }
    
}
