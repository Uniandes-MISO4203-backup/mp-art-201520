/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * La Entidad Resume hace referencia a la hoja de vida que tiene un artista. 
 * En esta se manejan sus principales atributos y relaciones.
 * @author vp.salcedo93
 */
@Entity
@NamedQueries(
{@NamedQuery(name = "Resume.getByArtistId", query = "SELECT r FROM ResumeEntity r left join fetch r.experience WHERE r.artist.id=:artist_id")}
)
public class ResumeEntity implements Serializable {
    
    /**
     * Identificador de la hoja de vida de un artista.
     */
    @Id
    @GeneratedValue(generator = "Resume")
    private Long id;
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
     * ratingSum es la variable utilizada para acumular las calificaciones recibidas por los clientes hacia el artista, para finales del calculo del promedio.
     */
    private Float ratingSum;
    
    /**
     * ratingVotes es la variable utilizada para totalizar la cantidad de votos recibidos por parte de los clientes hacia el artisita, para finles del calculo de su promedio.
     */
    private Float ratingVotes;
    /**
     * Registros de educacion o experiencia.
     */
    @OneToMany(mappedBy="resume", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<ExperienceEntity> experience;
    
    /**
     * Artista de la hoja de vida.
     */
    @OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name="ARTIST_ID")
    private ArtistEntity artist;
    /**
     * Apellido del artista.
     */
    private String lastName;
    /**
     * Metodo que obtiene el apellido del artista.
     * @return String Apellido del artista.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Metodo que actualiza el apellido del artista.
     * @param lastName cade de caracteres con el nuevo apellido del artista.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * Metodo para obtener el artista de la hoja de vida.
     * @return Entidad del artista.
     */
    public ArtistEntity getArtist() {
        return artist;
    }
    /**
     * Metodo para actualizar el artista de la hoja de vida.
     * @param artist Nuevo artista (Objeto entidad).
     */
    public void setArtist(ArtistEntity artist) {
        this.artist = artist;
    }
    /**
     * Metodo que obtiene la lista de los registros de experiencia o educacion.
     * @return Lista de las entidades de expereiencia.
     */
    public List<ExperienceEntity> getExperience() {
        return experience;
    }
    /**
     * Metodo que actualiza la lista de registros.
     * @param experience. Nueva lista de experiencia y/o educacion.
     */
    public void setExperience(List<ExperienceEntity> experience) {
        this.experience = experience;
    }
    
    /**
     * Metodo para obtener el identificador de la hoja de vida
     * @return Long. Identificador de la hoja de vida.
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Metodo para actualizar el identificador de la hoja de vida
     * @param id. Nuevo identificador de la hoja de vida del artista. 
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Metodo para obtener la ciudad del artista de la hoja de vida
     * @return String. Nombre de la ciudad a la que pertenece el artista.
     */
    public String getCity() {
        return city;
    }
    /**
     * Metodo para actualizar el identificador de la hoja de vida
     * @param city. Nuevo nombre de la ciudad del artista de la hoja de vida. 
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * Metodo para obtener el pais del artista de la hoja de vida
     * @return String. Nombre del pais al que pertenece el artista.
     */
    public String getCountry() {
        return country;
    }
    /**
     * Metodo para actualizar el identificador de la hoja de vida
     * @param country. Nuevo nombre del pais del artista de la hoja de vida. 
     */
    public void setCountry(String country) {
        this.country = country;
    }
    
    /**
     * Metodo para obtener la pagina web del artista.
     * @return String. Cadena de caracteres con la URL del artista.
     */
    public String getWebsite() {
        return website;
    }
    /**
     * Metodo para actualizar la pagina web del artista.
     * @param website. Nueva cadena de caracteres con la URL del artista.
     */
    public void setWebsite(String website) {
        this.website = website;
    }
    /**
     * Metodo para obtener la foto del artista
     * @return Url de la foto
     */
    public String getPhoto() {
        return photo;
    }
    /**
     * Metodo para actualizar la foto
     * @param photo Nueva Url de la foto del artista.
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    /**
     * Es un metodo de acceso que tiene como finalidad retornar el valor actual del ratingSum del artista.
     * @return ratingSum es la sumatoria de calificaciones recibidas por el artista.
     */
    public Float getRatingSum() {
        return ratingSum;
    }

    /**
     * Es un metodo de acceso que tiene como finalidad modificar el valor actual del ratingSum del artista. 
     * @param ratingSum 
     */
    public void setRatingSum(Float ratingSum) {
        this.ratingSum = ratingSum;
    }

    /**
     * Es un metodo de acceso que tiene como finalidad retornar el valor actual del ratingVotes del artista.
     * @return ratingVotes es la cantidad de votos de calificaci?n recibidas por el artista.
     */
    public Float getRatingVotes() {
        return ratingVotes;
    }

    /**
     * Es un metodo de acceso que tienen como finalidad modificar el valor actual del ratingVotes del artista.
     * @param ratingVotes es el nuevo valor del total de votos de calificacion recibidas por el artista.
     */
    public void setRatingVotes(Float ratingVotes) {
        this.ratingVotes = ratingVotes;
    }
    
}
