package com.rojmicro.question1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rojmicro.question1.model.QuestionWrapper;
import com.rojmicro.question1.model.Questions;
import com.rojmicro.question1.model.Response;
import com.rojmicro.question1.repo.QuestionRepo;
import com.rojmicro.question1.service.QuestionService;


@RestController
@RequestMapping("question")
public class QuestionsController {
	@Autowired
	QuestionRepo qr;
	@Autowired
	QuestionService qs;
	
	
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Questions>> getAllQuestions(Model m) {
		return qs.getAllQuestions();
		
	}
	
	@GetMapping("/allQuestions/{category}")
	public ResponseEntity<List<Questions>> getQuestionsByCategory(@PathVariable String category) {
		return qs.getQuestionsByCatagory(category);
		
	}
	
	@PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Questions question){
        return  qs.addQuestion(question);
    }
	
	@GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@RequestParam String categoryName, @RequestParam Integer numQuestions ){
        return qs.getQuestionsForQuiz(categoryName, numQuestions);
    }
	
//	@GetMapping("generate/{categoryName}/{numQuestions}")
//    public ResponseEntity<List<Integer>> getQuestionsForQuiz
//            (@PathVariable String categoryName, @PathVariable Integer numQuestions ){
//        return qs.getQuestionsForQuiz(categoryName, numQuestions);
//    }
	
	@PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
        //System.out.println(environment.getProperty("local.server.port"));
        return qs.getQuestionsFromId(questionIds);
    }
	
	@PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
    {
        return qs.getScore(responses);
    }
}
