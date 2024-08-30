package com.rojmicro.question1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rojmicro.question1.model.QuestionWrapper;
import com.rojmicro.question1.model.Questions;
import com.rojmicro.question1.model.Response;
import com.rojmicro.question1.repo.QuestionRepo;
@Service
public class QuestionService {
	
	@Autowired
	QuestionRepo qr;
	

	public ResponseEntity<List<Questions>> getAllQuestions(){
		
		
		try {
            return new ResponseEntity<>(qr.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		
	}


	public ResponseEntity<List<Questions>> getQuestionsByCatagory(String category) {
		try {
            return new ResponseEntity<>(qr.findByCategory(category),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}


	public ResponseEntity<String> addQuestion(Questions question) {
		qr.save(question);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
	}


	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions) {
		//return null;
		List<Integer> questions = qr.findRandomQuestionsByCategory(categoryName, numQuestions);
        return new ResponseEntity<>(questions, HttpStatus.OK);
	}


	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
		List<QuestionWrapper> wrappers = new ArrayList<>();
        List<Questions> questions = new ArrayList<>();

        for(Integer id : questionIds){
            questions.add(qr.findById(id).get());
        }

        for(Questions question : questions){
            QuestionWrapper wrapper = new QuestionWrapper();
            wrapper.setId(question.getId());
            wrapper.setQuestion(question.getQuestion());
            wrapper.setOption1(question.getOption1());
            wrapper.setOption2(question.getOption2());
            wrapper.setOption3(question.getOption3());
            wrapper.setOption4(question.getOption4());
            wrappers.add(wrapper);
        }

        return new ResponseEntity<>(wrappers, HttpStatus.OK);
	}


	public ResponseEntity<Integer> getScore(List<Response> responses) {
		int right = 0;
        for(Response response : responses){
            Questions question = qr.findById(response.getId()).get();
            if(response.getResponse().equals(question.getAns()))
                right++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
	}

}
