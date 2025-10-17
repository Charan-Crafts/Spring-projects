package com.microservice.Order_Module.Repo;

import com.microservice.Order_Module.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
