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
 *
 * @author vp.salcedo93
 */
public class ResumeLogic implements IResumeLogic {

    /**
     * Objeto que maneja la persistencia de la hoja de vida.
     */
    @Inject
    private ResumePersistence persistence;

    /**
     * Metodo encargado de crear la entidad y persistirla en la base de datos.
     * En caso de que ya exista actualiza los datos.
     *
     * @param dto. objeto DTO con la hoja de vida.
     * @return Objeto DTO que se persistio.
     */
    @Override
    public ResumeDTO createResume(ResumeDTO dto) {
        ResumeDTO resumeDTO = getResumebyAristId(dto.getArtist().getId());
        if (resumeDTO != null) {
            dto.setId(resumeDTO.getId());
            dto.setExperience(resumeDTO.getExperience());
            return updateResume(dto);
        } else {
            ResumeEntity entity = ResumeConverter.fullDTO2Entity(dto);
            persistence.create(entity);
            return ResumeConverter.fullEntity2DTO(entity);
        }

    }

    /**
     * Metodo encargado de actualizar la hoja de vida.
     *
     * @param dto. objeto DTO con la hoja de vida.
     * @return Objeto DTO que se persistio.
     */
    @Override
    public ResumeDTO updateResume(ResumeDTO dto) {
        ResumeEntity entity = persistence.update(ResumeConverter.fullDTO2Entity(dto));
        return ResumeConverter.fullEntity2DTO(entity);
    }

    /**
     * Metodo que obtiene el resumen de un artista por identificador.
     *
     * @param id
     * @return
     */
    @Override
    public ResumeDTO getResumebyAristId(Long id) {
        return ResumeConverter.fullEntity2DTO(persistence.getResumeByArtistId(id));
    }

    /**
     * Este metodo esta disennado para recibir la votacion realizar por un
     * cliente frente a un artista en especifico.
     *
     * @param rating es la valoracion hecha por el cliente.
     * @param id es el identificador unico del artista.
     * @return confirmation es la variable designada para confirmar que se ha
     * hecho la calificacion de un artista.
     */
    @Override
    public Boolean rateArtist(Long id, Float rating) {
        boolean confirmation = false;
        ResumeEntity resume = persistence.getResumeByArtistId(id);
        if (resume != null) {
            if (resume.getRatingVotes() != null && resume.getRatingSum() != null) {
                resume.setRatingSum(resume.getRatingSum() + rating);
                resume.setRatingVotes((float) 1 + resume.getRatingVotes());

            } else {
                resume.setRatingSum(rating);
                resume.setRatingVotes(1.0000f);
            }
            persistence.update(resume);
            confirmation = true;
        }
        return confirmation;
    }

    /**
     * Este metodo esta dise?ado para la calificaci?n actual del artista en
     * especifico.
     *
     * @param id es el identificador unico del artista.
     * @return rating es la variable designada para retornar la calificaci?n del
     * artista.
     */
    @Override
    public Float getRatingArtist(Long id) {
        ResumeEntity resume = persistence.getResumeByArtistId(id);
        Float rating = 0.0000f;
        if (resume.getRatingVotes() != null && resume.getRatingSum() != null) {
            if (resume.getRatingVotes() > 0) {
                rating = resume.getRatingSum() / resume.getRatingVotes();
            }
        }
        return rating;
    }
}
