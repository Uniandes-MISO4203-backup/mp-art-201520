package co.edu.uniandes.csw.artmarketplace.dtos;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO Resume hace referencia a la hoja de vida que tiene un artista. En esta se
 * manejan sus principales atributos y relaciones.
 *
 * @author vp.salcedo93
 */
@XmlRootElement
public class ResumeDTO extends BasicDTO {

    /**
     * Foto del artista
     */
    private String photo;

    /**
     * Ciudad del artista.
     */
    private String city;
    /**
     * Pais del artista
     */
    private String country;

    /**
     * Pagina web o blog personal del artista.
     */
    private String website;
    /**
     * Registros de educacion o experiencia.
     */
    private List<ExperienceDTO> experience;
    /**
     * Artista de la hoja de vida.
     */
    private ArtistDTO artist;
    /**
     * Apellido del artista.
     */
    private String lastName;

    /**
     * ratingSum es la variable utilizada para acumular las calificaciones
     * recibidas por los clientes hacia el artista, para finales del calculo del
     * promedio.
     */
    private Float ratingSum;

    /**
     * ratingVotes es la variable utilizada para totalizar la cantidad de votos
     * recibidos por parte de los clientes hacia el artisita, para finles del
     * calculo de su promedio.
     */
    private Float ratingVotes;

    /**
     * Metodo que obtiene el apellido del artista.
     *
     * @return String Apellido del artista.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Metodo que actualiza el apellido del artista.
     *
     * @param lastName cade de caracteres con el nuevo apellido del artista.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Metodo para obtener el artista de la hoja de vida.
     *
     * @return DTO del artista.
     */
    public ArtistDTO getArtist() {
        return artist;
    }

    /**
     * Metodo para actualizar el artista de la hoja de vida.
     *
     * @param artist Nuevo artista (Objeto DTO).
     */
    public void setArtist(ArtistDTO artist) {
        this.artist = artist;
    }

    /**
     * Metodo que obtiene la lista de los registros de experiencia o educacion.
     *
     * @return Lista de las entidades de expereiencia.
     */
    public List<ExperienceDTO> getExperience() {
        return experience;
    }

    /**
     * Metodo que actualiza la lista de registros.
     *
     * @param experience. Nueva lista de experiencia y/o educacion.
     */
    public void setExperience(List<ExperienceDTO> experience) {
        this.experience = experience;
    }

    /**
     * Metodo para obtener la ciudad del artista de la hoja de vida
     *
     * @return String. Nombre de la ciudad a la que pertenece el artista.
     */
    public String getCity() {
        return city;
    }

    /**
     * Metodo para actualizar el identificador de la hoja de vida
     *
     * @param city. Nuevo nombre de la ciudad del artista de la hoja de vida.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Metodo para obtener el pais del artista de la hoja de vida
     *
     * @return String. Nombre del pais al que pertenece el artista.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Metodo para actualizar el identificador de la hoja de vida
     *
     * @param country. Nuevo nombre del pais del artista de la hoja de vida.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Metodo para obtener la pagina web del artista.
     *
     * @return String. Cadena de caracteres con la URL del artista.
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Metodo para actualizar la pagina web del artista.
     *
     * @param website. Nueva cadena de caracteres con la URL del artista.
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Metodo para obtener la foto del artista
     *
     * @return Url de la foto
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Metodo para actualizar la foto
     *
     * @param photo Nueva Url de la foto del artista.
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * Es un metodo de acceso que tiene como finalidad retornar el valor actual
     * del ratingSum del artista.
     *
     * @return ratingSum es la sumatoria de calificaciones recibidas por el
     * artista.
     */
    public Float getRatingSum() {
        return ratingSum;
    }

    /**
     * Es un metodo de acceso que tiene como finalidad modificar el valor actual
     * del ratingSum del artista.
     *
     * @param ratingSum
     */
    public void setRatingSum(Float ratingSum) {
        this.ratingSum = ratingSum;
    }

    /**
     * Es un metodo de acceso que tiene como finalidad retornar el valor actual
     * del ratingVotes del artista.
     *
     * @return ratingVotes es la cantidad de votos de calificaci?n recibidas por
     * el artista.
     */
    public Float getRatingVotes() {
        return ratingVotes;
    }

    /**
     * Es un metodo de acceso que tienen como finalidad modificar el valor
     * actual del ratingVotes del artista.
     *
     * @param ratingVotes es el nuevo valor del total de votos de calificacion
     * recibidas por el artista.
     */
    public void setRatingVotes(Float ratingVotes) {
        this.ratingVotes = ratingVotes;
    }

}
