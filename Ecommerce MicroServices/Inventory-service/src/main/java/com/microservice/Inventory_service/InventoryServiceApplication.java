package com.microservice.Inventory_service;

import com.microservice.Inventory_service.Model.Inventory;
import com.microservice.Inventory_service.Repository.InventoryRespostiory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

    @Bean
    public CommandLineRunner loadData(InventoryRespostiory inventoryRespostiory){

        return args -> {
            Inventory inventory = new Inventory();
            inventory.setSkuCode("iphone_13");
            inventory.setQuantity(12);

            Inventory inventory1 = new Inventory();
            inventory1.setSkuCode("iphone_17");
            inventory1.setQuantity(12);

            inventoryRespostiory.save(inventory);
            inventoryRespostiory.save(inventory1);
        };
    }
}
