/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.api.IExperienceLogic;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtistDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ExperienceDTO;
import co.edu.uniandes.csw.artmarketplace.ejbs.ExperienceLogic;
import co.edu.uniandes.csw.artmarketplace.entities.ExperienceEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.ExperiencePersistence;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
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
public class ExperienceLogicTest {
    
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Inject
    private IExperienceLogic experienceLogic;
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ExperienceEntity.class.getPackage())
                .addPackage(ExperiencePersistence.class.getPackage())
                .addPackage(IExperienceLogic.class.getPackage())
                .addPackage(ExperienceLogic.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
    public ExperienceLogicTest() {
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
     * Test of createResume method, of class ExperienceLogic.
     */
    @Test
    public void testCreateResume() {
        System.out.println("createResume");
        ExperienceDTO dto = new ExperienceDTO();
        ArtistDTO artist = new ArtistDTO();
        ExperienceDTO expResult = new ExperienceDTO();
        ExperienceDTO result = experienceLogic.createResume(dto, artist);
        assertNotNull(dto);
    }
    
}
