package com.microservice.Inventory_service.Repository;

import com.microservice.Inventory_service.Controller.InventoryController;
import com.microservice.Inventory_service.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRespostiory extends JpaRepository<Inventory,Long> {

    Optional<InventoryController> findBySkuCode(String skuCode);
}
