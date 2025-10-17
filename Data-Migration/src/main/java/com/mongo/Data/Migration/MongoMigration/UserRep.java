package com.mongo.Data.Migration.MongoMigration;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRep extends MongoRepository<User, ObjectId> {
}
