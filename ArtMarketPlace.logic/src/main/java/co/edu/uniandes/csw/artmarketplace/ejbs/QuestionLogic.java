/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.ejbs;

import co.edu.uniandes.csw.artmarketplace.api.IQuestionLogic;
import co.edu.uniandes.csw.artmarketplace.converters.QuestionConverter;
import co.edu.uniandes.csw.artmarketplace.dtos.QuestionDTO;
import co.edu.uniandes.csw.artmarketplace.entities.QuestionEntity;
import co.edu.uniandes.csw.artmarketplace.persistence.QuestionPersistence;
import java.io.FileNotFoundException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author lf.mendivelso10
 */
@Stateless
public class QuestionLogic implements IQuestionLogic {

    @Inject
    private QuestionPersistence persistence;

    @Override
    public int countQuestions() {
        return persistence.count();
    }

    @Override
    public List<QuestionDTO> getQuestions(Integer page, Integer maxRecords) {
        return QuestionConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    @Override
    public QuestionDTO getQuestion(Long id) {
        return QuestionConverter.fullEntity2DTO(persistence.find(id));
    }

    @Override
    public QuestionDTO createQuestion(QuestionDTO dto) {
        QuestionEntity entity = QuestionConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return QuestionConverter.fullEntity2DTO(entity);
    }

    @Override
    public QuestionDTO updateQuestion(QuestionDTO dto) {
        QuestionEntity entity = persistence.update(QuestionConverter.fullDTO2Entity(dto));
        return QuestionConverter.fullEntity2DTO(entity);
    }

    @Override
    public void deleteQuestion(Long id) {
        persistence.delete(id);
    }

    @Override
    public boolean sendEmail(QuestionDTO dto, Properties props) {
        boolean sucessful = false;
        try {
            // Sesión de Usuario
            Session session = Session.getDefaultInstance(props);
            String destinatario = dto.getEmail();
            String emisor = props.getProperty("mail.smtp.user");
            String contrasenna = "UniandesArt";
            String mensaje = "El usuario " + dto.getClient().getName() + " ha realizado una pregunta sobre "
                    + "la obra de arte " + dto.getArtwork().getName() + ".\n \n "
                    + "Pregunta:\n"
                    + "" + dto.getQuestion() + "\n"
                    + "\nFecha de creación: " + dto.getDate().toLocaleString();

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(emisor));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject("ArtMarketPlace - MIS2015 - Ha recibido una pregunta sobre su obra de arte.");
            message.setText(mensaje);

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect(emisor, contrasenna);
            t.sendMessage(message, message.getAllRecipients());
        }
        catch (MessagingException ex) {
            Logger.getLogger(QuestionLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucessful;
    }
}
