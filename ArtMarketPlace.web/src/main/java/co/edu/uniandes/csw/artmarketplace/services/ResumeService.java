/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.services;

import co.edu.uniandes.csw.artmarketplace.api.IBlogLogic;
import co.edu.uniandes.csw.artmarketplace.api.ICommentBlogLogic;
import co.edu.uniandes.csw.artmarketplace.api.IExhibitionLogic;
import co.edu.uniandes.csw.artmarketplace.api.IExperienceLogic;
import co.edu.uniandes.csw.artmarketplace.api.IResumeLogic;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtistDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.BlogDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.CommentBlogDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ExhibitionDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ExperienceDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ResumeDTO;
import co.edu.uniandes.csw.artmarketplace.providers.StatusCreated;
import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.api.ApiKey;
import com.stormpath.sdk.api.ApiKeys;
import com.stormpath.sdk.client.Client;
import com.stormpath.sdk.client.Clients;
import com.stormpath.sdk.resource.ResourceException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.apache.shiro.SecurityUtils;
import org.ini4j.Wini;

/**
 * Servicio de la hoja de vida de un artista
 *
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
    private IResumeLogic resumeLogic;

    /**
     * Expone los servicios del backup de experiencia
     */
    @Inject
    private IExperienceLogic experienceLogic;
    
    /**
     * Expone los servicios del backup de experiencia
     */
    @Inject
    private IExhibitionLogic exhibitionLogic;

    //Para el servicio de Blog...
    @Inject
    private IBlogLogic blogLogic;
    
    @Inject
    private ICommentBlogLogic commentLogic;
    

    @QueryParam("page")
    private Integer page;
    @QueryParam("maxRecords")
    private Integer maxRecords;

    /**
     * Artista logeado
     */
    private final ArtistDTO artist = (ArtistDTO) SecurityUtils.getSubject().getSession().getAttribute("Artist");

    /**
     * Metodo encargado de crear la hoja de vida para el artista.
     *
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
     *
     * @param id. Identificador de la hoja de vida.
     * @param dto. Objeto de la hoja de vida.
     * @return ResumeDTO. Objeto actualizado desde el backend.
     */
    @PUT
    @Path("{id: \\d+}")
    public ResumeDTO updateResume(@PathParam("id") Long id, ResumeDTO dto) {
        if (artist != null) {
            dto.setArtist(artist);
            dto.setId(id);
            return resumeLogic.updateResume(dto);
        } else {
            return null;
        }
    }

    @GET
    public List<ResumeDTO> getResumes() {
        return new ArrayList<>();
    }

    @GET
    @Path("{id: \\d+}")
    public ResumeDTO getResume(@PathParam("id") Long id) {
        ResumeDTO resumeDTO = resumeLogic.getResumebyAristId(id);
        try {
            if (resumeDTO != null) {
                URL url = ArtistService.class.getResource("ArtistService.class");
                String className = url.getFile();
                String filePath = className.substring(0, className.indexOf("WEB-INF") + "WEB-INF".length());
                Wini ini = new Wini(new File(filePath + "/shiro.ini"));
                String path = ini.get("main", "stormpathClient.apiKeyFileLocation");
                ApiKey apiKey = ApiKeys.builder().setFileLocation(path).build();
                Client client = Clients.builder().setApiKey(apiKey).build();
                try {
                    Account account = client.getResource(resumeDTO.getArtist().getUserId(), Account.class);
                    resumeDTO.getArtist().setFirstName(account.getGivenName());
                    resumeDTO.getArtist().setLastname(account.getSurname());
                    resumeDTO.getArtist().setEmail(account.getEmail());
                } catch (ResourceException e) {
                    Logger.getLogger(ResumeService.class.getName()).log(Level.SEVERE, null, "No existe el usuario con ese ID");
                    Logger.getLogger(ResumeService.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        } catch (IOException e) {
            Logger.getLogger(ResumeService.class.getName()).log(Level.SEVERE, null, "Error al leer el archivo de shiro");
            Logger.getLogger(ResumeService.class.getName()).log(Level.SEVERE, null, e);
        }
        return resumeDTO;
    }

    /**
     * Metodo encargado de crear una nueva experiencia
     *
     * @param dto. Nuevo registro de experiencia o educacion.
     * @return Registro guardado o null en caso de un error.
     */
    @POST
    @Path("/experience")
    public ExperienceDTO createExperience(ExperienceDTO dto) {
        ResumeDTO resumeDTO = resumeLogic.getResumebyAristId(artist.getId());
        if (artist != null && resumeDTO != null) {
            return experienceLogic.createResume(dto, artist);
        } else if (artist != null && resumeDTO == null) {
            resumeDTO = new ResumeDTO();
            resumeDTO.setArtist(artist);
            resumeDTO = resumeLogic.createResume(resumeDTO);
            if (resumeDTO != null) {
                dto.setResume(resumeDTO);
                return experienceLogic.createResume(dto, artist);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    
    /**
     * Este metodo esta encargado de registrar una nueva exhibicion de un artista en la
     * hoja de vida del artista.
     * @param dto Es la información de la exhibicion
     * @return un objeto del tipo ExhibitionDTO con la confirmación de registro.
     */
    @POST
    @Path("/exhibition")
    public ExhibitionDTO createExhibition(ExhibitionDTO dto) {
        ExhibitionDTO result = null;
        if (artist != null && dto!=null) {
            ResumeDTO resumeDTO = resumeLogic.getResumebyAristId(artist.getId());
            if (resumeDTO == null) {
                resumeDTO = new ResumeDTO();
                resumeDTO.setArtist(artist);
                resumeLogic.createResume(resumeDTO);
            }
            result = exhibitionLogic.createExhibition(dto, artist);
        }
        return result;
    }

    /**
     * Metodo que retorna el identificador del artista solo si tiene una hoja de
     * vida creada
     *
     * @pre Debe existir el artista.
     * @return Long. Identificador del artista.
     */
    @GET
    @Path("/artist")
    public ResumeDTO getArtistResume() {
        if (artist != null) {
            ResumeDTO resumeDTO = resumeLogic.getResumebyAristId(artist.getId());
            if (resumeDTO != null) {
                return resumeDTO;
            }
        }
        return null;
    }
    
    /**
     * search Artist By Name
     * @param artistName
     * @return 
     */
    @Path("/searchArtistByName/{artistName}")
    @GET
    public List<ResumeDTO> searchArtistByName(@PathParam("artistName") String artistName) {
        return resumeLogic.searchArtistByName(artistName);
    }

    /**
     * search Artists Between Ratings
     * @param artistMinRating
     * @param artistMaxRating
     * @return 
     */
    @Path("/searchArtistsBetweenRatings/{artistMinRating}/{artistMaxRating}")
    @GET
    public List<ResumeDTO> searchArtistsBetweenRatings(@PathParam("artistMinRating") float artistMinRating,@PathParam("artistMaxRating") float artistMaxRating){
        return resumeLogic.searchArtistsBetweenRatings(artistMinRating, artistMaxRating);
    }
    
    @POST
    @Path("{id: \\d+}/rate/{rate: \\d+}")
    public void rateArtist(@PathParam("id") Long id, @PathParam("rate") Float rate) {
        resumeLogic.rateArtist(id, rate);
    }

    /**
     * Servicio para crear una entrada en el blog del artista... Creado por
     * jh.rubiano10
     * @param dto
     * @return 
     */
    @POST
    @Path("/newentry/")
    @StatusCreated
    public BlogDTO createEntry(BlogDTO dto) {
        dto.setDateEntry(new GregorianCalendar());
        return blogLogic.createEntry(dto);
    }

    /*
     Traer todas las entradas de un Blog...
     */
    @Path("/allentrys")
    @GET
    public List<BlogDTO> getEntrys() {
        return blogLogic.getEntrys(page, maxRecords);
    }
    
    //Mostrar todas las entrada de un artista.
    @Path("/entryartist/{id: \\d+}")
    @GET
    public List<BlogDTO> getEntryArtist(@PathParam("id") Long idArtist) {
        return blogLogic.getEntryArtist(idArtist);
    }
    
    //Mostrar la entrada de un blog.
    @Path("/getentry/{id: \\d+}")
    @GET
    public BlogDTO getEntry(@PathParam("id") Long id) {
        return blogLogic.getEntry(id);
    }
    
    //Para los comentarios en en Blog...
    @POST
    @Path("/newcomment/")
    @StatusCreated
    public CommentBlogDTO createComment(CommentBlogDTO dto) {
        dto.setDateComment(new GregorianCalendar());
        return commentLogic.createComment(dto);
    }
    
    //Traer todos los comentarios...
    @Path("/allcomments")
    @GET
    public List<CommentBlogDTO> getComments() {
        return commentLogic.getComments(page, maxRecords);
    }
    
    //Para traer los cometarios de un blog.
    @Path("/getcomment/{id: \\d+}")
    @GET
    public List<CommentBlogDTO> getCommentBlog(@PathParam("id") Long idBlog) {
        return commentLogic.getCommentBlog(idBlog);
    }
    
    //Buscar entradas de un blog.
    @Path("/searchblog/{q}/{id}")
    @GET
    public List<BlogDTO> searchBlog(@PathParam("q") String search, @PathParam("id") Long idArtist) {
        return blogLogic.searchBlog(search, idArtist);
    }
}
