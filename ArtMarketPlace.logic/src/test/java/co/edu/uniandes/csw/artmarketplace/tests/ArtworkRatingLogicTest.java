/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.api.IArtworkLogic;
import co.edu.uniandes.csw.artmarketplace.api.IClientLogic;
import co.edu.uniandes.csw.artmarketplace.converters.ArtworkConverter;
import co.edu.uniandes.csw.artmarketplace.converters.ArtworkRatingConverter;
import co.edu.uniandes.csw.artmarketplace.converters.ClientConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkRatingDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ClientDTO;
import co.edu.uniandes.csw.artmarketplace.ejbs.ArtworkLogic;
import co.edu.uniandes.csw.artmarketplace.ejbs.ClientLogic;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkRatingEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ClientEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.ArtworkPersistence;
import co.edu.uniandes.csw.artmarketplace.persistence.ArtworkRatingPersistence;
import co.edu.uniandes.csw.artmarketplace.persistence.ClientPersistence;
import static co.edu.uniandes.csw.artmarketplace.tests._TestUtil.generateRandom;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * La pruebas ArtworkRatingLogicTest esta disenada exclusivamente para hacer las
 * pruebas relacionadas con la logica de la calificacion de obras de arte.
 *
 * @author lf.mendivelso10
 */
@RunWith(Arquillian.class)
public class ArtworkRatingLogicTest {

    /**
     * @generated
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    @Inject
    private IArtworkLogic artworkLogic;

    /**
     * @generated
     */
    @Inject
    private IClientLogic clientLogic;

    /**
     * @generated
     */
    @Inject
    UserTransaction utx;

    /**
     * Obra de arte usada para referencia durante la prueba.
     */
    private ArtworkEntity artwork;

    /**
     * Cliente usado para referencia durante la prueba.
     */
    private ClientDTO client;

    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ClientEntity.class.getPackage())
                .addPackage(ClientDTO.class.getPackage())
                .addPackage(ClientConverter.class.getPackage())
                .addPackage(ClientLogic.class.getPackage())
                .addPackage(IClientLogic.class.getPackage())
                .addPackage(ClientPersistence.class.getPackage())
                .addPackage(ArtworkRatingEntity.class.getPackage())
                .addPackage(ArtworkRatingDTO.class.getPackage())
                .addPackage(ArtworkRatingConverter.class.getPackage())
                .addPackage(ArtworkEntity.class.getPackage())
                .addPackage(ArtworkDTO.class.getPackage())
                .addPackage(ArtworkConverter.class.getPackage())
                .addPackage(ArtworkLogic.class.getPackage())
                .addPackage(IArtworkLogic.class.getPackage())
                .addPackage(ArtworkPersistence.class.getPackage())
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
        em.createQuery("delete from ArtworkRatingEntity").executeUpdate();
        em.createQuery("delete from ArtworkEntity").executeUpdate();
        em.createQuery("delete form ClientEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private void insertData() {
        client = new ClientDTO();
        client.setName(generateRandom(String.class));
        client.setUserId(generateRandom(String.class));
        client = clientLogic.createClient(client);

        artwork = new ArtworkEntity();
        artwork.setName(generateRandom(String.class));
        artwork.setPicture(generateRandom(String.class));
        artwork.setPrice(generateRandom(Integer.class));
        artwork = ArtworkConverter.fullDTO2Entity(artworkLogic.createArtwork(ArtworkConverter.fullEntity2DTO(artwork)));
    }

    @Test
    public void ratingResume() {
        insertData();
        Float rating1 = (float) (1 + (int) (Math.random() * 5));
        Float rating2 = (float) (1 + (int) (Math.random() * 5));
        // Sin ninguna votacion.
        Assert.assertEquals(0.0000f, artworkLogic.getRatingArtwork(artwork.getId()), 0.0002f);
        // Primera calificacion
        artworkLogic.rateArtwork(artwork.getId(), client, rating1);
        // Validacion de la primera calificacion 
        Assert.assertEquals(rating1, artworkLogic.getRatingArtwork(artwork.getId()), 0.0002f);
        // Segunda calificacion
        artworkLogic.rateArtwork(artwork.getId(), client, rating2);
        // Validacion de no repeticion
        Assert.assertEquals(rating1, artworkLogic.getRatingArtwork(artwork.getId()), 0.0002f);

    }
}
