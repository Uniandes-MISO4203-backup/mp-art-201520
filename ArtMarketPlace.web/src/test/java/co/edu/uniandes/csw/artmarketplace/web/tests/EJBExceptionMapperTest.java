/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.web.tests;

import co.edu.uniandes.csw.artmarketplace.providers.EJBExceptionMapper;
import javax.ejb.EJBException;
import javax.ws.rs.core.Response;
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
public class EJBExceptionMapperTest {
    
    public EJBExceptionMapperTest() {
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
     * Test of toResponse method, of class EJBExceptionMapper.
     */
    @Test
    public void testToResponse() {
        
        EJBException exception = new EJBException(new Exception(""));
        EJBExceptionMapper instance = new EJBExceptionMapper();
        
        Response result = instance.toResponse(exception);
        
        EJBException exception2 = new EJBException(new Exception(""));
        
        Response result2 = instance.toResponse(exception2);
        
        assertNotNull(exception);
        assertNotNull(exception2);
    }
    
}
