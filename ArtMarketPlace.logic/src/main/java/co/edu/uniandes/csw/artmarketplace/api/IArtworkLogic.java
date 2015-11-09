package co.edu.uniandes.csw.artmarketplace.api;

import co.edu.uniandes.csw.artmarketplace.dtos.ArtworkDTO;
import co.edu.uniandes.csw.artmarketplace.dtos.ClientDTO;
import co.edu.uniandes.csw.artmarketplace.entities.ArtworkRatingEntity;
import java.util.List;

public interface IArtworkLogic {
    public int countArtworks();
    public List<ArtworkDTO> getArtworks(Integer page, Integer maxRecords);
    public ArtworkDTO getArtwork(Long id);
    public ArtworkDTO createArtwork(ArtworkDTO dto);
    public ArtworkDTO updateArtwork(ArtworkDTO dto);
    public void deleteArtwork(Long id);
    public List<ArtworkDTO> findByName(String name);
    /**
     * Search artist with cheapest artwork
     * @param artworkName
     * @return 
     */
    public List<ArtworkDTO> searchArtistWithCheapestArtwork(String artworkName);
    /**
     * Search cheapest artwork of an artist
     * @param artistName
     * @return 
     */
    public List<ArtworkDTO> searchCheapestArtworkOfAnArtist(String artistName);
    
    /**
     * Search cheapest artwork of an artist
     * @param name
     * @return 
     */
    public List<ArtworkDTO> searchArtworksOfAnArtist(String name);
    /**
     * Search artworks betewwn prices
     * @param artworkMinPrice
     * @param artworkMaxPrice
     * @return 
     */
    public List<ArtworkDTO> searchArtworksBetweenPrices(int artworkMinPrice,int artworkMaxPrice);
    /**
     * Search artworks by style
     * @param artworkStyle
     * @return 
     */
    public List<ArtworkDTO> searchArtworksByStyle(String artworkStyle);
    /**
     * Search artworks by type
     * @param artworkType
     * @return 
     */
    public List<ArtworkDTO> searchArtworksByType(String artworkType);
    /**
     * Search artworks between ratings
     * @param artworkMinRating
     * @param artworkMaxRating
     * @return 
     */
    public List<ArtworkDTO> searchArtworksBetweenRatings(float artworkMinRating, float artworkMaxRating);
    
    /**
     * Este metodo esta disennado para recibir la votacion realizar por un cliente frente a una obra de arte en especifico.
     * @param rating es la valoracion hecha por el cliente.
     * @param id es el identificador unico del obra de arte.
     * @param client es el cliente quien realizo la calificación.
     * @return confirmation es la variable designada para confirmar que se ha hecho la calificacion de una obra de arte.
     */
    public Boolean rateArtwork(Long id,ClientDTO client,Float rating);
    /**
     * Este metodo esta disennado para la calificacion actual de la obra de arte en especifico.
     * @param id es el identificador unico de la obra de arte.
     * @return rating es la variable designada para retornar la calificacion de la  obra de arte.
     */
    public Float getRatingArtwork(Long id);
    
    /**
     * Este metodo esta disennado para verificar si un cliente previamente ha calificado una
     * obra de arte.
     * @param client es el cliente a verificar
     * @param list es la lista de clientes que han calificado la obra de arte previamente.
     * @return retorna falso si el cliente con anterioridad ha calificado la obra, y true si no lo ha hecho.
     */
    public Boolean checkPreviewRatingByClient(ClientDTO client, List<ArtworkRatingEntity> list);
}
