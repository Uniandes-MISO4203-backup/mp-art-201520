/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.api;

import co.edu.uniandes.csw.artmarketplace.dtos.QuestionDTO;
import java.util.List;

/**
 *
 * @author lf.mendivelso10
 */
public interface IQuestionLogic {
    
    public int countQuestions();
    public List<QuestionDTO> getQuestions(Integer page, Integer maxRecords);
    public QuestionDTO getQuestion(Long id);
    public QuestionDTO createQuestion(QuestionDTO dto);
    public QuestionDTO updateQuestion(QuestionDTO dto);
    public void deleteQuestion(Long id);
    
}
