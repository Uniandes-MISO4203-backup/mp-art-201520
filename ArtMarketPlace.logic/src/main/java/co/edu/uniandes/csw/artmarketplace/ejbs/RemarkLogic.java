/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.ejbs;

import co.edu.uniandes.csw.artmarketplace.api.IRemarkLogic;
import co.edu.uniandes.csw.artmarketplace.converters.ArtworkConverter;
import co.edu.uniandes.csw.artmarketplace.converters.RemarkConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.RemarkDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
import co.edu.uniandes.csw.artmarketplace.entities.RemarkEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.RemarkPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Implementa la interfaz para el manejo de comentarios.
 */
@Stateless
public class RemarkLogic implements IRemarkLogic{
    
    @Inject private RemarkPersistence persistence;

    /**
     *
     * @param dto
     * @return
     */
    @Override
    public RemarkDTO createRemark(RemarkDTO dto) {
        ArtworkEntity artworkEntity = ArtworkConverter.fullDTO2Entity(dto.getArtwork());
        RemarkEntity entity = RemarkConverter.childDTO2Entity(dto, artworkEntity);
        entity = persistence.create(entity);
        return RemarkConverter.fullEntity2DTO(entity);
    }
}
