package com.mongo.Data.Migration;

import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongock
public class DataMigrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataMigrationApplication.class, args);
	}

}
