/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * QuestionEntity es una entidad diseñada para representar las preguntas que puede hacer un comprador
 * a un artista frente a sus obras de arte, con el propósito de indagar aspectos especificos del producto.
 * @author lf.mendivelso10
 * @version 1.0.0
 * 
 */
@Entity
@NamedQueries(
    @NamedQuery(name="QuestionEntity.listByArtwork",query="select u from QuestionEntity u where u.artwork.id = :artwork_id")
)
public class QuestionEntity implements Serializable{
   
    /**
     * Id es el campo de identificador único de la pregunta realizada por el comprador.
     */
    @Id
    @GeneratedValue(generator = "QuestionEntity")
    private Long id;
    
    /**
     * artwork es la referencia de la obra de arter de la cual se esta preguntando.
     */
    @ManyToOne
    private ArtworkEntity artwork;
    
    /**
     * client es la referencia del comprador quien hace la pregunta.
     */
    @ManyToOne
    private ClientEntity client;
    
    /**
     * artistEmail es el correo de referencia al cual se debe hacer envió la pregunta.
     */
    private String artistEmail;

    /**
     * date es la fecha de creación de la pregunta sobre la obra de arte.
     */
    @Temporal(TemporalType.DATE)
    private Date date;
    
    /**
     * email es es la cuenta de correo del usuario a la cual se espera que el artista de respuesta
     * a su pregunta.
     */
    private String email;
    
    /**
     * question es el campo dispuesto para que el usuario haga la pregunta respecto a la obra de
     * arte.
     */    
    private String question;

    /**
     * Es un método de acceso que retorna el identificador único de la pregunta.
     * @return id es el identificador único de la pregunta.
     */ 
    public Long getId() {
        return id;
    }

    /**
     * Es un método de acceso que modifica el identificador único de la pregunta.
     * @param id es nuevo identificador único asignado a la pregunta.
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Es un método de acceso que retorna la obra de arte de la cual el comprador hace la pregunta.
     * @return artwork es la obra de arte.
     */
    public ArtworkEntity getArtwork() {
        return artwork;
    }
    
    /**
     * Es un método de acceso que módifica la información de la obra de arte de la cual un comprador hizo la pregunta.
     * @param artwork es la nueva referenciada de obra de arte asignada a la pregunta.
     */
    public void setArtwork(ArtworkEntity artwork) {
        this.artwork = artwork;
    }
    
    /**
     * Es un método de acceso que retorno la fecha de creación de la pregunta realizada por un comprador
     * sobre una obra de arte.
     * @return date es la fecha de creación de la pregunta.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Es un método de acceso que modifica la fecha de creación de la pregunta realizada por un comprador.
     * @param date es la modificación hecha la fecha de creación de la pregunta.
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    /**
     * Es un método de acceso que retorno la información del cliente quien realiza la pregunta. 
     * @return clien es el comprador que hace la pregunta.
     */
    public ClientEntity getClient() {
        return client;
    }

    /**
     * Es un método de acceso que modifica la informacion del comprador que realiza una pregunta
     * respecto a una obra de arte.
     * @param client es el nuevo comprador asignado a la pregunta.
     */
    public void setClient(ClientEntity client) {
        this.client = client;
    }

    /**
     * Es un método de accesso que retorna el correo de contacto del comprador que realiza la pregunta
     * sobre una obra de arte.
     * @return email es el correo del comprador.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Es un método de acceso que modifíca el correo de contacto del comprador que
     * hace la pregunta sobre una obra de arte.
     * @param email es el nuevo correo de contacto del comprador.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Es un método de acceso que retorna la pregunta realizada por un comprador sobre una
     * obra de arte en específico.
     * @return question es la pregunta formulada por el cliente.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Es un método de acceso que modifica la pregunta realizada por el comprador sobre la
     * obra de artes de su interes.
     * @param question es la modificación de la pregunta del comprador.
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Es un método de acceso que retorna el correo del destinatario de la pregunta.
     * @return artistEmail es el correo del artista a quien se le pregunta sobre su obra.
     */
    public String getArtistEmail() {
        return artistEmail;
    }

    /**
     * Es un método de acceso que modifica el correo del destinatario de la pregunta.
     * @param artistEmail es el correo del artista a quien se le hace envión del correo.
     */
    public void setArtistEmail(String artistEmail) {
        this.artistEmail = artistEmail;
    }
}
