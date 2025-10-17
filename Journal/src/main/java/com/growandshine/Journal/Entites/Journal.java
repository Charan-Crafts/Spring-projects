package com.growandshine.Journal.Entites;


import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Document
@Data
@Getter
@Setter
public class Journal {

    @Id
    private ObjectId journalId;

    @NonNull
    private String journalTitle;

    @NonNull
    private String journalContent;

    private LocalDate createdAt;

}
