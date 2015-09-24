/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.api;

import co.edu.uniandes.csw.artmarketplace.dtos.ExperienceDTO;

/**
 * Interfaz para el manejo de registrso de la hoja de vida
 * @author vp.salcedo93
 */
public interface IExperienceLogic {
    /**
     * Metodo encargado de crear la entidad y persistirla en la base de datos.
     * @param dto. objeto DTO con la hoja de vida.
     * @return Objeto DTO que se persistio.
     */
    public ExperienceDTO createResume(ExperienceDTO dto);
}
