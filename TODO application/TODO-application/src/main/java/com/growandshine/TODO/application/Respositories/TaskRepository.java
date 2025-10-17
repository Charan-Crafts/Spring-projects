package com.growandshine.TODO.application.Respositories;

import com.growandshine.TODO.application.Entites.Tasks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends MongoRepository<Tasks,String> {
    Optional<List<Tasks>> findAllByStatus(String status);
}
