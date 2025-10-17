package com.microservice.Order_Module.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {

    private List<OrderItemsDTO> orderItems;
}
