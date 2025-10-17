package com.growandshine.QuizApplication.Controller;

import com.growandshine.QuizApplication.DTO.QuestionRequest;
import com.growandshine.QuizApplication.DTO.QuestionResponse;
import com.growandshine.QuizApplication.Service.QuestionService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping()
    public List<QuestionResponse> getAllQuestions(){

        return questionService.getAllQuestions();
    }

    @GetMapping("/{category}")
    public List<QuestionResponse> fetchBasedUponCategory(@PathVariable String category){

        return questionService.fetchBasedUponCategory(category);
    }

    @PostMapping("/add")
    public String addQuestion(@RequestBody QuestionRequest questionRequest){

        return questionService.addQuestion(questionRequest);
    }

    @PutMapping("/update/{id}")
    public String updateQuestion(@RequestBody QuestionRequest questionRequest,@PathVariable long id){

        return questionService.updateQuestion(questionRequest,id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable long id){

        return questionService.deleteQuestion(id);
    }
}
