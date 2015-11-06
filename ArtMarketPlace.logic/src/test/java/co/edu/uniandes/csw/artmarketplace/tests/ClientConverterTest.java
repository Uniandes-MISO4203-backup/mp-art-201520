/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.converters.ClientConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ClientDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ClientEntity;
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
public class ClientConverterTest {
    
    public ClientConverterTest() {
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
     * Test of refEntity2DTO method, of class ClientConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        ClientEntity entity = null;
        ClientDTO result = ClientConverter.refEntity2DTO(entity);
        assertNull(entity);
        
        entity = new ClientEntity();
        result = ClientConverter.refEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class ClientConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        ClientDTO dto = null;
        ClientEntity result = ClientConverter.refDTO2Entity(dto);
        assertNull(dto);
        
        dto = new ClientDTO();
        result = ClientConverter.refDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of fullEntity2DTO method, of class ClientConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        ClientEntity entity = null;
        ClientDTO result = ClientConverter.fullEntity2DTO(entity);
        assertNull(entity);
        
        entity = new ClientEntity();
        result = ClientConverter.fullEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of fullDTO2Entity method, of class ClientConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        ClientDTO dto = null;
        ClientEntity result = ClientConverter.fullDTO2Entity(dto);
        assertNull(dto);
        
        dto = new ClientDTO();
        result = ClientConverter.fullDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of listEntity2DTO method, of class ClientConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<ClientEntity> entities = null;
        List<ClientDTO> result = ClientConverter.listEntity2DTO(entities);
        assertNull(entities);
        
        entities = new ArrayList<ClientEntity>();
        entities.add(new ClientEntity());
        result = ClientConverter.listEntity2DTO(entities);
        assertNotNull(entities);
    }

    /**
     * Test of listDTO2Entity method, of class ClientConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<ClientDTO> dtos = null;
        List<ClientEntity> result = ClientConverter.listDTO2Entity(dtos);
        assertNull(dtos);
        
        dtos = new ArrayList<ClientDTO>();
        dtos.add(new ClientDTO());
        result = ClientConverter.listDTO2Entity(dtos);
        assertNotNull(dtos);
    }
    
}
