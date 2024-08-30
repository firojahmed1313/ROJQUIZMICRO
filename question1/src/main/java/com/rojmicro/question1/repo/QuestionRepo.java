package com.rojmicro.question1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.rojmicro.question1.model.Questions;


@Repository
@EnableJpaRepositories
public interface QuestionRepo extends JpaRepository<Questions,Integer> {

	List<Questions> findByCategory(String category);
	
	
	@Query(value = "SELECT q.id FROM questions q Where q.category=:categoryName ORDER BY RAND() LIMIT :numQuestions", nativeQuery = true)
	List<Integer> findRandomQuestionsByCategory(String categoryName, Integer numQuestions);

	

}
