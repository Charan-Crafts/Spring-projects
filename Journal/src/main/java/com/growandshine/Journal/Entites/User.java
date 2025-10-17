package com.growandshine.Journal.Entites;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document

@Data
public class User {

    @Id
    private ObjectId userId;

    @Indexed(unique = true)
    @NonNull
    private String userName;

    @NonNull
    private String password;

    @DBRef
    private List<Journal> journalEntries = new ArrayList<>();

}
