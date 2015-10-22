/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.ejbs;

import co.edu.uniandes.csw.artmarketplace.api.IExperienceLogic;
import co.edu.uniandes.csw.artmarketplace.converters.ExperienceConverter;
import co.edu.uniandes.csw.artmarketplace.converters.ResumeConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtistDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ExperienceDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ExperienceEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.ExperiencePersistence;
import javax.inject.Inject;

/**
 * Implementa la interfaz para el manejo de registrso de la hoja de vida
 *
 * @author vp.salcedo93
 */
public class ExperienceLogic implements IExperienceLogic {

    /**
     * Objeto que maneja la persistencia de la hoja de vida.
     */
    @Inject
    private ExperiencePersistence persistence;

    /**
     * Metodo encargado de crear la entidad y persistirla en la base de datos.
     *
     * @param dto. objeto DTO con la hoja de vida.
     * @param artist. Artista con la experiencia.
     * @return Objeto DTO que se persistio.
     */
    @Override
    public ExperienceDTO createResume(ExperienceDTO dto, ArtistDTO artist) {
        dto.setResume(ResumeConverter.refEntity2DTO(persistence.getResumeByArtistId(artist.getId())));
        ExperienceEntity entity = ExperienceConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return ExperienceConverter.fullEntity2DTO(entity);
    }
}
