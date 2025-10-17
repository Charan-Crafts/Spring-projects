package com.growandshine.EcommerceBackend.Controller;

import com.growandshine.EcommerceBackend.DTO.AddproductRequest;
import com.growandshine.EcommerceBackend.DTO.UpdateProductDTO;
import com.growandshine.EcommerceBackend.Entites.Product;
import com.growandshine.EcommerceBackend.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/health")
    public String healthCheck(){
        return "Ecommerce Application";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){

        return productService.getAllProducts();
    }

    @PostMapping("/product")
    public ResponseEntity<String> addNewProduct(@RequestPart("product") AddproductRequest addproductRequest, @RequestPart(value="imageFile") MultipartFile imageFile){
        try{
            return productService.addNewProduct(addproductRequest,imageFile);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

//     `http://localhost:8080/api/product/${product.id}/image`,
    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable String id){
        return productService.getProductImage(id);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id){

        return productService.getProductById(id);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable String id, @RequestPart("product")UpdateProductDTO updateProductDTO,@RequestPart MultipartFile imageFile){

        try {
            return productService.updateProduct(id,updateProductDTO,imageFile);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
