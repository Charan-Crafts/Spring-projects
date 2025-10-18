package com.growandshine.Question_Service.Repository;

import com.growandshine.Question_Service.Entites.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Questions,Long> {

    List<Questions> findByCategory(String category);

    @Query(value = "SELECT Q.id FROM QUESTIONS Q WHERE Q.CATEGORY=:category ORDER BY RAND() LIMIT :numQuestions",nativeQuery = true)
    List<Integer> randomQuestions(String category, Long numQuestions);
}
