package edu.miu.cs545.project.service.impl;



import edu.miu.cs545.project.model.entity.*;
import edu.miu.cs545.project.repository.SurveyAnswerChoiceRepo;
import edu.miu.cs545.project.repository.SurveyViewRepo;
import edu.miu.cs545.project.service.SurveyViewService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SurveyViewServiceImpl extends CrudServiceImpl<SurveyView,Long> implements SurveyViewService {
    private final SurveyViewRepo surveyViewRepository;
    private final SurveyAnswerChoiceRepo surveyChoiceVotesRepo;

    public SurveyViewServiceImpl(SurveyViewRepo repository, SurveyAnswerChoiceRepo surveyChoiceVotesRepo) {
        super(repository);
        this.surveyViewRepository = repository;
        this.surveyChoiceVotesRepo = surveyChoiceVotesRepo;
    }

    public SurveyView createSurveyView(Survey survey) {
        SurveyView surveyView = new SurveyView();
        surveyView.setTitle(survey.getTitle());


        Map<String, SurveyQuestionView> questionViews = new HashMap<>();
        for (SurveyQuestion surveyQuestion : survey.getSurveyQuestions()) {
            SurveyQuestionView questionView = createQuestionView(surveyQuestion, surveyView,survey);
            questionViews.put(questionView.getQuestion(), questionView);
        }
        surveyView.setQuestionViews(questionViews);

        return surveyViewRepository.save(surveyView);
    }

    private SurveyQuestionView createQuestionView(SurveyQuestion surveyQuestion, SurveyView surveyView, Survey survey) {
        SurveyQuestionView questionView = new SurveyQuestionView();
        questionView.setQuestion(surveyQuestion.getQuestion());
        questionView.setTotalVotes(0);
        questionView.setSurveyView(surveyView);

        // Initialize choice votes
        for (edu.miu.cs545.project.model.entity.SurveyAnswerChoice surveyAnswerChoice : surveyQuestion.getAnswers()) {
            SurveyChoiceVotes choiceVotes = new SurveyChoiceVotes();
            choiceVotes.setChoiceDescription(surveyAnswerChoice.getDescription());
            choiceVotes.setVoteCount(0);
            choiceVotes.setQuestionView(questionView);
            questionView.getChoiceVotes().add(choiceVotes);
        }

        // Count votes for each choice
        for (SurveyResponse surveyResponse : surveyQuestion.getResponses()) {
            Character responseChoice = surveyResponse.getResponse();
            for (SurveyChoiceVotes choiceVotes : questionView.getChoiceVotes()) {
                for (SurveyAnswerChoice choices : surveyChoiceVotesRepo.findAll()){
                    if (choices.getDescription().equals(choiceVotes.getChoiceDescription())) {
                        if (choices.getChoice().equals(responseChoice)) {
                            choiceVotes.setVoteCount(choiceVotes.getVoteCount() + 1);
                            questionView.setTotalVotes(questionView.getTotalVotes() + 1);
                        }
                    }
                }
            }
        }

        return questionView;
    }
}

