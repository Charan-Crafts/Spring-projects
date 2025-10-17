package com.growandshine.EcommerceBackend.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddproductRequest {

    private String name;

    private String description;

    private String brand;

    private BigDecimal price;

    private String category;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private Date releaseDate;

    private boolean available;

    private int quantity;
}
