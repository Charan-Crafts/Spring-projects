package com.microservice.Order_Module.Controller;


import com.microservice.Order_Module.DTO.OrderRequest;
import com.microservice.Order_Module.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public String createOrder(@RequestBody OrderRequest orderRequest){

        orderService.createNewOrder(orderRequest);
        return "Order created";
    }
}
