/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.api;

import co.edu.uniandes.csw.artmarketplace.dtos.WishListDTO;
import java.util.List;

/**
 *
 * @author ms.lancheros10
 */
public interface IWishListLogic {
    
    public WishListDTO createWishListItem(WishListDTO dto);
    
    public void removeWishListItemDTO(Long id);
    
    public List<WishListDTO> getWishListItems(Long id);
    
}
