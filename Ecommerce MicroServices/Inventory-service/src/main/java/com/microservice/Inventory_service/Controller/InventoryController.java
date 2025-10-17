package com.microservice.Inventory_service.Controller;

import com.microservice.Inventory_service.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/{skucode}")
    @ResponseStatus(HttpStatus.FOUND)
    public boolean isInStock(String skucode){

        return inventoryService.checkTheStock(skucode);
    }
}
