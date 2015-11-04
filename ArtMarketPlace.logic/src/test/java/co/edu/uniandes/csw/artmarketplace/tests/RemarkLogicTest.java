/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import co.edu.uniandes.csw.artmarketplace.api.IRemarkLogic;
import co.edu.uniandes.csw.artmarketplace.dtos.RemarkDTO;
import co.edu.uniandes.csw.artmarketplace.ejbs.RemarkLogic;
import co.edu.uniandes.csw.artmarketplace.entities.RemarkEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.RemarkPersistence;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author a.perez15
 */
@RunWith(Arquillian.class)
public class RemarkLogicTest {
    
    public RemarkLogicTest() {
    }
    
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(RemarkEntity.class.getPackage())
                .addPackage(RemarkPersistence.class.getPackage())
                .addPackage(IRemarkLogic.class.getPackage())
                .addPackage(RemarkLogic.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
   /**
     * @generated
     */
    @Inject
    private IRemarkLogic remarkLogic;

    /**
     * Test of createRemark method, of class RemarkLogic.
     */
    @Test
    public void testCreateRemark() throws Exception {
        System.out.println("createRemark");
        RemarkDTO dto = new RemarkDTO();
        RemarkDTO result = remarkLogic.createRemark(dto);
        assertNotNull(dto);
    }
    
}
