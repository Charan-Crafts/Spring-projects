package com.mongo.Data.Migration.MongoMigration;


import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document

@Getter
@Setter
public class User {

    @Id
    private ObjectId userId;

    private String userName;

    private String password;

    private String email;
}

