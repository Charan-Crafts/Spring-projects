package com.microservice.Order_Module.Repo;

import com.microservice.Order_Module.Model.OrderLineItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderLineItems,Long> {
}
