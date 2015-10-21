/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.persistence;

import co.edu.uniandes.csw.artmarketplace.entities.ArtworkRatingEntity;
import javax.ejb.Stateless;

/**
 *
 * @author lf.mendivelso10
 */
@Stateless
public class ArtworkRatingPersistence extends CrudPersistence<ArtworkRatingEntity> {

    /**
     * El metodo constructor de ArtworkRatingPersistence no contiene parametro,
     * y en su ejecucion, hace la asignacion del tipo de EntityClass requerida
     * para la uso del CrudPersistence.
     */
    public ArtworkRatingPersistence() {
        this.entityClass = ArtworkRatingEntity.class;
    }
}