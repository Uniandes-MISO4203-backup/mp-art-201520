/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.api.IExhibitionLogic;
import co.edu.uniandes.csw.artmarketplace.converters.ArtistConverter;
import co.edu.uniandes.csw.artmarketplace.converters.ExhibitionConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ExhibitionDTO;
import co.edu.uniandes.csw.artmarketplace.ejbs.ExhibitionLogic;
import co.edu.uniandes.csw.artmarketplace.entities.ArtistEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ExhibitionEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ResumeEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.ArtistPersistence;
import co.edu.uniandes.csw.artmarketplace.persistence.ExhibitionPersistence;
import co.edu.uniandes.csw.artmarketplace.persistence.ResumePersistence;
import static co.edu.uniandes.csw.artmarketplace.tests._TestUtil.generateRandom;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * La clase ExhibitionLogicTest esta disenada para ejecutar las pruebas de
 * unitarias correspondiente a la logica de infomacion de exhibiciones de un
 * artista.
 *
 * @author lf.mendivelso10
 * @version 1.0.0
 */
@RunWith(Arquillian.class)
public class ExhibitionLogicTest {

    private ArtistEntity artist;

    private ResumeEntity resume;

    /**
     * @generated
     */
    @Inject
    private ArtistPersistence artistPersistence;
    /**
     * @generated
     */
    @Inject
    private ResumePersistence resumePersistence;

    /**
     * @generated
     */
    @Inject
    private IExhibitionLogic exhibitionLogic;

    /**
     * @generated
     */
    @Inject
    UserTransaction utx;

    /**
     * @generated
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    public static final String DEPLOY = "Prueba";

    /**
     * @return @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ArtistEntity.class.getPackage())
                .addPackage(ArtistPersistence.class.getPackage())
                .addPackage(ResumeEntity.class.getPackage())
                .addPackage(ResumePersistence.class.getPackage())
                .addPackage(ExhibitionEntity.class.getPackage())
                .addPackage(ExhibitionPersistence.class.getPackage())
                .addPackage(IExhibitionLogic.class.getPackage())
                .addPackage(ExhibitionLogic.class.getPackage())
                .addPackage(ExhibitionConverter.class.getPackage())
                .addPackage(ArtistConverter.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    public Float genRandomFloat() {
        Float minX = 1.0f;
        Float maxX = 5.0f;
        Random rand = new Random();
        Float finalX = rand.nextFloat() * (maxX - minX) + minX;
        return finalX;
    }

    public void preloadData() {
        this.artist = new ArtistEntity();
        this.artist.setId(generateRandom(Long.class));
        this.artist.setName(generateRandom(String.class));
        this.artist.setUserId(generateRandom(String.class));

        this.resume = new ResumeEntity();
        this.resume.setArtist(artist);
        this.resume.setCity(generateRandom(String.class));
        this.resume.setCountry(generateRandom(String.class));
        this.resume.setId(generateRandom(Long.class));
        this.resume.setLastName(generateRandom(String.class));
        this.resume.setPhoto(generateRandom(String.class));
        this.resume.setRatingSum(genRandomFloat());
        this.resume.setRatingVotes(genRandomFloat());
        this.resume.setWebsite(generateRandom(String.class));
    }

    /**
     * @generated
     */
    private void clearDB() {
        try {
            utx.begin();
            em.createQuery("delete from ExhibitionEntity").executeUpdate();
            em.createQuery("delete from ResumeEntity").executeUpdate();
            em.createQuery("delete from ArtistEntity").executeUpdate();
            utx.commit();
            if (artist != null && resume != null) {
                this.artist = null;
                this.resume = null;
            }
        } catch (NotSupportedException e) {
            Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e);
            try {
                utx.rollback();
            } catch (IllegalStateException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SecurityException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SystemException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            }
        } catch (SystemException e) {
            Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e);
            try {
                utx.rollback();
            } catch (IllegalStateException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SecurityException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SystemException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            }
        } catch (RollbackException e) {
            Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e);
            try {
                utx.rollback();
            } catch (IllegalStateException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SecurityException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SystemException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            }
        } catch (HeuristicMixedException e) {
            Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e);
            try {
                utx.rollback();
            } catch (IllegalStateException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SecurityException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SystemException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            }
        } catch (HeuristicRollbackException e) {
            Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e);
            try {
                utx.rollback();
            } catch (IllegalStateException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SecurityException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SystemException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            }
        } catch (SecurityException e) {
            Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e);
            try {
                utx.rollback();
            } catch (IllegalStateException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SecurityException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SystemException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            }
        } catch (IllegalStateException e) {
            Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e);
            try {
                utx.rollback();
            } catch (IllegalStateException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SecurityException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SystemException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            }
        }
    }

    public void saveTestCaseData() {
        try {
            utx.begin();
            em.persist(this.artist);
            em.persist(this.resume);
            utx.commit();
        } catch (NotSupportedException e) {
            Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e);
            try {
                utx.rollback();
            } catch (IllegalStateException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SecurityException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SystemException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            }
        } catch (SystemException e) {
            Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e);
            try {
                utx.rollback();
            } catch (IllegalStateException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SecurityException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SystemException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            }
        } catch (RollbackException e) {
            Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e);
            try {
                utx.rollback();
            } catch (IllegalStateException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SecurityException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SystemException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            }
        } catch (HeuristicMixedException e) {
            Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e);
            try {
                utx.rollback();
            } catch (IllegalStateException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SecurityException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SystemException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            }
        } catch (HeuristicRollbackException e) {
            Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e);
            try {
                utx.rollback();
            } catch (IllegalStateException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SecurityException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SystemException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            }
        } catch (SecurityException e) {
            Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e);
            try {
                utx.rollback();
            } catch (IllegalStateException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SecurityException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SystemException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            }
        } catch (IllegalStateException e) {
            Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e);
            try {
                utx.rollback();
            } catch (IllegalStateException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SecurityException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            } catch (SystemException e1) {
                Logger.getLogger(ExhibitionPersistenceTest.class.getName()).log(Level.SEVERE, null, e1);
            }
        }
    }

    public void generateTestCase() {
        clearDB();
        preloadData();
        saveTestCaseData();
    }

    @Test
    public void createExhibitionTest() {
        generateTestCase();
        ExhibitionEntity exhibition = new ExhibitionEntity();
        exhibition.setStartDate(Calendar.getInstance());
        exhibition.setId(generateRandom(Long.class));
        exhibition.setAwards(generateRandom(String.class));
        exhibition.setDescription(generateRandom(String.class));
        exhibition.setKindOfEvent(generateRandom(String.class));
        exhibition.setName(generateRandom(String.class));
        exhibition.setEndDate(Calendar.getInstance());
        exhibition.setPlace(generateRandom(String.class));
        
        ExhibitionDTO record = exhibitionLogic.createExhibition(ExhibitionConverter.fullEntity2DTO(exhibition), ArtistConverter.refEntity2DTO(artist));
        Assert.assertNotNull(record);
        Assert.assertEquals(exhibition.getName(), record.getName());
        Assert.assertEquals(exhibition.getDescription(), record.getDescription());
        Assert.assertEquals(exhibition.getKindOfEvent(), record.getKindOfEvent());
        Assert.assertEquals(exhibition.getStartDate().toString(), record.getStartDate().toString());
        Assert.assertEquals(exhibition.getEndDate().toString(), record.getEndDate().toString());
        Assert.assertEquals(exhibition.getPlace(), record.getPlace());
        Assert.assertEquals(exhibition.getAwards(), record.getAwards());
    }
}
