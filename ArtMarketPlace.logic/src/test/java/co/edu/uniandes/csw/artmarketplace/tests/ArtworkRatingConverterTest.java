/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.converters.ArtworkRatingConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkRatingDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkRatingEntity;
import java.util.ArrayList;
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
public class ArtworkRatingConverterTest {
    
    public ArtworkRatingConverterTest() {
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
     * Test of basicArtworkRatingEntity2DTO method, of class ArtworkRatingConverter.
     */
    @Test
    public void testBasicArtworkRatingEntity2DTO() {
        System.out.println("basicArtworkRatingEntity2DTO");
        ArtworkRatingEntity artworkRating = null;
        ArtworkRatingDTO result = ArtworkRatingConverter.basicArtworkRatingEntity2DTO(artworkRating);
        assertNull(artworkRating);
        
        artworkRating = new ArtworkRatingEntity();
        result = ArtworkRatingConverter.basicArtworkRatingEntity2DTO(artworkRating);
        assertNotNull(artworkRating);
    }

    /**
     * Test of basicArtworkRatingDTO2Entity method, of class ArtworkRatingConverter.
     */
    @Test
    public void testBasicArtworkRatingDTO2Entity() {
        System.out.println("basicArtworkRatingDTO2Entity");
        ArtworkRatingDTO artworkRating = null;
        ArtworkRatingEntity result = ArtworkRatingConverter.basicArtworkRatingDTO2Entity(artworkRating);
        assertNull(artworkRating);
        
        artworkRating = new ArtworkRatingDTO();
        result = ArtworkRatingConverter.basicArtworkRatingDTO2Entity(artworkRating);
        assertNotNull(artworkRating);
    }

    /**
     * Test of listArtworkRatingDTO2Entity method, of class ArtworkRatingConverter.
     */
    @Test
    public void testListArtworkRatingDTO2Entity() {
        System.out.println("listArtworkRatingDTO2Entity");
        List<ArtworkRatingDTO> list = null;
        List<ArtworkRatingEntity> result = ArtworkRatingConverter.listArtworkRatingDTO2Entity(list);
        assertNull(list);
        
        list = new ArrayList<ArtworkRatingDTO>();
        list.add(new ArtworkRatingDTO());
        result = ArtworkRatingConverter.listArtworkRatingDTO2Entity(list);
        assertNotNull(list);
    }

    /**
     * Test of listArtworkRatingEntity2DTO method, of class ArtworkRatingConverter.
     */
    @Test
    public void testListArtworkRatingEntity2DTO() {
        System.out.println("listArtworkRatingEntity2DTO");
        List<ArtworkRatingEntity> list = null;
        List<ArtworkRatingDTO> result = ArtworkRatingConverter.listArtworkRatingEntity2DTO(list);
        assertNull(list);
        
        list = new ArrayList<ArtworkRatingEntity>();
        list.add(new ArtworkRatingEntity());
        result = ArtworkRatingConverter.listArtworkRatingEntity2DTO(list);
        assertNotNull(list);
    }
    
}
