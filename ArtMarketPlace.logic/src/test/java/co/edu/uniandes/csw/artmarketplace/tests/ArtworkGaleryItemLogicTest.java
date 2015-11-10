/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.converters.ArtworkConverter;
import co.edu.uniandes.csw.artmarketplace.converters.ArtworkGaleryItemConverter;
import co.edu.uniandes.csw.artmarketplace.converters.TypeConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkGaleryItemDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.TypeDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkGaleryItemEntity;
import co.edu.uniandes.csw.artmarketplace.entities.TypeEntity;
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
 * La pruebas ArtworkGaleryItemLogicTest esta disenada exclusivamente para hacer
 * las pruebas relacionadas con la lógica de la galería
 *
 * @author jd.garcia1381
 */
@RunWith(Arquillian.class)
public class ArtworkGaleryItemLogicTest {

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

    private ArtworkGaleryItemEntity artworkGaleryItem;

    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ArtworkEntity.class.getPackage())
                .addPackage(ArtworkDTO.class.getPackage())
                .addPackage(ArtworkConverter.class.getPackage())
                .addPackage(ArtworkGaleryItemEntity.class.getPackage())
                .addPackage(ArtworkGaleryItemDTO.class.getPackage())
                .addPackage(ArtworkGaleryItemConverter.class.getPackage())
                .addPackage(TypeEntity.class.getPackage())
                .addPackage(TypeDTO.class.getPackage())
                .addPackage(TypeConverter.class.getPackage())
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
        em.createQuery("delete from ArtworkGaleryItemEntity").executeUpdate();
        em.createQuery("delete from ArtworkEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private void insertData() {
        ArtworkEntity entity = new ArtworkEntity();
        entity.setName(generateRandom(String.class));
        entity.setPrice(generateRandom(Integer.class));
        em.persist(entity);

        TypeEntity type = new TypeEntity();
        type.setName("photo");
        em.persist(type);

        artworkGaleryItem = new ArtworkGaleryItemEntity();
        artworkGaleryItem.setLink(generateRandom(String.class));
        artworkGaleryItem.setType(type);
        artworkGaleryItem.setArtwork(entity);
        em.persist(artworkGaleryItem);
    }

    @Test
    public void createArtworkGaleryItemTest() {
        ArtworkDTO artworkDTO = ArtworkConverter.basicEntity2DTO(artworkGaleryItem.getArtwork());
        TypeDTO typeDTO = TypeConverter.refEntity2DTO(artworkGaleryItem.getType());

        ArtworkGaleryItemDTO dto = new ArtworkGaleryItemDTO();
        dto.setId(artworkGaleryItem.getId());
        dto.setLink(artworkGaleryItem.getLink());
        dto.setType(typeDTO);
        dto.setArtwork(artworkDTO);

        Assert.assertEquals(dto.getId(), artworkGaleryItem.getId());
        Assert.assertEquals(dto.getLink(), artworkGaleryItem.getLink());
        Assert.assertEquals(dto.getType(), typeDTO);
        Assert.assertEquals(dto.getArtwork(), artworkDTO);
    }
}
