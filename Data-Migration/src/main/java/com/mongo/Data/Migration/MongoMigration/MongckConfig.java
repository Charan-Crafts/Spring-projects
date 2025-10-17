package com.mongo.Data.Migration.MongoMigration;

import io.mongock.driver.mongodb.springdata.v4.driver.MongoSync4Driver;
import io.mongock.runner.springboot.MongockSpringboot;
import io.mongock.runner.springboot.base.MongockInitializingBeanRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongckConfig {

    @Bean
    public MongockInitializingBeanRunner mongockRunner(
            MongoTemplate mongoTemplate,
            ApplicationContext applicationContext) {

        return MongockSpringboot.builder()
                .setDriver(new MongoSync4Driver(mongoTemplate.getMongoDatabaseFactory().getMongoDatabase()))
                .addMigrationScanPackage("com.mongo.Data.Migration")
                .setSpringContext(applicationContext)
                .setTransactionEnabled(false)  // ← CRITICAL: Disable transactions
                .setTrackIgnored(false)
                .buildInitializingBeanRunner();
    }
}