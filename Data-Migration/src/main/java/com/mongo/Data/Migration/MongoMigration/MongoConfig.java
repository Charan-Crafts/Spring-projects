package com.mongo.Data.Migration.MongoMigration;


import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackBeforeExecution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import java.util.List;

@ChangeUnit(id = "addEmailtoExistinguser",order = "001",author = "Charan")
public class MongoConfig {

    @Execution
    public void addEmailtoUser(MongoTemplate mongoTemplate){

        Query query = new Query(Criteria.where("email").exists(false));


        List<User> usersWithOutEmail = mongoTemplate.find(query,User.class);

        for(User user :usersWithOutEmail){
            user.setEmail("unknown@example.com");
            mongoTemplate.save(user);
        }
        System.out.println("User email is updated");
    }

    @RollbackExecution
    public void rollback(MongoTemplate mongoTemplate) {
        // Optional: Remove the default email if rollback is needed
        Query query = new Query(Criteria.where("email").is("unknown@example.com"));

        List<User> usersWithDefaultEmail = mongoTemplate.find(query, User.class);

        for (User user : usersWithDefaultEmail) {
            user.setEmail(null);
            mongoTemplate.save(user);
        }

        System.out.println("🔄 Rollback: Removed default email from " + usersWithDefaultEmail.size() + " users");
    }

}
