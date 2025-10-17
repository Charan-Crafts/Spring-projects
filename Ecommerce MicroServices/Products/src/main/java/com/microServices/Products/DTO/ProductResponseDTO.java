package com.microServices.Products.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDTO {

    private String id;

    private String name;

    private String descirption;

    private double price;
}
