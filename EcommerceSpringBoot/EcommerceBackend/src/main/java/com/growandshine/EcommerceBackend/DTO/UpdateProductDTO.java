package com.growandshine.EcommerceBackend.DTO;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductDTO {
    private String name;

    private String description;

    private String brand;

    private BigDecimal price;

    private String category;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private Date releaseDate;

    private boolean productAvailable=false;

    private int stockQuantity;
}
//name: "",
//description: "",
//brand: "",
//price: "",
//category: "",
//releaseDate: "",
//productAvailable: false,
//stockQuantity: "",