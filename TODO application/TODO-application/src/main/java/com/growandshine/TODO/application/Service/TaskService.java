package com.growandshine.TODO.application.Service;

import com.growandshine.TODO.application.DTO.TaskRequest;
import com.growandshine.TODO.application.DTO.TaskResponse;
import com.growandshine.TODO.application.Entites.Tasks;
import com.growandshine.TODO.application.Respositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public ResponseEntity<List<TaskResponse>> getAllTasks() {

        List<Tasks> getAllTask = taskRepository.findAll();

        List<TaskResponse> taskReponse = getAllTask.stream()
                .map(task->TaskResponse.builder()
                        .id(task.getId())
                        .taskName(task.getTaskName())
                        .status(task.getStatus())
                        .deadLine(task.getDeadLine())
                        .build()
                ).toList();

        return new ResponseEntity<>(taskReponse, HttpStatus.OK);
    }

    public ResponseEntity<String> addNewTask(TaskRequest taskRequest) {

        Tasks newTask = new Tasks();
        newTask.setTaskName(taskRequest.getTaskName());
        newTask.setStatus("pending");
        newTask.setDeadLine(taskRequest.getDeadline());

        taskRepository.save(newTask);

        return new ResponseEntity<>("Task is added",HttpStatus.CREATED);
    }

    public ResponseEntity<String> completeTask(String id) {

        Tasks getTask = taskRepository.findById(id).orElse(null);

        if(getTask==null){
            return new ResponseEntity<>("No task founded",HttpStatus.BAD_REQUEST);
        }
        getTask.setStatus("Completed");
        taskRepository.save(getTask);

        return new ResponseEntity<>("Updated the task Status 😊",HttpStatus.OK);
    }

    public ResponseEntity<List<TaskResponse>> getPendingTask(String status) {

        List<Tasks> pendingTask = taskRepository.findAllByStatus(status).orElse(null);

        if(pendingTask==null){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        }

        List<TaskResponse> taskResponses = pendingTask.stream()
                .map(task->
                        TaskResponse.builder()
                                .id(task.getId())
                                .taskName(task.getTaskName())
                                .status(task.getStatus())
                                .deadLine(task.getDeadLine())
                                .build())
                .toList();

        return new ResponseEntity<>(taskResponses,HttpStatus.OK);

    }

    public ResponseEntity<String> deleteTaskById(String id) {

        taskRepository.deleteById(id);

        return new ResponseEntity<>("Task deleted",HttpStatus.OK);
    }
}
