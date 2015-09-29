/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.api.IExperienceLogic;
import static co.edu.uniandes.csw.artmarketplace.tests._TestUtil.*;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.uniandes.csw.artmarketplace.api.IResumeLogic;
import co.edu.uniandes.csw.artmarketplace.converters.ArtistConverter;
import co.edu.uniandes.csw.artmarketplace.converters.ExperienceConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtistDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ExperienceDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ResumeDTO;
import co.edu.uniandes.csw.artmarketplace.ejbs.ExperienceLogic;
import co.edu.uniandes.csw.artmarketplace.entities.ArtistEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ExperienceEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ResumeEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.ExperiencePersistence;
import java.util.Date;

/**
 * Clase de pruebas sobre la lógica de registros de experiencia de hoja de vida
 * @author vp.salcedo93
 */
@RunWith(Arquillian.class)
public class ExperienceTestLogic {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ExperienceEntity.class.getPackage())
                .addPackage(ExperienceDTO.class.getPackage())
                .addPackage(ExperienceConverter.class.getPackage())
                .addPackage(ArtistConverter.class.getPackage())
                .addPackage(ArtistEntity.class.getPackage())
                .addPackage(ArtistDTO.class.getPackage())
                .addPackage(ExperienceLogic.class.getPackage())
                .addPackage(IExperienceLogic.class.getPackage())
                .addPackage(ExperiencePersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IExperienceLogic experienceLogic;

    /**
     * @generated
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    @Inject
    UserTransaction utx;

    /**
     * @generated
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * @generated
     */
    private void clearData() {
        em.createQuery("delete from ExperienceEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<ExperienceEntity> data = new ArrayList<ExperienceEntity>();

    /**
     * @generated
     */
    private void insertData() {
        ArtistEntity artistEntityOne = new ArtistEntity();
        artistEntityOne.setName("Artista1");
        em.persist(artistEntityOne);
        
        ResumeEntity resumeEntityOne = new ResumeEntity();
        resumeEntityOne.setCity(generateRandom(String.class));
        resumeEntityOne.setCountry(generateRandom(String.class));
        resumeEntityOne.setWebsite(generateRandom(String.class));
        resumeEntityOne.setLastName(generateRandom(String.class));
        resumeEntityOne.setPhoto(generateRandom(String.class));
        resumeEntityOne.setArtist(artistEntityOne);
        em.persist(resumeEntityOne);
        
        for (int i = 0; i < 3; i++) {
            
            ExperienceEntity entity = new ExperienceEntity();
            entity.setFinishDate(generateRandom(Date.class));
            entity.setStartDate(generateRandom(Date.class));
            entity.setPlace(generateRandom(String.class));
            entity.setTitle(generateRandom(String.class));
            entity.setType(generateRandom(String.class));
            entity.setResume(resumeEntityOne);
            em.persist(entity);
            data.add(entity);
        }
    }
    /**
     * Prueba sobre la creación de un registro del CV
     */
    @Test
    public void createResumeTest() {
        
        ArtistEntity artistEntityTwo = new ArtistEntity();
        artistEntityTwo.setName("Artista1");
        em.persist(artistEntityTwo);
        ArtistDTO artistDTOTwo = ArtistConverter.refEntity2DTO(artistEntityTwo);
        
        ExperienceDTO dto = new ExperienceDTO();
        dto.setFinishDate(generateRandom(Date.class));
        dto.setStartDate(generateRandom(Date.class));
        dto.setPlace(generateRandom(String.class));
        dto.setTitle(generateRandom(String.class));
        dto.setType(generateRandom(String.class));

        ExperienceDTO result = experienceLogic.createResume(dto,artistDTOTwo);

        Assert.assertNotNull(result);

        ExperienceEntity entity = em.find(ExperienceEntity.class, result.getId());

        Assert.assertEquals(dto.getFinishDate(), entity.getFinishDate());
        Assert.assertEquals(dto.getPlace(), entity.getPlace());
        Assert.assertEquals(dto.getStartDate(), entity.getStartDate());
        Assert.assertEquals(dto.getTitle(), entity.getTitle());
        Assert.assertEquals(dto.getType(), entity.getType());
    }
    
 
}
