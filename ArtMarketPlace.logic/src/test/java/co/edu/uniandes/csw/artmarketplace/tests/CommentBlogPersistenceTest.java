/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.entities.CommentBlogEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.CommentBlogPersistence;
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
public class CommentBlogPersistenceTest {
    public static final String DEPLOY = "Prueba";
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(CommentBlogEntity.class.getPackage())
                .addPackage(CommentBlogPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private CommentBlogPersistence commentBlogPersistence;

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
        em.createQuery("delete from CommentBlogEntity").executeUpdate();
    }
    
    private List<CommentBlogEntity> data = new ArrayList<CommentBlogEntity>();
    
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            CommentBlogEntity entity = new CommentBlogEntity();
            entity.setClientId(Long.MAX_VALUE);
            entity.setBlogId(Long.MIN_VALUE);
            entity.setComment(generateRandom(String.class));
            entity.setCommentUser(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
    public void createCommentBlogTest() {
        CommentBlogEntity newEntity = new CommentBlogEntity();
        newEntity.setClientId(Long.MIN_VALUE);
        newEntity.setBlogId(Long.MIN_VALUE);
        newEntity.setComment(generateRandom(String.class));
        newEntity.setCommentUser(generateRandom(String.class));
        CommentBlogEntity result = commentBlogPersistence.create(newEntity);
        Assert.assertNotNull(result);
        CommentBlogEntity entity = em.find(CommentBlogEntity.class, result.getId());
        Assert.assertEquals(newEntity.getClientId(), entity.getClientId());
        Assert.assertEquals(newEntity.getBlogId(), entity.getBlogId());
        Assert.assertEquals(newEntity.getComment(), entity.getComment());
        Assert.assertEquals(newEntity.getCommentUser(), entity.getCommentUser());
    }
    
    @Test
    public void getAllCommentBlog() {
        List<CommentBlogEntity> list = commentBlogPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (CommentBlogEntity ent : list) {
            boolean found = false;
            for (CommentBlogEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getCommentBlog() {
        Long idBlog = data.get(0).getBlogId();
        List<CommentBlogEntity> cache = new ArrayList<CommentBlogEntity>();
        List<CommentBlogEntity> list = commentBlogPersistence.getCommentBlog(idBlog);
        for (CommentBlogEntity entity : data) {
            if (entity.getBlogId().equals(idBlog)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(list.size(), cache.size());
        for (CommentBlogEntity ent : list) {
            boolean found = false;
            for (CommentBlogEntity cacheEntity : cache) {
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
