/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.persistence;

import co.edu.uniandes.csw.artmarketplace.entities.WishListEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author ms.lancheros10
 */
@Stateless
public class WishListPersistence extends CrudPersistence<WishListEntity> {
    
    /**
     * @generated
     */
    public WishListPersistence() {
        this.entityClass = WishListEntity.class;
    }
    
    /**
     * @generated
     */
    public WishListEntity createWishListItem(WishListEntity wishListEntity) {
        Query q = em.createNamedQuery("WishList.getByClientIdAndArtWorkId")
                .setParameter("client_id", wishListEntity.getClient().getId())
                .setParameter("artwork_id", wishListEntity.getArtwork().getId());
        if(q.getResultList().isEmpty())
        em.persist(wishListEntity);
        return wishListEntity;
    }
    
    /**
     * @generated
     */
    public void delete(Long id) {
        delete(id);
    }
    
    /**
     * @generated
     */
    public List<WishListEntity> getWishListByClient(Long id){
        Query q = em.createNamedQuery("WishList.getByClientId");
        return q.setParameter("client_id", id)
                .getResultList();
    }
    
}
