/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.ejbs;

import co.edu.uniandes.csw.artmarketplace.api.IExhibitionLogic;
import co.edu.uniandes.csw.artmarketplace.converters.ExhibitionConverter;
import co.edu.uniandes.csw.artmarketplace.converters.ResumeConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ArtistDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ExhibitionDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ExhibitionEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.ExhibitionPersistence;
import javax.inject.Inject;

/**
 *
 * @author lf.mendivelso10
 */
public class ExhibitionLogic implements IExhibitionLogic{
    /**
     * Objeto que maneja la persistencia de la hoja de vida.
     */
    @Inject
    private ExhibitionPersistence persistence;

    /**
     * Metodo encargado de crear la entidad y persistirla en la base de datos.
     *
     * @param dto. objeto DTO con la hoja de vida.
     * @param artist. Artista con la exhibicion.
     * @return Objeto DTO que se persistio.
     */
    @Override
    public ExhibitionDTO createExhibition(ExhibitionDTO dto, ArtistDTO artist) {
        dto.setResume(ResumeConverter.basicEntity2DTO(persistence.getResumeByArtistId(artist.getId())));
        ExhibitionEntity entity = ExhibitionConverter.fullDTO2Entity(dto);
        entity = persistence.create(entity);
        return ExhibitionConverter.fullEntity2DTO(entity);
    }
}
