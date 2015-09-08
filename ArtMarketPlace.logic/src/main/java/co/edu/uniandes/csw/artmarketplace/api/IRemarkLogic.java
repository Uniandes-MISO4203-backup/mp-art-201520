/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.api;

import co.edu.uniandes.csw.artmarketplace.dtos.RemarkDTO;

/**
 * Lógica para manejar los comentarios.
 */
public interface IRemarkLogic {
    public RemarkDTO createRemark(RemarkDTO dto);
}
