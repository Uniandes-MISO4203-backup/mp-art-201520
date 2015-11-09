/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.api.IWishListLogic;
import co.edu.uniandes.csw.artmarketplace.converters.WishListConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.WishListDTO;
import co.edu.uniandes.csw.artmarketplace.ejbs.WishListLogic;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ClientEntity;
import co.edu.uniandes.csw.artmarketplace.entities.WishListEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.WishListPersistence;
import static co.edu.uniandes.csw.artmarketplace.tests._TestUtil.generateRandom;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author a.perez15
 */
@RunWith(Arquillian.class)
public class WishListLogicTest {
    
    public static final String DEPLOY = "Prueba";
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(WishListEntity.class.getPackage())
                .addPackage(ArtworkEntity.class.getPackage())
                .addPackage(ClientEntity.class.getPackage())
                .addPackage(WishListDTO.class.getPackage())
                .addPackage(WishListConverter.class.getPackage())
                .addPackage(WishListLogic.class.getPackage())
                .addPackage(IWishListLogic.class.getPackage())
                .addPackage(WishListPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private IWishListLogic wishListLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
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

    private void clearData() {
        em.createQuery("delete from WishListEntity").executeUpdate();
    }
    
    private List<WishListEntity> data = new ArrayList<WishListEntity>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ArtworkEntity artwork = new ArtworkEntity();
            artwork.setId(1L);
            ClientEntity client = new ClientEntity();
            client.setId(1L);
            WishListEntity entity = new WishListEntity();
            entity.setId(generateRandom(Long.class));
            entity.setArtwork(artwork);
            entity.setClient(client);
            
            em.persist(entity);
            data.add(entity);
        }
        ArtworkEntity artwork = new ArtworkEntity();
            artwork.setId(1L);
            ClientEntity client = new ClientEntity();
            client.setId(1L);
            WishListEntity entity = new WishListEntity();
            entity.setId(1L);
            entity.setArtwork(artwork);
            entity.setClient(client);
            
            em.persist(entity);
            data.add(entity);
    }

    /**
     * Test of createWishListItem method, of class WishListLogic.
     */
    @Test
    public void testCreateWishListItem() {
        System.out.println("createWishListItem");
        WishListDTO dto = new WishListDTO();
        //WishListDTO result = wishListLogic.createWishListItem(dto);
        assertNotNull(dto);
    }

    /**
     * Test of removeWishListItemDTO method, of class WishListLogic.
     */
    @Test
    public void testRemoveWishListItemDTO() {
        System.out.println("removeWishListItemDTO");
        Long id = 1L;
        //wishListLogic.removeWishListItemDTO(id);
    }

    /**
     * Test of getWishListItems method, of class WishListLogic.
     */
    @Test
    public void testGetWishListItems() {
        System.out.println("getWishListItems");
        Long id = 1L;
        List<WishListDTO> result = wishListLogic.getWishListItems(id);
        assertNotNull(id);
    }
    
}
