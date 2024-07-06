package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.SurveyAnswerChoice;
import edu.miu.cs545.project.model.entity.SurveyChoiceVotes;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyAnswerChoiceRepo extends GenericRepo<SurveyAnswerChoice, Long>{
    SurveyAnswerChoice  findById(long id);
    List<SurveyAnswerChoice> findByDescription(String description);
    List<SurveyAnswerChoice> findByQuestion_Id(long Id);
    SurveyAnswerChoice findByChoice(Character varying);

}
