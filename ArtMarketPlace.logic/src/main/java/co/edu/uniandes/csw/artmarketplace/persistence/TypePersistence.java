/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.persistence;

import co.edu.uniandes.csw.artmarketplace.entities.TypeEntity;
import javax.ejb.Stateless;

/**
 *
 * @author jd.garcia1381
 */
@Stateless
public class TypePersistence extends CrudPersistence<TypeEntity> {
    public TypePersistence() {
        this.entityClass = TypeEntity.class;
    }
}
