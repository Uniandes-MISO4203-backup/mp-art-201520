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
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
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
    @QueryParam("page")
    private Integer page;
    @QueryParam("maxRecords")
    private Integer maxRecords;
    @QueryParam("q")
    private String artworkName;
    private ArtistDTO artist = (ArtistDTO) SecurityUtils.getSubject().getSession().getAttribute("Artist");
    private ClientDTO client = (ClientDTO) SecurityUtils.getSubject().getSession().getAttribute("Client");

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

    @GET
    @Path("/artistWithCheapestArtwork/{artworkName}")
    public List<ArtworkDTO> searchArtistWithCheapestArtwork(@PathParam("artworkName") String artworkName) {
        return artworkLogic.searchArtistWithCheapestArtwork(artworkName);
    }
    
    @GET
    @Path("/cheapestArtworkOfAnArtist/{artistName}")
    public List<ArtworkDTO> searchCheapestArtworkOfAnArtist(@PathParam("artistName") String artistName) {
        return artworkLogic.searchCheapestArtworkOfAnArtist(artistName);
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
    @Path("/question/{id: \\d+}")
    public QuestionDTO createQuestion(@PathParam("id") Long id, QuestionDTO dto){
        if(id != null){
            return questionLogic.createQuestion(dto);
        }
        return null;
    }
    
    /**
     * Adiciona un comentario a una obra de arte.
     * @param id
     * @param newRemark
     * @return 
     */
    @GET
    @Path("/postRemark/{id}/{newRemark}")
    public ArtworkDTO postRemark(@PathParam("id") Long id, @PathParam("newRemark") String newRemark) {
        
        ArtworkDTO dto = artworkLogic.getArtwork(id);
        RemarkDTO remark = new RemarkDTO();
        remark.setArtwork(dto);
        remark.setDescription(newRemark);
        remark.setRemarkDate(new Date());
        remark.setRemarkUser(client.getName());
        remark = remarkLogic.createRemark(remark);
        remark.setArtwork(dto);
        dto.getRemarks().add(remark);
        return artworkLogic.updateArtwork(dto);
    }
}
