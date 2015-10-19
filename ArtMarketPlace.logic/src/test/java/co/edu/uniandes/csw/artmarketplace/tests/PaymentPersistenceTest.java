/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.entities.PaymentEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.PaymentPersistence;
import static co.edu.uniandes.csw.artmarketplace.tests._TestUtil.generateRandom;
import enums.PaymentTypeEnum;
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
 * @author ms.lancheros10
 */
@RunWith(Arquillian.class)
public class PaymentPersistenceTest {
    
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(PaymentEntity.class.getPackage())
                .addPackage(PaymentPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
     /**
     * @generated
     */
    @Inject
    private PaymentPersistence paymentPersistence;

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

    /**
     * @generated
     */
    private void clearData() {
        em.createQuery("delete from PaymentEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<PaymentEntity> data = new ArrayList<PaymentEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PaymentEntity entity = new PaymentEntity();
            entity.setMethod("1");
            entity.setPaymentType(PaymentTypeEnum.CREDIT_CARD);
            entity.setReference(generateRandom(String.class));
            entity.setSubtotal(generateRandom(Integer.class));
            entity.setTaxes(generateRandom(Integer.class));
            entity.setTotal(generateRandom(Integer.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createPaymentTest() {
        PaymentEntity newEntity = new PaymentEntity();
        newEntity.setMethod("1");
        newEntity.setPaymentType(PaymentTypeEnum.CREDIT_CARD);
        newEntity.setReference(generateRandom(String.class));
        newEntity.setSubtotal(generateRandom(Integer.class));
        newEntity.setTaxes(generateRandom(Integer.class));
        newEntity.setTotal(generateRandom(Integer.class));

        PaymentEntity result = paymentPersistence.create(newEntity);

        Assert.assertNotNull(result);

        PaymentEntity entity = em.find(PaymentEntity.class, result.getId());

        Assert.assertEquals(newEntity.getMethod(), entity.getMethod());
        Assert.assertEquals(newEntity.getPaymentType(), entity.getPaymentType());
        Assert.assertEquals(newEntity.getReference(), entity.getReference());
        Assert.assertEquals(newEntity.getSubtotal(), entity.getSubtotal());
        Assert.assertEquals(newEntity.getTaxes(), entity.getTaxes());
        Assert.assertEquals(newEntity.getTotal(), entity.getTotal());
    }
    
}
