package com.microservice.Inventory_service.Service;

import com.microservice.Inventory_service.Repository.InventoryRespostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private InventoryRespostiory inventoryRespostiory;


    public boolean checkTheStock(String skucode) {

        return inventoryRespostiory.findBySkuCode(skucode).isPresent();
    }
}
