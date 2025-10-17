package com.growandshine.EcommerceBackend.Services;

import com.growandshine.EcommerceBackend.DTO.AddproductRequest;
import com.growandshine.EcommerceBackend.DTO.UpdateProductDTO;
import com.growandshine.EcommerceBackend.Entites.Product;
import com.growandshine.EcommerceBackend.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> getAllProducts = productRepository.findAll();

        return new ResponseEntity<>(getAllProducts, HttpStatus.OK);
    }

    public ResponseEntity<String> addNewProduct(AddproductRequest addproductRequest, MultipartFile imageFile) throws IOException {

        Product newProduct = new Product();
        newProduct.setName(addproductRequest.getName());
        newProduct.setBrand(addproductRequest.getBrand());
        newProduct.setCategory(addproductRequest.getCategory());
        newProduct.setDescription(addproductRequest.getDescription());
        newProduct.setPrice(addproductRequest.getPrice());
        newProduct.setReleaseDate(addproductRequest.getReleaseDate());
        newProduct.setAvailable(addproductRequest.isAvailable());
        newProduct.setQuantity(addproductRequest.getQuantity());

        if(imageFile!=null && !imageFile.isEmpty()){
            newProduct.setImageData(imageFile.getBytes());
            newProduct.setImageName(imageFile.getOriginalFilename());
            newProduct.setImageType(imageFile.getContentType());
        }

        productRepository.save(newProduct);

        return new ResponseEntity<>("Product added",HttpStatus.CREATED);
    }

    public ResponseEntity<byte[]> getProductImage(String id) {

        Product getProduct = productRepository.findById(id).orElse(null);

        byte[] imageFile = getProduct.getImageData();

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(getProduct.getImageType()))
                .body(imageFile);
    }

    public ResponseEntity<Product> getProductById(String id) {

        Product getproduct = productRepository.findById(id).orElse(null);

        return new ResponseEntity<>(getproduct,HttpStatus.OK);
    }

    public ResponseEntity<String> updateProduct(String id,UpdateProductDTO updateProductDTO, MultipartFile imageFile) throws IOException {

        // Find the product

        Product product = productRepository.findById(id).orElse(null);

        product.setName(updateProductDTO.getName()!=null && updateProductDTO.getName()!=""?updateProductDTO.getName():product.getName());
        product.setDescription(updateProductDTO.getDescription()!=null && updateProductDTO.getDescription()!=""?updateProductDTO.getDescription():product.getDescription());
        product.setBrand(updateProductDTO.getBrand()!=null && updateProductDTO.getBrand()!=""?updateProductDTO.getBrand():product.getBrand());
        product.setPrice(updateProductDTO.getPrice()!=null ?updateProductDTO.getPrice():product.getPrice());
        product.setCategory(updateProductDTO.getCategory()!=null && updateProductDTO.getCategory()!=""?updateProductDTO.getCategory():product.getCategory());
        product.setReleaseDate(updateProductDTO.getReleaseDate()!=null ?updateProductDTO.getReleaseDate():product.getReleaseDate());
        product.setQuantity(updateProductDTO.getStockQuantity());

        product.setImageType(imageFile.getContentType());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageData(imageFile.getBytes());
        productRepository.save(product);

        return new ResponseEntity<>("Updated",HttpStatus.OK);
    }
}
