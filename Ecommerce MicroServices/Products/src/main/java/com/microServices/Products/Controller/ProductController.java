package com.microServices.Products.Controller;


import com.microServices.Products.DTO.ProductRequestDTO;
import com.microServices.Products.DTO.ProductResponseDTO;
import com.microServices.Products.Model.Product;
import com.microServices.Products.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDTO> getAllProducts(){

        return productService.getAllProducts();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductRequestDTO productRequestDTO){

        productService.addNewProduct(productRequestDTO);
    }
}
