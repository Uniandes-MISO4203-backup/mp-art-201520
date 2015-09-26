/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.ejbs;

import co.edu.uniandes.csw.artmarketplace.api.IResumeLogic;
import co.edu.uniandes.csw.artmarketplace.converters.ResumeConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ResumeDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ResumeEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.ResumePersistence;
import javax.inject.Inject;

/**
 * Implementa la interfaz para el manejo de la hoja de vida
 * @author vp.salcedo93
 */
public class ResumeLogic implements IResumeLogic{
     
    /**
     * Objeto que maneja la persistencia de la hoja de vida.
     */
    @Inject private ResumePersistence persistence;
    
    /**
     * Metodo encargado de crear la entidad y persistirla en la base de datos.
     * @param dto. objeto DTO con la hoja de vida.
     * @return Objeto DTO que se persistio.
     */
    public ResumeDTO createResume(ResumeDTO dto) {
        ResumeEntity entity = ResumeConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return ResumeConverter.fullEntity2DTO(entity);
    }

    /**
     * Metodo encargado de actualizar la hoja de vida.
     * @param dto. objeto DTO con la hoja de vida.
     * @return Objeto DTO que se persistio.
     */
    public ResumeDTO updateResume(ResumeDTO dto) {
        ResumeEntity entity = persistence.update(ResumeConverter.fullDTO2Entity(dto));
        return ResumeConverter.fullEntity2DTO(entity);
    }
    
    
    public ResumeDTO getResumebyAristId(Long id) {
        return ResumeConverter.fullEntity2DTO(persistence.getResumeByArtistId(id));
    }
}
