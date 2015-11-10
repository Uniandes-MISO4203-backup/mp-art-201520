/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.services;

import co.edu.uniandes.csw.artmarketplace.converters.TypeConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.TypeDTO;
import co.edu.uniandes.csw.artmarketplace.persistence.TypePersistence;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Servicio de los tipos de formato de obras
 *
 * @author jd.garcia1381
 */
@Path("/types")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TypeService {

    /**
     * Expone los servicios del backup de experiencia
     */
    @Inject
    private TypePersistence persistence;

    @GET
    public List<TypeDTO> getTypes() {
        return TypeConverter.listEntity2DTO(persistence.findAll(null, null));
    }
}
