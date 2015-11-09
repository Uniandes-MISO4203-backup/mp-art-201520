/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.services;

import co.edu.uniandes.csw.artmarketplace.api.IWishListLogic;
import co.edu.uniandes.csw.artmarketplace.dtos.ClientDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.WishListDTO;
import co.edu.uniandes.csw.artmarketplace.providers.StatusCreated;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.shiro.SecurityUtils;

/**
 *
 * @author ms.lancheros10
 */
@Path("/wishList")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WishListService {
    
    @Inject
    private IWishListLogic wishListLogic;
    
    private ClientDTO client = (ClientDTO) SecurityUtils.getSubject().getSession().getAttribute("Client");
    
    /**
     * @generated
     */
    @POST
    @StatusCreated
    public WishListDTO createWishListItem(WishListDTO dto) {
        if (client != null) {
            dto.setClient(client);
            return wishListLogic.createWishListItem(dto);
        }
        return null;
    }
    
    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteWishList(@PathParam("id") Long id) {
        wishListLogic.removeWishListItemDTO(id);
    }
    
    /**
     * @generated
     */
    @GET
    public List<WishListDTO> getWishListItems() {
        return wishListLogic.getWishListItems(client.getId());
    }
    
}
