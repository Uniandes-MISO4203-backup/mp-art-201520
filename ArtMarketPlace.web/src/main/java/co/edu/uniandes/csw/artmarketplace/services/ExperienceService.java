/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.services;

import co.edu.uniandes.csw.artmarketplace.api.IArtistLogic;
import co.edu.uniandes.csw.artmarketplace.api.IExperienceLogic;
import co.edu.uniandes.csw.artmarketplace.api.IResumeLogic;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtistDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ExperienceDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.QuestionDTO;
import co.edu.uniandes.csw.artmarketplace.providers.StatusCreated;
import java.util.Date;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.shiro.SecurityUtils;

/**
 * Servicio de los regisdtro de experiencia de una hoja de vida
 * @author vp.salcedo93
 */
@Path("/experience")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ExperienceService {
    /**
     * Expone los servicios del backup de experiencia 
     */
    @Inject
    private IExperienceLogic experienceLogic;
    
    /**
     * Artista logeado
     */
    private ArtistDTO artist = (ArtistDTO) SecurityUtils.getSubject().getSession().getAttribute("Artist");
    
    /**
     * Metodo encargado de crear una nueva experiencia
     * @param dto
     * @return 
     */
    @POST
    @StatusCreated
    public ExperienceDTO createExperience(ExperienceDTO dto) {
        if (artist != null) {
            return experienceLogic.createResume(dto,artist);
        }
        return null;

    }
}
