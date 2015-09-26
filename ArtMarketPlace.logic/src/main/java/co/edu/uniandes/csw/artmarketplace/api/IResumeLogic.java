/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.api;

import co.edu.uniandes.csw.artmarketplace.dtos.ResumeDTO;


/**
 * Interfaz para el manejo de la hoja de vida
 * @author vp.salcedo93
 */
public interface IResumeLogic {
    
    /**
     * Metodo encargado de crear la entidad y persistirla en la base de datos.
     * @param dto. objeto DTO con la hoja de vida.
     * @return Objeto DTO que se persistio.
     */
    public ResumeDTO createResume(ResumeDTO dto) ;
    /**
     * Metodo encargado de actualizar la hoja de vida.
     * @param dto. objeto DTO con la hoja de vida.
     * @return Objeto DTO que se persistio.
     */
    public ResumeDTO updateResume(ResumeDTO dto) ;
    
}
