/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.services;

import co.edu.uniandes.csw.artmarketplace.api.IArtistLogic;
import co.edu.uniandes.csw.artmarketplace.api.IResumeLogic;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtistDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ResumeDTO;
import co.edu.uniandes.csw.artmarketplace.providers.StatusCreated;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.apache.shiro.SecurityUtils;

/**
 * Servicio de la hoja de vida de un artista
 * @author vp.salcedo93
 */
@Path("/resume")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ResumeService {
    
    /**
     * Expone los servicios del Backup del artista
     */
    @Inject
    private IArtistLogic artistLogic;
    
    /**
     * Expone los servicios del Backup del artista
     */
    @Inject
    private IResumeLogic resumeLogic;
    
    //-------Manejo de REST-----------------------------------------
    @Context
    private HttpServletResponse response;
    @QueryParam("page")
    private Integer page;
    @QueryParam("maxRecords")
    private Integer maxRecords;
    //--------------------------------------------------------------
    
    /**
     * Artista logeado
     */
    private ArtistDTO artist = (ArtistDTO) SecurityUtils.getSubject().getSession().getAttribute("Artist");
    
    /**
     * Metodo encargado de crear la hoja de vida para el artista.
     * @param dto. Objeto de la hoja de vida.
     * @return ResumeDTO. Objeto creado desde el backend.
     */
    @POST
    @StatusCreated
    public ResumeDTO createResume(ResumeDTO dto) {
        if (artist != null) {
            dto.setArtist(artist);
            return resumeLogic.createResume(dto);
        }
        return null;
    }
    
    /**
     * Metodo encargado de actualizar una hoja de vida.
     * @param id. Identificador de la hoja de vida.
     * @param dto. Objeto de la hoja de vida.
     * @return ResumeDTO. Objeto actualizado desde el backend.
     */
    @PUT
    @Path("{id: \\d+}")
    public ResumeDTO updateResume(@PathParam("id") Long id, ResumeDTO dto) {
        if (artist != null)
        {
            dto.setArtist(artist);
            dto.setId(id);
            return resumeLogic.updateResume(dto);
        }else
            return null;
    }
    
    @GET
    public List<ResumeDTO> getResumes() {
        return new ArrayList<ResumeDTO>();
    }
    
}
