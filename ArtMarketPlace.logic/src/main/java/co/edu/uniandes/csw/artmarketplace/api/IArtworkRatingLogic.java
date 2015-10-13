/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.api;

/**
 * La interface IArtworkRatingLogic esta diseñada para definir
 * las funciones disponibles para la logica de la calificacion de obras de arte.
 * @author lf.mendivelso10
 */
public interface IArtworkRatingLogic {
    
    /**
     * Este metodo esta disennado para recibir la votacion realizar por un cliente frente a una obra de arte en especifico.
     * @param rating es la valoracion hecha por el cliente.
     * @param id es el identificador unico del obra de arte.
     * @return confirmation es la variable designada para confirmar que se ha hecho la calificacion de una obra de arte.
     */
    public Boolean rateArtwork(Long id,Float rating);
    /**
     * Este metodo esta disennado para la calificacion actual de la obra de arte en especifico.
     * @param id es el identificador unico de la obra de arte.
     * @return rating es la variable designada para retornar la calificacion de la  obra de arte.
     */
    public Float getRatingArtwork(Long id);
    
}
