/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.ejbs;

import co.edu.uniandes.csw.artmarketplace.api.IWishListLogic;
import co.edu.uniandes.csw.artmarketplace.converters.WishListConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.WishListDTO;
import co.edu.uniandes.csw.artmarketplace.entities.WishListEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.WishListPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author ms.lancheros10
 */
public class WishListLogic implements IWishListLogic {

    @Inject
    private WishListPersistence persistence;

    @Override
    public WishListDTO createWishListItem(WishListDTO dto) {
        persistence.createWishListItem(WishListConverter.basicDTO2Entity(dto));
        return dto;
    }

    @Override
    public void removeWishListItemDTO(Long id) {
        persistence.delete(id);
    }

    @Override
    public List<WishListDTO> getWishListItems(Long id) {
        List<WishListEntity> entities = persistence.getWishListByClient(id);
        List<WishListDTO> dtos = new ArrayList<WishListDTO>();
        for (WishListEntity entity : entities) {
            WishListDTO dto = WishListConverter.basicEntity2DTO(entity);
            dtos.add(dto);
        }
        return dtos;
    }

}
