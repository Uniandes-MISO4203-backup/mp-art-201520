/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.api.IBlogLogic;
import co.edu.uniandes.csw.artmarketplace.converters.BlogConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.BlogDTO;
import co.edu.uniandes.csw.artmarketplace.ejbs.BlogLogic;
import co.edu.uniandes.csw.artmarketplace.entities.BlogEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.BlogPersistence;
import static co.edu.uniandes.csw.artmarketplace.tests._TestUtil.generateRandom;
import java.util.ArrayList;
import java.util.Calendar;
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
public class BlogLogicTest {
    public static final String DEPLOY = "Prueba";
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(BlogEntity.class.getPackage())
                .addPackage(BlogDTO.class.getPackage())
                .addPackage(BlogConverter.class.getPackage())
                .addPackage(BlogLogic.class.getPackage())
                .addPackage(IBlogLogic.class.getPackage())
                .addPackage(BlogPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private IBlogLogic blogLogic;
    
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
        em.createQuery("delete from BlogEntity").executeUpdate();
    }
    
    private List<BlogEntity> data = new ArrayList<BlogEntity>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            BlogEntity entity = new BlogEntity();
            entity.setClientId(Long.MIN_VALUE);
            entity.setEntry(generateRandom(String.class));
            entity.setTitle(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
    public void createBlogTest() {
        BlogDTO dto = new BlogDTO();
        dto.setEntry(generateRandom(String.class));
        dto.setTitle(generateRandom(String.class));
        BlogDTO result = blogLogic.createEntry(dto);
        Assert.assertNotNull(result);
        BlogEntity entity = em.find(BlogEntity.class, result.getId());
        Assert.assertEquals(dto.getEntry(), entity.getEntry());
        Assert.assertEquals(dto.getTitle(), entity.getTitle());
        entity.setDateEntry(Calendar.getInstance());
    }
    
    @Test
    public void getEntrysTest() {
        List<BlogDTO> list = blogLogic.getEntrys(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (BlogDTO dto : list) {
            boolean found = false;
            for (BlogEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getEntryTest() {
        BlogEntity entity = data.get(0);
        BlogDTO dto = blogLogic.getEntry(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getEntry(), dto.getEntry());
        Assert.assertEquals(entity.getTitle(), dto.getTitle());
    }
    
    @Test
    public void getEntryArtist() {
        Long idArtist = data.get(0).getClientId();
        List<BlogEntity> cache = new ArrayList<BlogEntity>();
        List<BlogDTO> list = blogLogic.getEntryArtist(idArtist);
        for (BlogEntity entity : data) {
            if (entity.getClientId().equals(idArtist)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(list.size(), cache.size());
        for (BlogDTO dto : list) {
            boolean found = false;
            for (BlogEntity cacheEntity : cache) {
                if (cacheEntity.getClientId().equals(dto.getClientId())) {
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
