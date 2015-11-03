/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.dtos.ArtistDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ExperienceDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ResumeDTO;
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
public class ResumeDTOTest {
    
    public ResumeDTOTest() {
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
     * Test of getLastName method, of class ResumeDTO.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        ResumeDTO instance = new ResumeDTO();
        instance.setLastName("");
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLastName method, of class ResumeDTO.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        ResumeDTO instance = new ResumeDTO();
        instance.setLastName(lastName);
        
        assertNotNull(instance);
    }

    /**
     * Test of getArtist method, of class ResumeDTO.
     */
    @Test
    public void testGetArtist() {
        System.out.println("getArtist");
        ResumeDTO instance = new ResumeDTO();
        ArtistDTO expResult = null;
        ArtistDTO result = instance.getArtist();
        assertEquals(expResult, result);
    }

    /**
     * Test of setArtist method, of class ResumeDTO.
     */
    @Test
    public void testSetArtist() {
        System.out.println("setArtist");
        ArtistDTO artist = null;
        ResumeDTO instance = new ResumeDTO();
        instance.setArtist(artist);
        
        assertNotNull(instance);
    }

    /**
     * Test of getExperience method, of class ResumeDTO.
     */
    @Test
    public void testGetExperience() {
        System.out.println("getExperience");
        ResumeDTO instance = new ResumeDTO();
        List<ExperienceDTO> expResult = null;
        List<ExperienceDTO> result = instance.getExperience();
        assertEquals(expResult, result);
    }

    /**
     * Test of setExperience method, of class ResumeDTO.
     */
    @Test
    public void testSetExperience() {
        System.out.println("setExperience");
        List<ExperienceDTO> experience = null;
        ResumeDTO instance = new ResumeDTO();
        instance.setExperience(experience);
        assertNotNull(instance);
    }

    /**
     * Test of getCountry method, of class ResumeDTO.
     */
    @Test
    public void testGetCountry() {
        System.out.println("getCountry");
        ResumeDTO instance = new ResumeDTO();
        instance.setCountry("");
        String expResult = "";
        String result = instance.getCountry();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCountry method, of class ResumeDTO.
     */
    @Test
    public void testSetCountry() {
        System.out.println("setCountry");
        String country = "";
        ResumeDTO instance = new ResumeDTO();
        instance.setCountry(country);
        assertNotNull(instance);
    }

    /**
     * Test of getCity method, of class ResumeDTO.
     */
    @Test
    public void testGetCity() {
        System.out.println("getCity");
        ResumeDTO instance = new ResumeDTO();
        instance.setCity("");
        String expResult = "";
        String result = instance.getCity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCity method, of class ResumeDTO.
     */
    @Test
    public void testSetCity() {
        System.out.println("setCity");
        String city = "";
        ResumeDTO instance = new ResumeDTO();
        instance.setCity(city);
        assertNotNull(instance);
    }

    /**
     * Test of getPhoto method, of class ResumeDTO.
     */
    @Test
    public void testGetPhoto() {
        System.out.println("getPhoto");
        ResumeDTO instance = new ResumeDTO();
        instance.setPhoto("");
        String expResult = "";
        String result = instance.getPhoto();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPhoto method, of class ResumeDTO.
     */
    @Test
    public void testSetPhoto() {
        System.out.println("setPhoto");
        String photo = "";
        ResumeDTO instance = new ResumeDTO();
        instance.setPhoto(photo);
        assertNotNull(instance);
    }

    /**
     * Test of getWebsite method, of class ResumeDTO.
     */
    @Test
    public void testGetWebsite() {
        System.out.println("getWebsite");
        ResumeDTO instance = new ResumeDTO();
        instance.setWebsite("");
        String expResult = "";
        String result = instance.getWebsite();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWebsite method, of class ResumeDTO.
     */
    @Test
    public void testSetWebsite() {
        System.out.println("setWebsite");
        String website = "";
        ResumeDTO instance = new ResumeDTO();
        instance.setWebsite(website);
        assertNotNull(instance);
    }

    /**
     * Test of getRatingVotes method, of class ResumeDTO.
     */
    @Test
    public void testGetRatingVotes() {
        System.out.println("getRatingVotes");
        ResumeDTO instance = new ResumeDTO();
        Float expResult = null;
        Float result = instance.getRatingVotes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRatingVotes method, of class ResumeDTO.
     */
    @Test
    public void testSetRatingVotes() {
        System.out.println("setRatingVotes");
        Float ratingVotes = null;
        ResumeDTO instance = new ResumeDTO();
        instance.setRatingVotes(ratingVotes);
        assertNotNull(instance);
    }

    /**
     * Test of getRatingSum method, of class ResumeDTO.
     */
    @Test
    public void testGetRatingSum() {
        System.out.println("getRatingSum");
        ResumeDTO instance = new ResumeDTO();
        Float expResult = null;
        Float result = instance.getRatingSum();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRatingSum method, of class ResumeDTO.
     */
    @Test
    public void testSetRatingSum() {
        System.out.println("setRatingSum");
        Float ratingSum = null;
        ResumeDTO instance = new ResumeDTO();
        instance.setRatingSum(ratingSum);
        assertNotNull(instance);
    }
    
}
