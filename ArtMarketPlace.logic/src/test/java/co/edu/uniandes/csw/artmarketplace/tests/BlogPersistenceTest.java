/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.entities.BlogEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.BlogPersistence;
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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author jh.rubiano10
 */
@RunWith(Arquillian.class)
public class BlogPersistenceTest {
    
    public static final String DEPLOY = "Prueba";
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(BlogEntity.class.getPackage())
                .addPackage(BlogPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private BlogPersistence blogPersistence;

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
        em.createQuery("delete from BlogEntity").executeUpdate();
    }
    
    private List<BlogEntity> data = new ArrayList<BlogEntity>();
    
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            BlogEntity entity = new BlogEntity();
            entity.setClientId(Long.MAX_VALUE);
            entity.setEntry(generateRandom(String.class));
            entity.setTitle(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
    public void createBlogTest() {
        BlogEntity newEntity = new BlogEntity();
        newEntity.setEntry(generateRandom(String.class));
        newEntity.setTitle(generateRandom(String.class));
        BlogEntity result = blogPersistence.create(newEntity);     
        Assert.assertNotNull(result);
        BlogEntity entity = em.find(BlogEntity.class, result.getId());
        Assert.assertEquals(newEntity.getEntry(), entity.getEntry());
        Assert.assertEquals(newEntity.getTitle(), entity.getTitle());
    }
    
    @Test
    public void getEntrysTest() {
        List<BlogEntity> list = blogPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (BlogEntity ent : list) {
            boolean found = false;
            for (BlogEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getEntryTest() {
        BlogEntity entity = data.get(0);
        BlogEntity newEntity = blogPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getEntry(), newEntity.getEntry());
        Assert.assertEquals(entity.getTitle(), newEntity.getTitle());
    }
    
    @Test
    public void getEntryArtist() {
        Long idArtist = data.get(0).getClientId();
        List<BlogEntity> cache = new ArrayList<BlogEntity>();
        List<BlogEntity> list = blogPersistence.getEntryArtist(idArtist);
        for (BlogEntity entity : data) {
            if (entity.getClientId().equals(idArtist)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(list.size(), cache.size());
        for (BlogEntity ent : list) {
            boolean found = false;
            for (BlogEntity cacheEntity : cache) {
                if (cacheEntity.getClientId().equals(ent.getClientId())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                Assert.fail();
            }
        }
    }
}