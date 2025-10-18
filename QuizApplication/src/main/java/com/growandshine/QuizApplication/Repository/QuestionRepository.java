package com.growandshine.QuizApplication.Repository;

import com.growandshine.QuizApplication.Entites.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Questions,Long> {

    List<Questions> findByCategory(String category);

    @Query(value = "SELECT * FROM QUESTIONS Q WHERE Q.CATEGORY=:category ORDER BY RAND() LIMIT :numQuestions",nativeQuery = true)
    List<Questions> randomQuestions(String category,Long numQuestions);
}
