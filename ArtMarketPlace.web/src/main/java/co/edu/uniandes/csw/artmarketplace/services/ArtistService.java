package co.edu.uniandes.csw.artmarketplace.services;

import co.edu.uniandes.csw.artmarketplace.api.IArtistLogic;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtistDTO;
import co.edu.uniandes.csw.artmarketplace.providers.StatusCreated;
import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.client.Client;
import com.stormpath.sdk.client.Clients;
import com.stormpath.sdk.api.ApiKeys;
import com.stormpath.sdk.api.ApiKey;
import com.stormpath.sdk.resource.ResourceException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import org.apache.log4j.Logger;
import org.ini4j.Wini;

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

    final static Logger logger = Logger.getLogger(ArtistService.class);
    /**
     * @generated
     */
    @POST
    @StatusCreated
    public ArtistDTO createArtist(ArtistDTO dto) {
        return artistLogic.createArtist(dto);
    }

    /**
     * Este metodo retorna una lista con todos los artistas de la aplicacion.
     * @return artists es la lista de artistas retornado.
     * @generated
     */
    @GET
    public List<ArtistDTO> getArtists() {
        List<ArtistDTO> artists = new ArrayList();
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", artistLogic.countArtists());
        }
        try {
            URL url = ArtistService.class.getResource("ArtistService.class");
            String className = url.getFile();
            String filePath = className.substring(0,className.indexOf("WEB-INF") + "WEB-INF".length());
            Wini ini = new Wini(new File(filePath+"/shiro.ini"));
            String path = ini.get("main", "stormpathClient.apiKeyFileLocation");
            ApiKey apiKey = ApiKeys.builder().setFileLocation(path).build();
            Client client = Clients.builder().setApiKey(apiKey).build();
            artists = artistLogic.getArtists(page, maxRecords);
            for(ArtistDTO artistDTO:artists){
                try {
                   Account account = client.getResource(artistDTO.getUserId(), Account.class);
                   artistDTO.setFirstName(account.getGivenName());
                   artistDTO.setLastname(account.getSurname());
                   artistDTO.setEmail(account.getEmail()); 
                } catch (ResourceException e) {
                     logger.error("The account with userid: "+e.getMessage()+" does not exist.");
                     logger.error(e);
                }


            }
            
        } catch (IOException e) {
            logger.error(e.getMessage());
            logger.error(e);
            artists.clear();
        }
        return artists;
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
     * Retorna artistas por nombre.
     */
    @GET
    @Path("/searchArtist/{searchName}")
    public List<ArtistDTO> searchArtist(@PathParam("searchName") String name) {
        return artistLogic.findByName(name);
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
