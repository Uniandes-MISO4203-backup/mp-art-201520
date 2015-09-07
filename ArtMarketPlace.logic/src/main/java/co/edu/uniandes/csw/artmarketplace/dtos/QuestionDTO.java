
package co.edu.uniandes.csw.artmarketplace.dtos;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * QuestionDTO es una clase que tiene como finalidad sevir de intermediador entre las distintas
 * capas de lógicas del software, principalmente para el manejo de las preguntas realizadas por
 * los comprador respecto una obra de arte. 
 * @author lf.mendivelso10
 */

@XmlRootElement
public class QuestionDTO {
    /**
     * Id es el campo de identificador único de la pregunta realizada por el comprador.
     */
    public Long id;
    
    /**
     * artwork es la referencia de la obra de arter de la cual se esta preguntando.
     */
    public ArtworkDTO artwork;
    
    /**
     * client es la referencia del comprador quien hace la pregunta.
     */
    public ClientDTO client;
    
    
    /**
     * date es la fecha de creación de la pregunta sobre la obra de arte.
     */
    public Date date;
    
    /**
     * email es es la cuenta de correo del usuario a la cual se espera que el artista de respuesta
     * a su pregunta.
     */
    public String email;
    
    /**
     * question es el campo dispuesto para que el usuario haga la pregunta respecto a la obra de
     * arte.
     */    
    public String question;

    
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
    public ArtworkDTO getArtwork() {
        return artwork;
    }

    /**
     * Es un método de acceso que módifica la información de la obra de arte de la cual un comprador hizo la pregunta.
     * @param artwork es la nueva referenciada de obra de arte asignada a la pregunta.
     */
    public void setArtwork(ArtworkDTO artwork) {
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
    public ClientDTO getClient() {
        return client;
    }

    /**
     * Es un método de acceso que modifica la informacion del comprador que realiza una pregunta
     * respecto a una obra de arte.
     * @param client es el nuevo comprador asignado a la pregunta.
     */
    public void setClient(ClientDTO client) {
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
     * @return 
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
}
