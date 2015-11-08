package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.entities.ArtistEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ExhibitionEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ResumeEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.ArtistPersistence;
import co.edu.uniandes.csw.artmarketplace.persistence.ExhibitionPersistence;
import co.edu.uniandes.csw.artmarketplace.persistence.ResumePersistence;
import static co.edu.uniandes.csw.artmarketplace.tests._TestUtil.generateRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import org.junit.Assert;
import org.junit.Test;

/**
 * La clase ExhibitionPersistenceTest esta diseñada para ejecutar las pruebas de
 * unitarias correspondiente a la persistencia de infomación de exhibiciones de
 * un artista.
 *
 * @author lf.mendivelso10
 */
@RunWith(Arquillian.class)
public class ExhibitionPersistenceTest {

    private ArtistEntity artist;

    private ResumeEntity resume;

    private List<ExhibitionEntity> exhibitions;

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
    private ExhibitionPersistence exhibitionPersistence;

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
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
    public Float genRandomFloat(){
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

        this.exhibitions = new ArrayList<ExhibitionEntity>();
        for (int i = 0; i < 5; i++) {
            ExhibitionEntity exhibition = new ExhibitionEntity();
            exhibition.setStartDate(Calendar.getInstance());
            exhibition.setId(generateRandom(Long.class));
            exhibition.setAwards(generateRandom(String.class));
            exhibition.setDescription(generateRandom(String.class));
            exhibition.setKindOfEvent(generateRandom(String.class));
            exhibition.setName(generateRandom(String.class));
            exhibition.setResume(resume);
            exhibition.setEndDate(Calendar.getInstance());
            exhibition.setPlace(generateRandom(String.class));
            this.exhibitions.add(exhibition);
        }
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
            if (exhibitions != null && artist != null && resume != null) {
                this.exhibitions.clear();
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
            for (ExhibitionEntity ex : this.exhibitions) {
                em.persist(ex);
            }
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

    /**
     * @generated
     */
    @Test
    public void createArtistTest() {
        generateTestCase();
        ExhibitionEntity exhibition = new ExhibitionEntity();
        exhibition.setName(generateRandom(String.class));
        exhibition.setDescription(generateRandom(String.class));
        exhibition.setKindOfEvent(generateRandom(String.class));
        exhibition.setStartDate(Calendar.getInstance());
        exhibition.setEndDate(Calendar.getInstance());
        exhibition.setPlace(generateRandom(String.class));
        exhibition.setAwards(generateRandom(String.class));
        exhibition.setResume(resume);

        ExhibitionEntity record = exhibitionPersistence.create(exhibition);
        Assert.assertNotNull(record);
        Assert.assertEquals(exhibition.getName(), record.getName());
        Assert.assertEquals(exhibition.getDescription(), record.getDescription());
        Assert.assertEquals(exhibition.getKindOfEvent(), record.getKindOfEvent());
        Assert.assertEquals(exhibition.getStartDate().toString(), record.getStartDate().toString());
        Assert.assertEquals(exhibition.getEndDate().toString(), record.getEndDate().toString());
        Assert.assertEquals(exhibition.getPlace(), record.getPlace());
        Assert.assertEquals(exhibition.getAwards(), record.getAwards());
        Assert.assertEquals(exhibition.getResume().getArtist().getId(), record.getResume().getArtist().getId());
    }

    /**
     * @generated
     */
    @Test
    public void getExhibitionsTest() {
        generateTestCase();
        List<ExhibitionEntity> list = exhibitionPersistence.findAll(null, null);
        Assert.assertEquals(exhibitions.size(), list.size());
        for (ExhibitionEntity ent : list) {
            boolean found = false;
            for (ExhibitionEntity entity : exhibitions) {
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
    public void getArtistTest() {
        generateTestCase();
        ExhibitionEntity exhibition = exhibitions.get(0);
        ExhibitionEntity record = exhibitionPersistence.find(exhibition.getId());
        Assert.assertEquals(exhibition.getName(), record.getName());
        Assert.assertEquals(exhibition.getDescription(), record.getDescription());
        Assert.assertEquals(exhibition.getKindOfEvent(), record.getKindOfEvent());
        Assert.assertEquals(exhibition.getPlace(), record.getPlace());
        Assert.assertEquals(exhibition.getAwards(), record.getAwards());
        Assert.assertEquals(exhibition.getResume().getArtist().getId(), record.getResume().getArtist().getId());
    }

    /**
     * @generated
     */
    @Test
    public void deleteExhibitionTest() {
        generateTestCase();
        ExhibitionEntity entity = exhibitions.get(0);
        exhibitionPersistence.delete(entity.getId());
        ExhibitionEntity deleted = em.find(ExhibitionEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateExhibitionTest() {
        generateTestCase();
        ExhibitionEntity entity = exhibitions.get(0);
        ExhibitionEntity newEntity = new ExhibitionEntity();
        newEntity.setId(entity.getId());
        newEntity.setName(generateRandom(String.class));
        exhibitionPersistence.update(newEntity);
        ExhibitionEntity resp = em.find(ExhibitionEntity.class, entity.getId());
        Assert.assertEquals(newEntity.getName(), resp.getName());
    }

    @Test
    public void listByResumeTest() {
        generateTestCase();
        List<ExhibitionEntity> list = exhibitionPersistence.listByResume(resume.getId());
        Assert.assertEquals(exhibitions.size(), list.size());
        for (ExhibitionEntity ent : list) {
            boolean found = false;
            for (ExhibitionEntity entity : exhibitions) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
        list = exhibitionPersistence.listByResume(generateRandom(Long.class));
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void getResumeByArtistIdTest() {
        generateTestCase();
        ResumeEntity result = exhibitionPersistence.getResumeByArtistId(artist.getId());
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getId(), resume.getId());
        Assert.assertEquals(result.getWebsite(), resume.getWebsite());
        Assert.assertEquals(result.getCity(), resume.getCity());
        Assert.assertEquals(result.getCountry(), resume.getCountry());
        Assert.assertEquals(result.getLastName(), resume.getLastName());
        Assert.assertEquals(result.getPhoto(), resume.getPhoto());
        Assert.assertEquals(result.getRatingSum(), resume.getRatingSum(), 0.001f);
        Assert.assertEquals(result.getRatingVotes(), resume.getRatingVotes(), 0.001f);
    }
}
