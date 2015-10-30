/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.api;

import co.edu.uniandes.csw.artmarketplace.dtos.ResumeDTO;
import java.util.List;


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
    
    public ResumeDTO getResumebyAristId(Long id);
    /**
     * Este metodo esta dise?ado para recibir la votaci?n realizar por un cliente frente a un artista en especifico.
     * @param rating es la valoraci?n hecha por el cliente.
     * @param id es el identificador unico del artista.
     * @return confirmation es la variable designada para confirmar que se ha hecho la calificaci?n de un artista.
     */
    public Boolean rateArtist(Long id,Float rating);
    /**
     * Este metodo esta dise?ado para la calificaci?n actual del artista en especifico.
     * @param id es el identificador unico del artista.
     * @return rating es la variable designada para retornar la calificaci?n del artista.
     */
    public Float getRatingArtist(Long id);
    
    /**
     * Search artists by name
     * @param artistName
     * @return 
     */
    public List<ResumeDTO> searchArtistByName(String artistName);
    
    /**
     * search Artists Between Ratings
     * @param artistMinRating
     * @param artistMaxRating
     * @return 
     */
    public List<ResumeDTO> searchArtistsBetweenRatings(float artistMinRating,float artistMaxRating);
}
