/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.converters.PaymentConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.PaymentDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ClientEntity;
import co.edu.uniandes.csw.artmarketplace.entities.PaymentEntity;
import java.util.ArrayList;
import java.util.List;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author a.perez15
 */
@RunWith(Arquillian.class)
public class PaymentConverterTest {
    
    public PaymentConverterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of refEntity2DTO method, of class PaymentConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        PaymentEntity entity = null;
        PaymentDTO result = PaymentConverter.refEntity2DTO(entity);
        assertNull(entity);
        
        entity = new PaymentEntity();
        result = PaymentConverter.refEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class PaymentConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        PaymentDTO dto = null;
        PaymentEntity result = PaymentConverter.refDTO2Entity(dto);
        assertNull(dto);
        
        dto = new PaymentDTO();
        result = PaymentConverter.refDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of fullEntity2DTO method, of class PaymentConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        PaymentEntity entity = null;
        PaymentDTO result = PaymentConverter.fullEntity2DTO(entity);
        assertNull(entity);
        
        entity = new PaymentEntity();
        result = PaymentConverter.fullEntity2DTO(entity);
        assertNotNull(entity);
        
    }

    /**
     * Test of fullDTO2Entity method, of class PaymentConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        PaymentDTO dto = null;
        PaymentEntity result = PaymentConverter.fullDTO2Entity(dto);
        assertNull(dto);
        
        dto = new PaymentDTO();
        result = PaymentConverter.fullDTO2Entity(dto);
        assertNotNull(dto);
        
    }

    /**
     * Test of listEntity2DTO method, of class PaymentConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<PaymentEntity> entities = null;
        List<PaymentDTO> result = PaymentConverter.listEntity2DTO(entities);
        assertNull(entities);
        
        entities = new ArrayList<PaymentEntity>();
        entities.add(new PaymentEntity());
        result = PaymentConverter.listEntity2DTO(entities);
        assertNotNull(entities);
    }

    /**
     * Test of listDTO2Entity method, of class PaymentConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<PaymentDTO> dtos = null;
        List<PaymentEntity> result = PaymentConverter.listDTO2Entity(dtos);
        assertNull(dtos);
        
        dtos = new ArrayList<PaymentDTO>();
        dtos.add( new PaymentDTO());
        result = PaymentConverter.listDTO2Entity(dtos);
        assertNotNull(dtos);
    }

    /**
     * Test of childDTO2Entity method, of class PaymentConverter.
     */
    @Test
    public void testChildDTO2Entity() {
        System.out.println("childDTO2Entity");
        PaymentDTO dto = new PaymentDTO();
        ClientEntity parent = new ClientEntity();
        PaymentEntity result = PaymentConverter.childDTO2Entity(dto, parent);
        assertNotNull(dto);
    }

    /**
     * Test of childListDTO2Entity method, of class PaymentConverter.
     */
    @Test
    public void testChildListDTO2Entity() {
        System.out.println("childListDTO2Entity");
        List<PaymentDTO> dtos = null;
        ClientEntity parent = new ClientEntity();
        List<PaymentEntity> result = PaymentConverter.childListDTO2Entity(dtos, parent);
        assertNull(dtos);
        
        dtos = new ArrayList<PaymentDTO>();
        dtos.add(new PaymentDTO());
        result = PaymentConverter.childListDTO2Entity(dtos, parent);
        assertNotNull(dtos);
    }
    
}
