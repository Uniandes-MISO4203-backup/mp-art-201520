
package co.edu.uniandes.csw.artmarketplace.dtos;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * QuestionDTO es una clase que tiene como finalidad sevir de intermediador entre las distintas
 * capas de logicas del software, principalmente para el manejo de las preguntas realizadas por
 * los comprador respecto una obra de arte. 
 * @author lf.mendivelso10
 */

@XmlRootElement
public class QuestionDTO {
    /**
     * Id es el campo de identificador unico de la pregunta realizada por el comprador.
     */
    private Long id;
    
    /**
     * artwork es la referencia de la obra de arter de la cual se esta preguntando.
     */
    private ArtworkDTO artwork;
    
    /**
     * client es la referencia del comprador quien hace la pregunta.
     */
    private ClientDTO client;
    
    
    /**
     * date es la fecha de creacion de la pregunta sobre la obra de arte.
     */
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
     * artistEmail es el correo del destinatario.
     */
    private String artistEmail;
    
    /**
     * Es un metodo de acceso que retorna el identificador unico de la pregunta.
     * @return id es el identificador unico de la pregunta.
     */ 
    public Long getId() {
        return id;
    }

    /**
     * Es un metodo de acceso que modifica el identificador unico de la pregunta.
     * @param id es nuevo identificador unico asignado a la pregunta.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Es un metodo de acceso que retorna la obra de arte de la cual el comprador hace la pregunta.
     * @return artwork es la obra de arte.
     */
    public ArtworkDTO getArtwork() {
        return artwork;
    }

    /**
     * Es un metodo de acceso que modifica la informacion de la obra de arte de la cual un comprador hizo la pregunta.
     * @param artwork es la nueva referenciada de obra de arte asignada a la pregunta.
     */
    public void setArtwork(ArtworkDTO artwork) {
        this.artwork = artwork;
    }

    /**
     * Es un metodo de acceso que retorno la fecha de creacion de la pregunta realizada por un comprador
     * sobre una obra de arte.
     * @return date es la fecha de creacion de la pregunta.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Es un metodo de acceso que modifica la fecha de creacion de la pregunta realizada por un comprador.
     * @param date es la modificacion hecha la fecha de creacion de la pregunta.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Es un metodo de acceso que retorno la informacion del cliente quien realiza la pregunta. 
     * @return clien es el comprador que hace la pregunta.
     */
    public ClientDTO getClient() {
        return client;
    }

    /**
     * Es un metodo de acceso que modifica la informacion del comprador que realiza una pregunta
     * respecto a una obra de arte.
     * @param client es el nuevo comprador asignado a la pregunta.
     */
    public void setClient(ClientDTO client) {
        this.client = client;
    }

    /**
     * Es un metodo de accesso que retorna el correo de contacto del comprador que realiza la pregunta
     * sobre una obra de arte.
     * @return email es el correo del comprador.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Es un metodo de acceso que modifica el correo de contacto del comprador que
     * hace la pregunta sobre una obra de arte.
     * @param email es el nuevo correo de contacto del comprador.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Es un metodo de acceso que retorna la pregunta realizada por un comprador sobre una
     * obra de arte en especifico.
     * @return 
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Es un metodo de acceso que modifica la pregunta realizada por el comprador sobre la
     * obra de artes de su interes.
     * @param question es la modificacion de la pregunta del comprador.
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Es un metodo de acceso que retorna el correo del destinatario de la pregunta.
     * @return retorna el correo del artista.
     */
    public String getArtistEmail() {
        return artistEmail;
    }

    /**
     * Es un metodo de acceso que modifica el correo del destinatario de la pregunta.
     * @param artistEmail es el correo del artista.
     */
    public void setArtistEmail(String artistEmail) {
        this.artistEmail = artistEmail;
    }
    
    
}
