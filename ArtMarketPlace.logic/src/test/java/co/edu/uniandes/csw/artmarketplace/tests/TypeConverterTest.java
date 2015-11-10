/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.converters.TypeConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.TypeDTO;
import co.edu.uniandes.csw.artmarketplace.entities.TypeEntity;
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
 * @author jd.garcia1381
 */
@RunWith(Arquillian.class)
public class TypeConverterTest {

    public TypeConverterTest() {
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
     * Test of refEntity2DTO method, of class TypeConverter.
     */
    @Test
    public void testRefEntity2DTO() {
        System.out.println("refEntity2DTO");
        TypeEntity entity = null;
        TypeDTO result = TypeConverter.refEntity2DTO(entity);
        assertNull(entity);

        entity = new TypeEntity();
        result = TypeConverter.refEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of refDTO2Entity method, of class TypeConverter.
     */
    @Test
    public void testRefDTO2Entity() {
        System.out.println("refDTO2Entity");
        TypeDTO dto = null;
        TypeEntity result = TypeConverter.refDTO2Entity(dto);
        assertNull(dto);

        dto = new TypeDTO();
        result = TypeConverter.refDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of basicEntity2DTO method, of class TypeConverter.
     */
    @Test
    public void testBasicEntity2DTO() {
        System.out.println("basicEntity2DTO");
        TypeEntity entity = null;
        TypeDTO result = TypeConverter.basicEntity2DTO(entity);
        assertNull(entity);

        entity = new TypeEntity();
        result = TypeConverter.basicEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of basicDTO2Entity method, of class TypeConverter.
     */
    @Test
    public void testBasicDTO2Entity() {
        System.out.println("basicDTO2Entity");
        TypeDTO dto = null;
        TypeEntity result = TypeConverter.basicDTO2Entity(dto);
        assertNull(dto);

        dto = new TypeDTO();
        result = TypeConverter.basicDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of fullEntity2DTO method, of class TypeConverter.
     */
    @Test
    public void testFullEntity2DTO() {
        System.out.println("fullEntity2DTO");
        TypeEntity entity = null;
        TypeDTO result = TypeConverter.fullEntity2DTO(entity);
        assertNull(entity);

        entity = new TypeEntity();
        result = TypeConverter.fullEntity2DTO(entity);
        assertNotNull(entity);
    }

    /**
     * Test of fullDTO2Entity method, of class TypeConverter.
     */
    @Test
    public void testFullDTO2Entity() {
        System.out.println("fullDTO2Entity");
        TypeDTO dto = null;
        TypeEntity result = TypeConverter.fullDTO2Entity(dto);
        assertNull(dto);

        dto = new TypeDTO();
        result = TypeConverter.fullDTO2Entity(dto);
        assertNotNull(dto);
    }

    /**
     * Test of listEntity2DTO method, of class TypeConverter.
     */
    @Test
    public void testListEntity2DTO() {
        System.out.println("listEntity2DTO");
        List<TypeEntity> entities = null;
        List<TypeDTO> result = TypeConverter.listEntity2DTO(entities);
        assertNull(entities);

        entities = new ArrayList<TypeEntity>();
        entities.add(new TypeEntity());
        result = TypeConverter.listEntity2DTO(entities);
        assertNotNull(entities);
    }

    /**
     * Test of listDTO2Entity method, of class TypeConverter.
     */
    @Test
    public void testListDTO2Entity() {
        System.out.println("listDTO2Entity");
        List<TypeDTO> dtos = null;
        List<TypeEntity> result = TypeConverter.listDTO2Entity(dtos);
        assertNull(dtos);

        dtos = new ArrayList<TypeDTO>();
        dtos.add(new TypeDTO());
        result = TypeConverter.listDTO2Entity(dtos);
        assertNotNull(dtos);
    }
}
