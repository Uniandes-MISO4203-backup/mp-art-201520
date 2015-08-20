package co.edu.uniandes.csw.artmarketplace.services;

import co.edu.uniandes.csw.artmarketplace.api.IArtistLogic;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtistDTO;
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
@Path("/artists")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ArtistService {

    @Inject private IArtistLogic artistLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public ArtistDTO createArtist(ArtistDTO dto) {
        return artistLogic.createArtist(dto);
    }

    /**
     * @generated
     */
    @GET
    public List<ArtistDTO> getArtists() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", artistLogic.countArtists());
        }
        return artistLogic.getArtists(page, maxRecords);
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public ArtistDTO getArtist(@PathParam("id") Long id) {
        return artistLogic.getArtist(id);
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public ArtistDTO updateArtist(@PathParam("id") Long id, ArtistDTO dto) {
        dto.setId(id);
        return artistLogic.updateArtist(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteArtist(@PathParam("id") Long id) {
        artistLogic.deleteArtist(id);
    }
}
