package com.microservice.Order_Module.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String orderId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")  // This column will be created in OrderLineItems table
    private List<OrderLineItems> orderLineItemsList;
}
