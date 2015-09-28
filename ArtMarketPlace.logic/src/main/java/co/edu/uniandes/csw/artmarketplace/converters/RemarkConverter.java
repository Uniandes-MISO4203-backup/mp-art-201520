/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.converters;

import co.edu.uniandes.csw.artmarketplace.dtos.RemarkDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkEntity;
import co.edu.uniandes.csw.artmarketplace.entities.RemarkEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Convertidor para comentario.
 */
public class RemarkConverter
{

    public RemarkConverter()
    {
        
    }

    /**
     * Entidad a DTO.
     * @param entity
     * @return
     */
    public static RemarkDTO refEntity2DTO(RemarkEntity entity)
    {
        if (entity != null) {
            RemarkDTO dto = new RemarkDTO();
            dto.setId(entity.getId());
            dto.setRemarkUser(entity.getRemarkUser());
            dto.setDescription(entity.getDescription());
            dto.setRemarkDate(entity.getRemarkDate());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * DTO a entidad.
     * @param dto
     * @return
     */
    public static RemarkEntity refDTO2Entity(RemarkDTO dto)
    {
        if (dto != null) {
            RemarkEntity entity = new RemarkEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static RemarkDTO basicEntity2DTO(RemarkEntity entity)
    {
        if (entity != null) {
            RemarkDTO dto = new RemarkDTO();
            dto.setId(entity.getId());
            dto.setRemarkUser(entity.getRemarkUser());
            dto.setUserType(entity.getUserType());
            dto.setDescription(entity.getDescription());
            dto.setRemarkDate(entity.getRemarkDate());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static RemarkEntity basicDTO2Entity(RemarkDTO dto) {
        if (dto != null) {
            RemarkEntity entity = new RemarkEntity();
            entity.setId(dto.getId());
            entity.setRemarkUser(dto.getRemarkUser());
            entity.setUserType(dto.getUserType());
            entity.setDescription(dto.getDescription());
            entity.setRemarkDate(dto.getRemarkDate());

            return entity;
        } else {
            return null;
        }
    }


    /**
     * @param entity
     * @return 
     */
         public static RemarkDTO fullEntity2DTO(RemarkEntity entity) {
             if (entity != null) {
                 RemarkDTO dto = basicEntity2DTO(entity);
                 return dto;
             } else {
                 return null;
             }
         }


         /**
          * @param dto
          * @return 
          */
         public static RemarkEntity fullDTO2Entity(RemarkDTO dto) {
             if (dto != null) {
                 RemarkEntity entity = basicDTO2Entity(dto);
                 return entity;
             } else {             
                 return null;
             }
         }


        /**
         * 
         * @param entities
         * @return 
         */
         public static List<RemarkDTO> listEntity2DTO(List<RemarkEntity> entities) {
             List<RemarkDTO> dtos = new ArrayList<RemarkDTO>();
             if (entities != null) {
                 for (RemarkEntity entity : entities) {
                     dtos.add(basicEntity2DTO(entity));
                 }
             }
             return dtos;
         }


         /**
          * @param dtos
          * @return 
          */
         public static List<RemarkEntity> listDTO2Entity(List<RemarkDTO> dtos) {
             List<RemarkEntity> entities = new ArrayList<RemarkEntity>();
             if (dtos != null) {
                 for (RemarkDTO dto : dtos) {
                     entities.add(basicDTO2Entity(dto));
                 }
             }
             return entities;
         }

        /**
         * @param dto
         * @param parent
         * @return 
         */
         public static RemarkEntity childDTO2Entity(RemarkDTO dto, ArtworkEntity parent)
         {
             RemarkEntity entity = basicDTO2Entity(dto);
             entity.setArtwork(parent);
             return entity;
         }

         /**
          * @param dtos
          * @param parent
          * @return 
          */
         public static List<RemarkEntity> childListDTO2Entity(List<RemarkDTO> dtos, ArtworkEntity parent)
          {                                                                                  
            List<RemarkEntity> entities = new ArrayList<RemarkEntity>();
                  if (dtos != null) {
                      for (RemarkDTO dto : dtos) {
                          entities.add(childDTO2Entity(dto, parent));
                      }
                  }
                  return entities;
              }
          }
