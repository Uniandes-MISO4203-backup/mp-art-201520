/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.entities.ArtistEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ExperienceEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ResumeEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.ResumePersistence;
import static co.edu.uniandes.csw.artmarketplace.tests._TestUtil.generateRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import junit.framework.TestCase;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * La clase ResumenPersistenceTest tiene como finalidad evaluar el modelo de
 * persistencia para los objetos del tipo ResumeEntity.
 *
 * @author lf.mendivelso10
 */
@RunWith(Arquillian.class)
public class ResumePersistenceTest{

    /**
     * @generated
     */
    @Inject
    private ResumePersistence resumePersistence;

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
    List<ResumeEntity> data = new ArrayList<ResumeEntity>();

    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ResumeEntity.class.getPackage())
                .addPackage(ArtistEntity.class.getPackage())
                .addPackage(ArtworkEntity.class.getPackage())
                .addPackage(ResumePersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

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
        em.createQuery("delete from ArtistEntity").executeUpdate();
        em.createQuery("delete from ResumeEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ArtistEntity artist = new ArtistEntity();
            artist.setId(generateRandom(Long.class));
            artist.setName(generateRandom(String.class));
            artist.setUserId(generateRandom(String.class));
            ResumeEntity entity = new ResumeEntity();
            entity.setCity(generateRandom(String.class));
            entity.setWebsite(generateRandom(String.class));
            entity.setLastName(generateRandom(String.class));
            entity.setPhoto(generateRandom(String.class));
            entity.setRatingSum(new Random().nextFloat());
            entity.setRatingVotes(new Random().nextFloat());
            entity.setCountry(generateRandom(String.class));
            entity.setArtist(artist);
            ExperienceEntity exp = new ExperienceEntity();
            exp.setPlace(generateRandom(String.class));
            exp.setTitle(generateRandom(String.class));
            exp.setType(generateRandom(String.class));
            exp.setStartDate(new Date());
            exp.setResume(entity);
            List<ExperienceEntity> exps = new ArrayList<ExperienceEntity>();
            exps.add(exp);
            entity.setExperience(exps);
            data.add(entity);
            em.persist(entity);
        }
    }
    
    @Test
    public void getResumesTest() {
        List<ResumeEntity> list = resumePersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (ResumeEntity ent : list) {
            boolean found = false;
            for (ResumeEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createResumeTest() {
        ArtistEntity artist = new ArtistEntity();
        artist.setId(generateRandom(Long.class));
        artist.setName(generateRandom(String.class));
        artist.setUserId(generateRandom(String.class));

        ResumeEntity newEntity = new ResumeEntity();
        newEntity.setCity(generateRandom(String.class));
        newEntity.setWebsite(generateRandom(String.class));
        newEntity.setLastName(generateRandom(String.class));
        newEntity.setPhoto(generateRandom(String.class));
        newEntity.setRatingSum(new Random().nextFloat());
        newEntity.setRatingVotes(new Random().nextFloat());
        newEntity.setCountry(generateRandom(String.class));
        newEntity.setArtist(artist);

        ResumeEntity result = resumePersistence.create(newEntity);
        Assert.assertNotNull(result);

        ResumeEntity entity = em.find(ResumeEntity.class, result.getId());
        Assert.assertEquals(newEntity.getPhoto(), entity.getPhoto());
        Assert.assertEquals(newEntity.getCity(), entity.getCity());
        Assert.assertEquals(newEntity.getArtist().getId(), entity.getArtist().getId());
        Assert.assertEquals(newEntity.getRatingSum(), entity.getRatingSum(), 0.0002f);
        Assert.assertEquals(newEntity.getRatingVotes(), entity.getRatingVotes(), 0.0002f);
        Assert.assertEquals(newEntity.getWebsite(), entity.getWebsite());
        Assert.assertEquals(newEntity.getCountry(), entity.getCountry());
        Assert.assertEquals(newEntity.getLastName(), entity.getLastName());
        data.add(newEntity);
    }

    
    

}
