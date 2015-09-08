package co.edu.uniandes.csw.artmarketplace.converters;

import co.edu.uniandes.csw.artmarketplace.dtos.PaymentDTO;
import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.artmarketplace.entities.ClientEntity;
import co.edu.uniandes.csw.artmarketplace.entities.PaymentEntity;

/**
 * @generated
 */
public abstract class PaymentConverter {

    /**
     * @generated
     */
    private PaymentConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static PaymentDTO refEntity2DTO(PaymentEntity entity) {
        if (entity != null) {
            PaymentDTO dto = new PaymentDTO();
            dto.setId(entity.getId());
            dto.setMethod(entity.getMethod());
            dto.setSubtotal(entity.getSubtotal());
            dto.setTaxes(entity.getTaxes());
            dto.setTotal(entity.getTotal());
            dto.setCardNumber(dto.getCardNumber());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return
     * @generated
     */
    public static PaymentEntity refDTO2Entity(PaymentDTO dto) {
        if (dto != null) {
            PaymentEntity entity = new PaymentEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static PaymentDTO basicEntity2DTO(PaymentEntity entity) {
        if (entity != null) {
            PaymentDTO dto = new PaymentDTO();
            dto.setId(entity.getId());
            dto.setMethod(entity.getMethod());
            dto.setSubtotal(entity.getSubtotal());
            dto.setTaxes(entity.getTaxes());
            dto.setTotal(entity.getTotal());
            dto.setCardNumber(entity.getCardNumber());
            dto.setClient(ClientConverter.refEntity2DTO(entity.getClient()));

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static PaymentEntity basicDTO2Entity(PaymentDTO dto) {
        if (dto != null) {
            PaymentEntity entity = new PaymentEntity();
            entity.setId(dto.getId());
            entity.setMethod(dto.getMethod());
            entity.setSubtotal(dto.getSubtotal());
            entity.setTaxes(dto.getTaxes());
            entity.setTotal(dto.getTotal());
            entity.setCardNumber(dto.getCardNumber());
            entity.setClient(ClientConverter.refDTO2Entity(dto.getClient()));

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static PaymentDTO fullEntity2DTO(PaymentEntity entity) {
        if (entity != null) {
            return basicEntity2DTO(entity);
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static PaymentEntity fullDTO2Entity(PaymentDTO dto) {
        if (dto != null) {
            return basicDTO2Entity(dto);
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<PaymentDTO> listEntity2DTO(List<PaymentEntity> entities) {
        List<PaymentDTO> dtos = new ArrayList<PaymentDTO>();
        if (entities != null) {
            for (PaymentEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<PaymentEntity> listDTO2Entity(List<PaymentDTO> dtos) {
        List<PaymentEntity> entities = new ArrayList<PaymentEntity>();
        if (dtos != null) {
            for (PaymentDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

    /**
     * @generated
     */
    public static PaymentEntity childDTO2Entity(PaymentDTO dto, ClientEntity parent){
        PaymentEntity entity = basicDTO2Entity(dto);
        entity.setClient(parent);
        return entity;
    }

    /**
     * @generated
     */
    public static List<PaymentEntity> childListDTO2Entity(List<PaymentDTO> dtos, ClientEntity parent) {
        List<PaymentEntity> entities = new ArrayList<PaymentEntity>();
        if (dtos != null) {
            for (PaymentDTO dto : dtos) {
                entities.add(childDTO2Entity(dto, parent));
            }
        }
        return entities;
    }
}
