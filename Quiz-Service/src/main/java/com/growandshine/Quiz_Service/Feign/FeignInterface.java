package com.growandshine.Quiz_Service.Feign;

import com.growandshine.Quiz_Service.DTO.EvaluateQuizResponse;
import com.growandshine.Quiz_Service.DTO.QuestionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "QUESTION-SERVICE")
public interface FeignInterface {

    @GetMapping("question/generate")
    public ResponseEntity<List<Long>> generateQuestions(@RequestParam String category, @RequestParam long numberofquestions) ;

    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionResponse>> getQuestionsByIds(@RequestBody List<Long> questionIds) ;

    @PostMapping("question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<EvaluateQuizResponse> evaluateQuizResponse) ;
}
