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
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author lf.mendivelso10
 */
@Stateless
public class QuestionLogic implements IQuestionLogic{
    
    @Inject private QuestionPersistence persistence;

    public int countQuestions() {
        return persistence.count();
    }

    public List<QuestionDTO> getQuestions(Integer page, Integer maxRecords) {
        return QuestionConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    public QuestionDTO getQuestion(Long id) {
        return QuestionConverter.fullEntity2DTO(persistence.find(id));
    }

    public QuestionDTO createQuestion(QuestionDTO dto) {
        QuestionEntity entity = QuestionConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return QuestionConverter.fullEntity2DTO(entity);
    }

    public QuestionDTO updateQuestion(QuestionDTO dto) {
        QuestionEntity entity = persistence.update(QuestionConverter.fullDTO2Entity(dto));
        return QuestionConverter.fullEntity2DTO(entity);
    }

    public void deleteQuestion(Long id) {
        persistence.delete(id);
    }
    
    
    
}
