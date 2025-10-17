package com.growandshine.QuizApplication.Repository;

import com.growandshine.QuizApplication.Entites.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quizz,Long> {
}
