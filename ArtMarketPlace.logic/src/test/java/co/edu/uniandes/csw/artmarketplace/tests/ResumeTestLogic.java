/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.tests;

import static co.edu.uniandes.csw.artmarketplace.tests._TestUtil.*;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.uniandes.csw.artmarketplace.ejbs.ResumeLogic;
import co.edu.uniandes.csw.artmarketplace.api.IResumeLogic;
import co.edu.uniandes.csw.artmarketplace.converters.ResumeConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ResumeDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ResumeEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.ResumePersistence;

/**
 *
 * @author lf.mendivelso10
 */
@RunWith(Arquillian.class)
public class ResumeTestLogic {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ResumeEntity.class.getPackage())
                .addPackage(ResumeDTO.class.getPackage())
                .addPackage(ResumeConverter.class.getPackage())
                .addPackage(ResumeLogic.class.getPackage())
                .addPackage(IResumeLogic.class.getPackage())
                .addPackage(ResumePersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IResumeLogic resumeLogic;

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
        em.createQuery("delete from ResumeEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<ResumeEntity> data = new ArrayList<ResumeEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            
            ResumeEntity entity = new ResumeEntity();
            entity.setCity(generateRandom(String.class));
            entity.setCountry(generateRandom(String.class));
            entity.setWebsite(generateRandom(String.class));
            entity.setLastName(generateRandom(String.class));
            entity.setPhoto(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }
    @Test
    public void ratingResume(){
        ResumeEntity resume = data.get(0);
        
        // Test data
        Float rating1 = (float)(1 + (int)(Math.random()*5));
        Float rating2 = (float)(1 + (int)(Math.random()*5));
        Float rating3 = (float)(1 + (int)(Math.random()*5));
        // Sin ninguna votaci?n.
        Assert.assertEquals(0.0000f,resumeLogic.getRatingArtist(resume.getId()),0.0002f);
        // Primera calificacion
        resumeLogic.rateArtist(resume.getId(), rating1);
        // Validaci?n de la primera calificacion 
        Assert.assertEquals(rating1,resumeLogic.getRatingArtist(resume.getId()),0.0002f);
        // Segunda calificacion
        Float currentRating = (rating1+rating2)/2.0000f;
        resumeLogic.rateArtist(resume.getId(), rating2);
        // Validaci?n de la primera calificacion 
        Assert.assertEquals(currentRating,resumeLogic.getRatingArtist(resume.getId()),0.0002f);
        // Segunda calificacion
        currentRating = (rating1+rating2+rating3)/3.0000f;
        resumeLogic.rateArtist(resume.getId(), rating3);
        // Validaci?n de la primera calificacion 
        Assert.assertEquals(currentRating,resumeLogic.getRatingArtist(resume.getId()),0.0002f);
    }
}
