package co.edu.uniandes.csw.artmarketplace.services;

import co.edu.uniandes.csw.artmarketplace.api.IArtworkLogic;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkDTO;
import co.edu.uniandes.csw.artmarketplace.providers.StatusCreated;
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

/**
 * @generated
 */
@Path("/artworks")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ArtworkService {

    @Inject private IArtworkLogic artworkLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public ArtworkDTO createArtwork(ArtworkDTO dto) {
        return artworkLogic.createArtwork(dto);
    }

    /**
     * @generated
     */
    @GET
    public List<ArtworkDTO> getArtworks() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", artworkLogic.countArtworks());
        }
        return artworkLogic.getArtworks(page, maxRecords);
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
}
