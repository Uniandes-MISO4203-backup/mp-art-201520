/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.web.tests;

import co.edu.uniandes.csw.artmarketplace.providers.CreatedFilter;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
public class CreatedFilterTest {
    
    public CreatedFilterTest() {
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
     * Test of filter method, of class CreatedFilter.
     */
    @Test
    public void testFilter() throws Exception {
        ContainerRequestContext req = null ;
        ContainerResponseContext resp = new ContainerResponseContext() {

            @Override
            public int getStatus() {
                return HttpServletResponse.SC_OK;
            }

            @Override
            public void setStatus(int code) {
                
            }

            @Override
            public Response.StatusType getStatusInfo() {
                return null;
            }

            @Override
            public void setStatusInfo(Response.StatusType statusInfo) {
                
            }

            @Override
            public MultivaluedMap<String, Object> getHeaders() {
                return null;
            }

            @Override
            public MultivaluedMap<String, String> getStringHeaders() {
                return null;
            }

            @Override
            public String getHeaderString(String name) {
                return "";
            }

            @Override
            public Set<String> getAllowedMethods() {
                return null;
            }

            @Override
            public Date getDate() {
                return null;
            }

            @Override
            public Locale getLanguage() {
                return null;
            }

            @Override
            public int getLength() {
                return 0;
            }

            @Override
            public MediaType getMediaType() {
                return null;
            }

            @Override
            public Map<String, NewCookie> getCookies() {
                return null;
            }

            @Override
            public EntityTag getEntityTag() {
                return null;
            }

            @Override
            public Date getLastModified() {
                return null;
            }

            @Override
            public URI getLocation() {
                return null;
            }

            @Override
            public Set<Link> getLinks() {
                return null;
            }

            @Override
            public boolean hasLink(String relation) {
                return true;
            }

            @Override
            public Link getLink(String relation) {
                return null;
            }

            @Override
            public Link.Builder getLinkBuilder(String relation) {
                return null;
            }

            @Override
            public boolean hasEntity() {
                return true;
            }

            @Override
            public Object getEntity() {
                return null;
            }

            @Override
            public Class<?> getEntityClass() {
                return null;
            }

            @Override
            public Type getEntityType() {
                return null;
            }

            @Override
            public void setEntity(Object entity) {
                
            }

            @Override
            public void setEntity(Object entity, Annotation[] annotations, MediaType mediaType) {
                
            }

            @Override
            public Annotation[] getEntityAnnotations() {
                return null;
            }

            @Override
            public OutputStream getEntityStream() {
                return null;
            }

            @Override
            public void setEntityStream(OutputStream outputStream) {
            }
        };
        CreatedFilter instance = new CreatedFilter();
        instance.filter(req, resp);
        
        Assert.assertEquals(HttpServletResponse.SC_OK, resp.getStatus());
    }
    
}
