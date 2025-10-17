package com.microServices.Products.Service;

import com.microServices.Products.DTO.ProductRequestDTO;
import com.microServices.Products.DTO.ProductResponseDTO;
import com.microServices.Products.Model.Product;
import com.microServices.Products.Repo.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductResponseDTO> getAllProducts() {

        List<Product> products = productRepository.findAll();

        return products.stream().map(this::convertProductDTOResponse).toList();

    }

    public ProductResponseDTO convertProductDTOResponse(Product product) {

        return ProductResponseDTO.builder()
                .name(product.getName())
                .id(product.getId())
                .descirption(product.getDescirption())
                .price(product.getPrice())
                .build();


    }

    public void addNewProduct(ProductRequestDTO productRequestDTO) {

        Product newProduct = Product.builder()
                .name(productRequestDTO.getName())
                .price(productRequestDTO.getPrice())
                .descirption(productRequestDTO.getDescirption())
                .build();

        productRepository.save(newProduct);

        log.info("product id {}",newProduct.getId());

    }
}
