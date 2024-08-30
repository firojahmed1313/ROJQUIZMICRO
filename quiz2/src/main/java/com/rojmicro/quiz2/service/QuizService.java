package com.rojmicro.quiz2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rojmicro.quiz2.fiegn.QuizInterface;
import com.rojmicro.quiz2.model.QuestionWrapper;
import com.rojmicro.quiz2.model.Quiz;
import com.rojmicro.quiz2.model.Response;
import com.rojmicro.quiz2.repo.QuizRepo;

public class QuizService {
	
	@Autowired
	QuizRepo qr;
	
	@Autowired
	QuizInterface qf;
	
	public ResponseEntity<String> createQuiz(String categoryName, Integer numQuestions, String title) {
		List<Integer> questions = qf.getQuestionsForQuiz(category, numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        qr.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Quiz quiz = qr.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questions = qf.getQuestionsFromId(questionIds);
        return questions;
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		ResponseEntity<Integer> score = qf.getScore(responses);
        return score;
	}

	

}
