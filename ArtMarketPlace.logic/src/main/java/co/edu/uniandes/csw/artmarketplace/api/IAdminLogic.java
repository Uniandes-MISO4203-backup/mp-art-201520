/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.api;

import co.edu.uniandes.csw.artmarketplace.dtos.AdminDTO;

/**
 *
 * @author ms.lancheros10
 */
public interface IAdminLogic {
    public AdminDTO getAdminByUserId(String userId);
}
