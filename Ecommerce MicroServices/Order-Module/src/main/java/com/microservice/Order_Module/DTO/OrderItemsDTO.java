package com.microservice.Order_Module.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsDTO {

    private String skuCode;

    private double price;

    private Integer quantity;
}
