package co.edu.uniandes.csw.artmarketplace.services;

import co.edu.uniandes.csw.artmarketplace.api.IArtistLogic;
import co.edu.uniandes.csw.artmarketplace.api.IArtworkLogic;
import co.edu.uniandes.csw.artmarketplace.api.IQuestionLogic;
import co.edu.uniandes.csw.artmarketplace.api.IRemarkLogic;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtistDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ClientDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.QuestionDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.RemarkDTO;
import co.edu.uniandes.csw.artmarketplace.providers.StatusCreated;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
import org.apache.shiro.subject.Subject;

/**
 * @generated
 */
@Path("/artworks")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ArtworkService {

    @Inject
    private IArtworkLogic artworkLogic;
    @Inject
    private IArtistLogic artistLogic;
    @Inject
    private IQuestionLogic questionLogic;
    @Inject
    private IRemarkLogic remarkLogic;

    @Context
    private HttpServletResponse response;
    @javax.ws.rs.core.Context
    private ServletContext context;

    @QueryParam("page")
    private Integer page;
    @QueryParam("maxRecords")
    private Integer maxRecords;
    @QueryParam("q")
    private String artworkName;

    /**
     * Constante de Client pues se utiliza en múltiples llamados (baja la deuda
     * técnica)
     */
    private final static String CLIENT = "Client";

    private ArtistDTO artist = (ArtistDTO) SecurityUtils.getSubject().getSession().getAttribute("Artist");
    private ClientDTO client = (ClientDTO) SecurityUtils.getSubject().getSession().getAttribute(CLIENT);

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public ArtworkDTO createArtwork(ArtworkDTO dto) {
        if (artist != null) {
            dto.setArtist(artist);
            return artworkLogic.createArtwork(dto);
        }
        return null;
    }

    /**
     * @generated
     */
    @GET
    public List<ArtworkDTO> getArtworks() {
        if (artist != null) {
            return artistLogic.getArtist(artist.getId()).getArtwork();
        } else {
            if (artworkName != null) {
                return artworkLogic.findByName(artworkName);
            }
            if (page != null && maxRecords != null) {
                this.response.setIntHeader("X-Total-Count", artworkLogic.countArtworks());
            }
            return artworkLogic.getArtworks(page, maxRecords);
        }
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public ArtworkDTO getArtwork(@PathParam("id") Long id) {
        return artworkLogic.getArtwork(id);
    }

    /**
     * Search artworks between prices
     *
     * @param artworkMinPrice
     * @param artworkMaxPrice
     * @return
     */
    @GET
    @Path("/artworksBetweenPrices/{artworkMinPrice}/{artworkMaxPrice}")
    public List<ArtworkDTO> searchArtworksBetweenPrices(@PathParam("artworkMinPrice") int artworkMinPrice, @PathParam("artworkMaxPrice") int artworkMaxPrice) {
        return artworkLogic.searchArtworksBetweenPrices(artworkMinPrice, artworkMaxPrice);
    }

    /**
     * Search artist with cheapest artwork
     *
     * @param artworkName
     * @return
     */
    @GET
    @Path("/artistWithCheapestArtwork/{artworkName}")
    public List<ArtworkDTO> searchArtistWithCheapestArtwork(@PathParam("artworkName") String artworkName) {
        return artworkLogic.searchArtistWithCheapestArtwork(artworkName);
    }

    /**
     * Search cheapest artwork of an artist
     *
     * @param artistName
     * @return
     */
    @GET
    @Path("/cheapestArtworkOfAnArtist/{artistName}")
    public List<ArtworkDTO> searchCheapestArtworkOfAnArtist(@PathParam("artistName") String artistName) {
        return artworkLogic.searchCheapestArtworkOfAnArtist(artistName);
    }

    /**
     * Search artworks of an artist
     *
     * @param artistId
     * @return
     */
    @GET
    @Path("/searchArtworksOfAnArtist/{artistId}")
    public List<ArtworkDTO> searchArtworksOfAnArtist(@PathParam("artistId") String artistId) {
        return artworkLogic.searchArtworksOfAnArtist(artistId);
    }

    /**
     * Search artworks by style
     *
     * @param artworkStyle
     * @return
     */
    @GET
    @Path("/searchArtworksByStyle/{artworkStyle}")
    public List<ArtworkDTO> searchArtworksByStyle(@PathParam("artworkStyle") String artworkStyle) {
        return artworkLogic.searchArtworksByStyle(artworkStyle);
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public ArtworkDTO updateArtwork(@PathParam("id") Long id, ArtworkDTO dto) {
        dto.setId(id);
        return artworkLogic.updateArtwork(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteArtwork(@PathParam("id") Long id) {
        artworkLogic.deleteArtwork(id);
    }

    @POST
    @Path("/questions")
    public QuestionDTO createQuestion(QuestionDTO dto) {
        dto.setDate(new Date());
        try {
            ClientDTO myClient = (ClientDTO) SecurityUtils.getSubject().getSession().getAttribute(CLIENT);
            String path = context.getInitParameter("emailConfig");
            InputStream data = context.getResourceAsStream(path);
            Properties props = new Properties();
            props.load(data);
            Subject currentUser = SecurityUtils.getSubject();
            Map<String, String> userAttributes = (Map<String, String>) currentUser.getPrincipals().oneByType(java.util.Map.class);
            dto.setEmail(userAttributes.get("email"));
            dto.setClient(myClient);
            questionLogic.createQuestion(dto);
            dto.setClient(myClient);
            questionLogic.sendEmail(dto, props);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArtworkService.class.getName()).log(Level.SEVERE, null, "Archivo properties no encontrado");
            Logger.getLogger(ArtworkService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArtworkService.class.getName()).log(Level.SEVERE, null, "Error con el archivo porperties.");
            Logger.getLogger(ArtworkService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger(ArtworkService.class.getName()).log(Level.SEVERE, null, "Error: el archivo porperties no ha sido encontrado porque no existe.");
            Logger.getLogger(ArtworkService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dto;
    }

    /**
     * Adiciona un comentario a una obra de arte.
     *
     * @param id
     * @param newRemark
     * @return
     */
    @GET
    @Path("/postRemark/{id}/{newRemark}")
    public ArtworkDTO postRemark(@PathParam("id") Long id, @PathParam("newRemark") String newRemark) {

        if (client != null || artist != null) {
            ArtworkDTO dto = artworkLogic.getArtwork(id);
            RemarkDTO remark = new RemarkDTO();
            remark.setArtwork(dto);
            remark.setDescription(newRemark);
            remark.setRemarkDate(new GregorianCalendar());
            if (client != null) {
                remark.setRemarkUser(client.getName());
                remark.setUserType("Cliente");
            } else if (artist != null) {
                remark.setRemarkUser(artist.getName());
                remark.setUserType("Artista");
            }
            remark = remarkLogic.createRemark(remark);
            remark.setArtwork(dto);
            dto.getRemarks().add(remark);
            return artworkLogic.updateArtwork(dto);
        } else {
            return artworkLogic.getArtwork(id);
        }
    }

    @POST
    @Path("{id: \\d+}/rate/{rate: \\d+}")
    public void rateArtist(@PathParam("id") Long id, @PathParam("rate") Float rate) {
        ClientDTO myClient = (ClientDTO) SecurityUtils.getSubject().getSession().getAttribute(CLIENT);
        artworkLogic.rateArtwork(id, myClient, rate);
    }
}