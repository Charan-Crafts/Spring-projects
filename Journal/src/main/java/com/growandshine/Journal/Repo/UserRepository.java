package com.growandshine.Journal.Repo;

import com.growandshine.Journal.Entites.User;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    Optional<User> findByUserName(String userName);
}
