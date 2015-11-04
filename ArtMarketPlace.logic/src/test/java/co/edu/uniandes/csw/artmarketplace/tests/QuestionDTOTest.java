/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ClientDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.QuestionDTO;
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
public class QuestionDTOTest {
    
    public QuestionDTOTest() {
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
     * Test of getArtwork method, of class QuestionDTO.
     */
    @Test
    public void testGetArtwork() {
        System.out.println("getArtwork");
        QuestionDTO instance = new QuestionDTO();
        ArtworkDTO expResult = null;
        ArtworkDTO result = instance.getArtwork();
        assertEquals(expResult, result);
    }

    /**
     * Test of setArtwork method, of class QuestionDTO.
     */
    @Test
    public void testSetArtwork() {
        System.out.println("setArtwork");
        ArtworkDTO artwork = null;
        QuestionDTO instance = new QuestionDTO();
        instance.setArtwork(artwork);
        assertNull(artwork);
    }

    /**
     * Test of getDate method, of class QuestionDTO.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        QuestionDTO instance = new QuestionDTO();
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDate method, of class QuestionDTO.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = null;
        QuestionDTO instance = new QuestionDTO();
        instance.setDate(date);
        assertNull(date);
    }

    /**
     * Test of getEmail method, of class QuestionDTO.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        QuestionDTO instance = new QuestionDTO();
        String expResult = null;
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class QuestionDTO.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        QuestionDTO instance = new QuestionDTO();
        instance.setEmail(email);
        assertNotNull(email);
    }

    /**
     * Test of getClient method, of class QuestionDTO.
     */
    @Test
    public void testGetClient() {
        System.out.println("getClient");
        QuestionDTO instance = new QuestionDTO();
        ClientDTO expResult = null;
        ClientDTO result = instance.getClient();
        assertEquals(expResult, result);
    }

    /**
     * Test of setClient method, of class QuestionDTO.
     */
    @Test
    public void testSetClient() {
        System.out.println("setClient");
        ClientDTO client = null;
        QuestionDTO instance = new QuestionDTO();
        instance.setClient(client);
        
        assertNull(client);
    }

    /**
     * Test of getArtistEmail method, of class QuestionDTO.
     */
    @Test
    public void testGetArtistEmail() {
        System.out.println("getArtistEmail");
        QuestionDTO instance = new QuestionDTO();
        String expResult = null;
        String result = instance.getArtistEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setArtistEmail method, of class QuestionDTO.
     */
    @Test
    public void testSetArtistEmail() {
        System.out.println("setArtistEmail");
        String artistEmail = "";
        QuestionDTO instance = new QuestionDTO();
        instance.setArtistEmail(artistEmail);
        assertNotNull(artistEmail);
    }

    /**
     * Test of getQuestion method, of class QuestionDTO.
     */
    @Test
    public void testGetQuestion() {
        System.out.println("getQuestion");
        QuestionDTO instance = new QuestionDTO();
        String expResult = null;
        String result = instance.getQuestion();
        assertEquals(expResult, result);
    }

    /**
     * Test of setQuestion method, of class QuestionDTO.
     */
    @Test
    public void testSetQuestion() {
        System.out.println("setQuestion");
        String question = "";
        QuestionDTO instance = new QuestionDTO();
        instance.setQuestion(question);
        
        assertNotNull(question);
    }
    
}
