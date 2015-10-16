package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ClientDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkRatingEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ClientEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.ArtworkPersistence;
import co.edu.uniandes.csw.artmarketplace.persistence.ArtworkRatingPersistence;
import co.edu.uniandes.csw.artmarketplace.persistence.ClientPersistence;
import static co.edu.uniandes.csw.artmarketplace.tests._TestUtil.generateRandom;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * ArtworkRatingPersistence es una la clase desiñada para hacer las pruebas de persistencia de
 * la calificación de las obras de arte.
 * @author lf.mendivelso10
 */
@RunWith(Arquillian.class)
public class ArtworkRatingPersistenceTest {

    /**
     * Obra de arte usada para referencia durante la prueba.
     */
    private ArtworkEntity artwork;

    /**
     * Cliente usado para referencia durante la prueba.
     */
    private ClientEntity client;
    
    /**
     * @generated
     */
    private List<ArtworkRatingEntity> data;
    
    /**
     * @generated
     */
    @Inject
    private ArtworkPersistence artworkPersistence;
    
    /**
     * @generated
     */
    @Inject
    private ClientPersistence clientPersistence;
    
    /**
     * @generated
     */
    @Inject
    private ArtworkRatingPersistence artworkRatingPersistence;

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
     * Definición de tipo de prueba
     */
    public static final String DEPLOY = "Prueba";
    
    final static Logger logger = Logger.getLogger(ArtworkRatingPersistenceTest.class);

    /**
     * @return 
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ArtworkDTO.class.getPackage())
                .addPackage(ClientDTO.class.getPackage())
                .addPackage(ArtworkEntity.class.getPackage())
                .addPackage(ArtworkRatingEntity.class.getPackage())
                .addPackage(ClientEntity.class.getPackage())
                .addPackage(ArtworkPersistence.class.getPackage())
                .addPackage(ArtworkRatingPersistence.class.getPackage())
                .addPackage(ClientPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

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
        } catch (NotSupportedException e) {
            logger.error(e);
            try {
                utx.rollback();
            } catch (IllegalStateException e1) {
                logger.error(e1);
            } catch (SecurityException e1) {
                logger.error(e1);
            } catch (SystemException e1) {
                logger.error(e1);
            }
        } catch (SystemException e) {
            logger.error(e);
            try {
                utx.rollback();
            } catch (IllegalStateException e1) {
                logger.error(e1);
            } catch (SecurityException e1) {
                logger.error(e1);
            } catch (SystemException e1) {
                logger.error(e1);
            }
        } catch (RollbackException e) {
            logger.error(e);
            try {
                utx.rollback();
            } catch (IllegalStateException e1) {
                logger.error(e1);
            } catch (SecurityException e1) {
                logger.error(e1);
            } catch (SystemException e1) {
                logger.error(e1);
            }
        } catch (HeuristicMixedException e) {
            logger.error(e);
            try {
                utx.rollback();
            } catch (IllegalStateException e1) {
                logger.error(e1);
            } catch (SecurityException e1) {
                logger.error(e1);
            } catch (SystemException e1) {
                logger.error(e1);
            }
        } catch (HeuristicRollbackException e) {
            logger.error(e);
            try {
                utx.rollback();
            } catch (IllegalStateException e1) {
                logger.error(e1);
            } catch (SecurityException e1) {
                logger.error(e1);
            } catch (SystemException e1) {
                logger.error(e1);
            }
        } catch (SecurityException e) {
            logger.error(e);
            try {
                utx.rollback();
            } catch (IllegalStateException e1) {
                logger.error(e1);
            } catch (SecurityException e1) {
                logger.error(e1);
            } catch (SystemException e1) {
                logger.error(e1);
            }
        } catch (IllegalStateException e) {
            logger.error(e);
            try {
                utx.rollback();
            } catch (IllegalStateException e1) {
                logger.error(e1);
            } catch (SecurityException e1) {
                logger.error(e1);
            } catch (SystemException e1) {
                logger.error(e1);
            }
        }
    }

    /**
     * @generated
     */
    private void clearData() {
        em.createQuery("delete from ArtworkRatingEntity").executeUpdate();
        em.createQuery("delete from ArtworkEntity").executeUpdate();
        em.createQuery("delete from ClientEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private void insertData() {
        client = new ClientEntity();
        client.setName(generateRandom(String.class));
        client.setUserId(generateRandom(String.class));
        clientPersistence.create(client);
        artwork = new ArtworkEntity();
        artwork.setName(generateRandom(String.class));
        artwork.setPicture(generateRandom(String.class));
        artwork.setPrice(generateRandom(Integer.class));
        artworkPersistence.create(artwork);
        data  = new ArrayList<ArtworkRatingEntity>();
        for (int i = 0; i < 3; i++) {
            ArtworkRatingEntity entity = new ArtworkRatingEntity();
            entity.setClient(client);
            entity.setArtwork(artwork);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createArtworkRatingTest() {
        ArtworkRatingEntity newEntity = new ArtworkRatingEntity();
        newEntity.setArtwork(artwork);
        newEntity.setClient(client);
        ArtworkRatingEntity result = artworkRatingPersistence.create(newEntity);
        Assert.assertNotNull(result);
        ArtworkRatingEntity entity = em.find(ArtworkRatingEntity.class, result.getId());
        Assert.assertEquals(newEntity.getArtwork().getId(), entity.getArtwork().getId());
        Assert.assertEquals(newEntity.getClient().getUserId(), entity.getClient().getUserId());
    }

    /**
     * @generated
     */
    @Test
    public void getArtworkRatingsTest() {
        List<ArtworkRatingEntity> list = artworkRatingPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (ArtworkRatingEntity ent : list) {
            boolean found = false;
            for (ArtworkRatingEntity entity : data) {
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
    public void getArtworkRatingTest() {
        ArtworkRatingEntity entity = data.get(0);
        ArtworkRatingEntity newEntity = artworkRatingPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getArtwork().getId(), entity.getArtwork().getId());
        Assert.assertEquals(newEntity.getClient().getUserId(), entity.getClient().getUserId());
    }

    /**
     * @generated
     */
    @Test
    public void deleteArtworkRatingTest() {
        ArtworkRatingEntity entity = data.get(0);
        artworkRatingPersistence.delete(entity.getId());
        ArtworkRatingEntity deleted = em.find(ArtworkRatingEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
}
