package com.growandshine.QuizApplication.Config;

import com.growandshine.QuizApplication.Entites.Question;
import com.growandshine.QuizApplication.Repository.QuestionsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader {

    private final QuestionsRepository questionsRepository;

    public DataLoader(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            List<Question> questions = List.of(
                    // --- JAVA QUESTIONS ---
                    Question.builder()
                            .question("What is the size of int in Java?")
                            .optionA("4 bytes")
                            .optionB("2 bytes")
                            .optionC("8 bytes")
                            .optionD("Depends on system")
                            .correctAnswer("4 bytes")
                            .difficultyLevel("Easy")
                            .topic("Java")
                            .build(),

                    Question.builder()
                            .question("Which keyword is used to inherit a class in Java?")
                            .optionA("this")
                            .optionB("super")
                            .optionC("extends")
                            .optionD("implements")
                            .correctAnswer("extends")
                            .difficultyLevel("Medium")
                            .topic("Java")
                            .build(),

                    Question.builder()
                            .question("What is JVM in Java?")
                            .optionA("Java Virtual Method")
                            .optionB("Java Visual Machine")
                            .optionC("Java Virtual Machine")
                            .optionD("Java Variable Method")
                            .correctAnswer("Java Virtual Machine")
                            .difficultyLevel("Easy")
                            .topic("Java")
                            .build(),

                    Question.builder()
                            .question("Which data structure uses FIFO in Java?")
                            .optionA("Stack")
                            .optionB("Queue")
                            .optionC("ArrayList")
                            .optionD("HashMap")
                            .correctAnswer("Queue")
                            .difficultyLevel("Medium")
                            .topic("Java")
                            .build(),

                    Question.builder()
                            .question("Which interface is used to sort objects in Java?")
                            .optionA("Serializable")
                            .optionB("Comparable")
                            .optionC("Runnable")
                            .optionD("Cloneable")
                            .correctAnswer("Comparable")
                            .difficultyLevel("Medium")
                            .topic("Java")
                            .build(),

                    Question.builder()
                            .question("What does the 'static' keyword mean in Java?")
                            .optionA("Variable is constant")
                            .optionB("Variable belongs to class")
                            .optionC("Variable is dynamic")
                            .optionD("Variable is protected")
                            .correctAnswer("Variable belongs to class")
                            .difficultyLevel("Medium")
                            .topic("Java")
                            .build(),

                    Question.builder()
                            .question("Which of the following is not a Java keyword?")
                            .optionA("class")
                            .optionB("interface")
                            .optionC("inherit")
                            .optionD("enum")
                            .correctAnswer("inherit")
                            .difficultyLevel("Easy")
                            .topic("Java")
                            .build(),

                    // --- PYTHON QUESTIONS ---
                    Question.builder()
                            .question("What is the output of: print(type([]))?")
                            .optionA("<class 'list'>")
                            .optionB("<class 'tuple'>")
                            .optionC("<class 'dict'>")
                            .optionD("<class 'set'>")
                            .correctAnswer("<class 'list'>")
                            .difficultyLevel("Easy")
                            .topic("Python")
                            .build(),

                    Question.builder()
                            .question("How do you create a function in Python?")
                            .optionA("function myFunc():")
                            .optionB("def myFunc():")
                            .optionC("create myFunc():")
                            .optionD("func myFunc():")
                            .correctAnswer("def myFunc():")
                            .difficultyLevel("Easy")
                            .topic("Python")
                            .build(),

                    Question.builder()
                            .question("What does the 'len()' function do in Python?")
                            .optionA("Returns number of elements")
                            .optionB("Returns type of object")
                            .optionC("Returns last element")
                            .optionD("Returns first index")
                            .correctAnswer("Returns number of elements")
                            .difficultyLevel("Easy")
                            .topic("Python")
                            .build(),

                    Question.builder()
                            .question("Which of these is a mutable data type in Python?")
                            .optionA("tuple")
                            .optionB("int")
                            .optionC("list")
                            .optionD("str")
                            .correctAnswer("list")
                            .difficultyLevel("Medium")
                            .topic("Python")
                            .build(),


                    Question.builder()
                            .question("What is the output of: 3 * 'ab'?")
                            .optionA("abab")
                            .optionB("ab ab ab")
                            .optionC("ababab")
                            .optionD("ab3")
                            .correctAnswer("ababab")
                            .difficultyLevel("Medium")
                            .topic("Python")
                            .build(),

                    Question.builder()
                            .question("Which keyword is used for exception handling in Python?")
                            .optionA("try")
                            .optionB("catch")
                            .optionC("exception")
                            .optionD("error")
                            .correctAnswer("try")
                            .difficultyLevel("Medium")
                            .topic("Python")
                            .build()
            );

            questionsRepository.saveAll(questions);
            System.out.println("15 Java and Python questions inserted.");
        };
    }
}
