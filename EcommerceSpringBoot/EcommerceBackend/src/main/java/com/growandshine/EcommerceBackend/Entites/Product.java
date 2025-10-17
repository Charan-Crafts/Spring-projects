package com.growandshine.EcommerceBackend.Entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String id;

    private String name;

    private String description;

    private String brand;

    private BigDecimal price;

    private String category;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private Date releaseDate;

    private boolean available;

    private int quantity;

    private String imageName;

    private String imageType;

    private byte[] imageData;


}
