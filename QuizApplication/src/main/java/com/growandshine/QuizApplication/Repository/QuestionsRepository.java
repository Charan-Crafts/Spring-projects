package com.growandshine.QuizApplication.Repository;

import com.growandshine.QuizApplication.Entites.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuestionsRepository extends JpaRepository<Question,Long> {

    Optional<List<Question>>  findByTopic(String category);

    @Query(value = "select * from question q where q.topic =:topic ORDER BY RAND() LIMIT :numQ",nativeQuery = true)
    List<Question> findByQuizTopic(String topic, long numQ);
}
