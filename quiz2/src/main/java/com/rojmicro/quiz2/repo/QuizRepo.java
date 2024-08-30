package com.rojmicro.quiz2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rojmicro.quiz2.model.Quiz;

public interface QuizRepo extends JpaRepository<Quiz,Integer> {

}
