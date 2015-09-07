/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.ejbs;

import co.edu.uniandes.csw.artmarketplace.api.IAdminLogic;
import co.edu.uniandes.csw.artmarketplace.converters.AdminConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.AdminDTO;
import co.edu.uniandes.csw.artmarketplace.persistence.AdminPersistence;
import javax.inject.Inject;

/**
 *
 * @author ms.lancheros10
 */
public class AdminLogic implements IAdminLogic{
    
    @Inject private AdminPersistence persistence;
    
     public AdminDTO getAdminByUserId(String userId) {
        return AdminConverter.refEntity2DTO(persistence.getAdminByUserId(userId));
    }
}
