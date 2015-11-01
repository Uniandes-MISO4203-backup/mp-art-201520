/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.api.IPaymentLogic;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.PaymentDTO;
import co.edu.uniandes.csw.artmarketplace.ejbs.PaymentLogic;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
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
public class PaymentLogicTest {
    
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(PaymentEntity.class.getPackage())
                .addPackage(PaymentPersistence.class.getPackage())
                .addPackage(IPaymentLogic.class.getPackage())
                .addPackage(PaymentLogic.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * @generated
     */
    @Inject
    private IPaymentLogic paymentLogic;

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
        PaymentDTO dto = new PaymentDTO();
        dto.setMethod("1");
        dto.setPaymentType(PaymentTypeEnum.CREDIT_CARD);
        dto.setReference(generateRandom(String.class));
        dto.setSubtotal(generateRandom(Integer.class));
        dto.setTaxes(generateRandom(Integer.class));
        dto.setTotal(generateRandom(Integer.class));

        PaymentDTO result = paymentLogic.createPayment(dto);

        Assert.assertNotNull(result);

        PaymentEntity entity = em.find(PaymentEntity.class, result.getId());

        Assert.assertEquals(dto.getMethod(), entity.getMethod());
        Assert.assertEquals(dto.getPaymentType(), entity.getPaymentType());
        Assert.assertEquals(dto.getReference(), entity.getReference());
        Assert.assertEquals(dto.getSubtotal(), entity.getSubtotal());
        Assert.assertEquals(dto.getTaxes(), entity.getTaxes());
        Assert.assertEquals(dto.getTotal(), entity.getTotal());
    }
    
     /**
     * @generated
     */
    @Test
    public void getPaymentPaginationTest() {
        //Page 1
        List<PaymentDTO> dto1 = paymentLogic.getPayments(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<PaymentDTO> dto2 = paymentLogic.getPayments(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (PaymentDTO dto : dto1) {
            boolean found = false;
            for (PaymentEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (PaymentDTO dto : dto2) {
            boolean found = false;
            for (PaymentEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
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
    public void getPaymentsTest() {
        List<PaymentDTO> list = paymentLogic.getPayments(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (PaymentDTO dto : list) {
            boolean found = false;
            for (PaymentEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
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
    public void getPaymentTest() {
        PaymentEntity entity = data.get(0);
        PaymentDTO dto = paymentLogic.getPayment(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getMethod(), dto.getMethod());
        Assert.assertEquals(entity.getPaymentType(), dto.getPaymentType());
        Assert.assertEquals(entity.getReference(), dto.getReference());
        Assert.assertEquals(entity.getSubtotal(), dto.getSubtotal());
        Assert.assertEquals(entity.getTaxes(), dto.getTaxes());
        Assert.assertEquals(entity.getTotal(), dto.getTotal());
    }
    
    /**
     * @generated
     */
    @Test
    public void deletePaymentTest() {
        PaymentEntity entity = data.get(0);
        paymentLogic.deletePayment(entity.getId());
        PaymentEntity deleted = em.find(PaymentEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * @generated
     */
    @Test
    public void updatePaymentTest() {
        PaymentEntity entity = data.get(0);

        PaymentDTO dto = new PaymentDTO();

        dto.setId(entity.getId());
        dto.setMethod(generateRandom(String.class));
        dto.setSubtotal(generateRandom(Integer.class));
        dto.setTaxes(generateRandom(Integer.class));
        dto.setTotal(generateRandom(Integer.class));

        paymentLogic.updatePayment(dto);

        PaymentEntity resp = em.find(PaymentEntity.class, entity.getId());

        Assert.assertEquals(dto.getMethod(), resp.getMethod());
        Assert.assertEquals(dto.getSubtotal(), resp.getSubtotal());
        Assert.assertEquals(dto.getTaxes(), resp.getTaxes());
        Assert.assertEquals(dto.getTotal(), resp.getTotal());
    }

}
