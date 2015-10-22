package co.edu.uniandes.csw.artmarketplace.ejbs;

import co.edu.uniandes.csw.artmarketplace.api.IClientLogic;
import co.edu.uniandes.csw.artmarketplace.converters.ClientConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.ClientDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ClientEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.ClientPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class ClientLogic implements IClientLogic {

    @Inject
    private ClientPersistence persistence;

    /**
     * @generated
     */
    @Override
    public int countClients() {
        return persistence.count();
    }

    /**
     * @generated
     */
    @Override
    public List<ClientDTO> getClients(Integer page, Integer maxRecords) {
        return ClientConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    @Override
    public ClientDTO getClient(Long id) {
        return ClientConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    @Override
    public ClientDTO createClient(ClientDTO dto) {
        ClientEntity entity = ClientConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return ClientConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    @Override
    public ClientDTO updateClient(ClientDTO dto) {
        ClientEntity entity = persistence.update(ClientConverter.fullDTO2Entity(dto));
        return ClientConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    @Override
    public void deleteClient(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    @Override
    public List<ClientDTO> findByName(String name) {
        return ClientConverter.listEntity2DTO(persistence.findByName(name));
    }

    @Override
    public ClientDTO getClientByUserId(String userId) {
        return ClientConverter.refEntity2DTO(persistence.getClientByUserId(userId));
    }
}
