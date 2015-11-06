/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.api;

import co.edu.uniandes.csw.artmarketplace.dtos.ArtistDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ExhibitionDTO;

/**
 * La inte
 * @author lf.mendivelso10
 */
public interface IExhibitionLogic {
    /**
     * Metodo encargado de crear la entidad y persistirla en la base de datos correspondiente a la 
     * exhibition en la cual participa un artista.
     * @param dto. objeto DTO con la hoja de vida.
     * @param artist. Artista con la experiencia.
     * @return Objeto DTO que se persistio.
     */
    public ExhibitionDTO createExhibition(ExhibitionDTO dto, ArtistDTO artist);
}
