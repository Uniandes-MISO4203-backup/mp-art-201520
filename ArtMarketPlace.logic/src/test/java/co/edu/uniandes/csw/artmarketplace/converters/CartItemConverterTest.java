/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.converters;

import co.edu.uniandes.csw.artmarketplace.dtos.CartItemDTO;
import co.edu.uniandes.csw.artmarketplace.entities.CartItemEntity;
import co.edu.uniandes.csw.artmarketplace.entities.ClientEntity;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author a.perez15
 */
public class CartItemConverterTest {
    
    public CartItemConverterTest() {
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
     * Test of refEntity2DTO method, of class CartItemConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        CartItemEntity entity = new CartItemEntity();
        entity.setId(1L);
        entity.setName("alejo");
        entity.setQuantity(1);
        entity.setState("ok");
        
        CartItemDTO result = CartItemConverter.refEntity2DTO(entity);
        assertEquals(entity.getId(), result.getId());
        assertEquals(entity.getName(), result.getName());
        assertEquals(entity.getQuantity(), result.getQuantity());
        assertEquals(entity.getState(), result.getState());
    }

    /**
     * Test of refDTO2Entity method, of class CartItemConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        CartItemDTO cartItemDTO = new CartItemDTO();
        cartItemDTO.setId(1L);
        cartItemDTO.setName("alejo");
        cartItemDTO.setQuantity(1);
        cartItemDTO.setState("ok");
        
        CartItemEntity entity = CartItemConverter.refDTO2Entity(cartItemDTO);
        assertEquals(entity.getId(), cartItemDTO.getId());
    }

    /**
     * Test of fullEntity2DTO method, of class CartItemConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        CartItemEntity entity = new CartItemEntity();
        entity.setId(1L);
        entity.setName("alejo");
        entity.setQuantity(1);
        entity.setState("ok");
        
        CartItemDTO result = CartItemConverter.fullEntity2DTO(entity);
        assertEquals(entity.getId(), result.getId());
        assertEquals(entity.getName(), result.getName());
        assertEquals(entity.getQuantity(), result.getQuantity());
        assertEquals(entity.getState(), result.getState());
    }

    /**
     * Test of fullDTO2Entity method, of class CartItemConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        CartItemDTO cartItemDTO = new CartItemDTO();
        cartItemDTO.setId(1L);
        cartItemDTO.setName("alejo");
        cartItemDTO.setQuantity(1);
        cartItemDTO.setState("ok");
        
        CartItemEntity entity = CartItemConverter.fullDTO2Entity(cartItemDTO);
        assertEquals(entity.getId(), cartItemDTO.getId());
        assertEquals(entity.getName(), cartItemDTO.getName());
        assertEquals(entity.getQuantity(), cartItemDTO.getQuantity());
        assertEquals(entity.getState(), cartItemDTO.getState());
    }

    /**
     * Test of listEntity2DTO method, of class CartItemConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        
        CartItemEntity entity = new CartItemEntity();
        entity.setId(1L);
        entity.setName("alejo");
        entity.setQuantity(1);
        entity.setState("ok");
        
        List<CartItemEntity> entities = new ArrayList<CartItemEntity>();
        entities.add(entity);
        
        List<CartItemDTO> result = CartItemConverter.listEntity2DTO(entities);
        assertNotNull(result);
    }

    /**
     * Test of listDTO2Entity method, of class CartItemConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        CartItemDTO dto = new CartItemDTO();
        dto.setId(1L);
        dto.setName("alejo");
        dto.setQuantity(1);
        dto.setState("ok");
        
        List<CartItemDTO> dtos = new ArrayList<CartItemDTO>();
        dtos.add(dto);
        
        List<CartItemEntity> result = CartItemConverter.listDTO2Entity(dtos);
        assertNotNull(result);
    }

    /**
     * Test of childDTO2Entity method, of class CartItemConverter.
     */
    @Test
    public void testChildDTO2Entity() {
        System.out.println("childDTO2Entity");
        CartItemDTO dto = new CartItemDTO();
        dto.setId(1L);
        dto.setName("alejo");
        dto.setQuantity(1);
        dto.setState("ok");
        
        CartItemEntity result = CartItemConverter.childDTO2Entity(dto, new ClientEntity());
        assertNotNull(result);
        
    }

    /**
     * Test of childListDTO2Entity method, of class CartItemConverter.
     */
    @Test
    public void testChildListDTO2Entity() {
        System.out.println("childListDTO2Entity");
        
        CartItemDTO dto = new CartItemDTO();
        dto.setId(1L);
        dto.setName("alejo");
        dto.setQuantity(1);
        dto.setState("ok");
        
        List<CartItemDTO> lista = new ArrayList<CartItemDTO>();
        lista.add(dto);
        
        List<CartItemEntity> result = CartItemConverter.childListDTO2Entity(lista, new ClientEntity());
        assertNotNull(result);
    }
    
}
