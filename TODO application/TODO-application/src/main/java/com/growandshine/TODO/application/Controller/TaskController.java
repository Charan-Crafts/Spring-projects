package com.growandshine.TODO.application.Controller;

import com.growandshine.TODO.application.DTO.TaskRequest;
import com.growandshine.TODO.application.DTO.TaskResponse;
import com.growandshine.TODO.application.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("")
    public ResponseEntity<List<TaskResponse>> getAllTask(){

        return taskService.getAllTasks();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNewTask(@RequestBody TaskRequest taskRequest){

        return taskService.addNewTask(taskRequest);
    }

    @PostMapping("/completed/{id}")
    public ResponseEntity<String> completeTask(@PathVariable String id){

        return taskService.completeTask(id);
    }

    @GetMapping("/{pending}")
    public ResponseEntity<List<TaskResponse>> getPendingTask(@PathVariable String pending){

        return taskService.getPendingTask(pending);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable String id){

        return taskService.deleteTaskById(id);
    }

}
