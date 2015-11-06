package co.edu.uniandes.csw.artmarketplace.converters;

import co.edu.uniandes.csw.artmarketplace.dtos.CartItemDTO;
import co.edu.uniandes.csw.artmarketplace.entities.CartItemEntity;
import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.artmarketplace.entities.ClientEntity;

/**
 * @generated
 */
public abstract class CartItemConverter {

    /**
     * @generated
     */
    private CartItemConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static CartItemDTO refEntity2DTO(CartItemEntity entity) {
        if (entity != null) {
            CartItemDTO dto = new CartItemDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setState(entity.getState());
            dto.setQuantity(entity.getQuantity());

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
    public static CartItemEntity refDTO2Entity(CartItemDTO dto) {
        if (dto != null) {
            CartItemEntity entity = new CartItemEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * 
     * @param entity
     * @return 
     */
    public static CartItemDTO basicEntity2DTO(CartItemEntity entity) {
        if (entity != null) {
            CartItemDTO dto = new CartItemDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setState(entity.getState());
            dto.setQuantity(entity.getQuantity());
            dto.setArtwork(ArtworkConverter.basicEntity2DTO(entity.getArtwork()));
            dto.setClient(ClientConverter.refEntity2DTO(entity.getClient()));

            return dto;
        } else {
            return null;
        }
    }

    /**
     * 
     * @param dto
     * @return 
     */
    public static CartItemEntity basicDTO2Entity(CartItemDTO dto) {
        if (dto != null) {
            CartItemEntity entity = new CartItemEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setQuantity(dto.getQuantity());
            entity.setState(dto.getState());
            entity.setArtwork(ArtworkConverter.basicDTO2Entity(dto.getArtwork()));
            entity.setClient(ClientConverter.refDTO2Entity(dto.getClient()));

            return entity;
        } else {
            return null;
        }
    }

    /**
     * 
     * @param entity
     * @return 
     */
    public static CartItemDTO fullEntity2DTO(CartItemEntity entity) {
        if (entity != null) {
            return basicEntity2DTO(entity);
        } else {
            return null;
        }
    }

    /**
     * 
     * @param dto
     * @return 
     */
    public static CartItemEntity fullDTO2Entity(CartItemDTO dto) {
        if (dto != null) {
            return basicDTO2Entity(dto);
        } else {
            return null;
        }
    }

    /**
     * 
     * @param entities
     * @return 
     */
    public static List<CartItemDTO> listEntity2DTO(List<CartItemEntity> entities) {
        List<CartItemDTO> dtos = new ArrayList<CartItemDTO>();
        if (entities != null) {
            for (CartItemEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * 
     * @param dtos
     * @return 
     */
    public static List<CartItemEntity> listDTO2Entity(List<CartItemDTO> dtos) {
        List<CartItemEntity> entities = new ArrayList<CartItemEntity>();
        if (dtos != null) {
            for (CartItemDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

    /**
     * 
     * @param dto
     * @param parent
     * @return 
     */
    public static CartItemEntity childDTO2Entity(CartItemDTO dto, ClientEntity parent){
        CartItemEntity entity = basicDTO2Entity(dto);
        entity.setClient(parent);
        return entity;
    }

    /**
     * 
     * @param dtos
     * @param parent
     * @return 
     */
    public static List<CartItemEntity> childListDTO2Entity(List<CartItemDTO> dtos, ClientEntity parent) {
        List<CartItemEntity> entities = new ArrayList<CartItemEntity>();
        if (dtos != null) {
            for (CartItemDTO dto : dtos) {
                entities.add(childDTO2Entity(dto, parent));
            }
        }
        return entities;
    }
}
