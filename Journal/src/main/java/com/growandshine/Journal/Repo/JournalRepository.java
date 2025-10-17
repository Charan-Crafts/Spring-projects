package com.growandshine.Journal.Repo;

import com.growandshine.Journal.Entites.Journal;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface JournalRepository extends MongoRepository<Journal, ObjectId> {
    Optional<Journal> findByJournalTitle(String journalName);
}

