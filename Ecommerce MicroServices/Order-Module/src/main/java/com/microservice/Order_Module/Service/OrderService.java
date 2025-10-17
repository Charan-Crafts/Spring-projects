package com.microservice.Order_Module.Service;


import com.microservice.Order_Module.DTO.OrderItemsDTO;
import com.microservice.Order_Module.DTO.OrderRequest;
import com.microservice.Order_Module.Model.OrderLineItems;
import com.microservice.Order_Module.Model.Orders;
import com.microservice.Order_Module.Repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public void createNewOrder(OrderRequest orderRequest) {

        Orders newOrder = new Orders();
        newOrder.setOrderId(UUID.randomUUID().toString());

       newOrder.setOrderLineItemsList(orderRequest.getOrderItems().stream()
                .map(this::convertDtoToObject).toList()
       );

       orderRepository.save(newOrder);


    }

    //get the dto of orderitemlist into the Object
    public OrderLineItems convertDtoToObject(OrderItemsDTO orderItemsDTO){
        return OrderLineItems.builder()
                .skuCode(orderItemsDTO.getSkuCode())
                .quantity(orderItemsDTO.getQuantity())
                .price(orderItemsDTO.getPrice())
                .build();
    }
}
