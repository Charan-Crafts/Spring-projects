package com.microServices.Products;

import com.microServices.Products.DTO.ProductRequestDTO;
import com.microServices.Products.Model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistrar;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import com.fasterxml.jackson.databind.ObjectMapper;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductsApplicationTests {


    @Autowired
    MockMvc mockMvc;

    // Object mapper for converting the DTO into the string

    @Autowired
    ObjectMapper objectMapper;

    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:8.0.15");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
        dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);

    }

    @Test
    void testForProductCreation() throws Exception {

        ProductRequestDTO productRequestDTO = getProductRequestDTO();

        // convert it into the string

        String prouductRequest = objectMapper.writeValueAsString(productRequestDTO);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(prouductRequest)
                )
                .andExpect(status().isCreated());
    }

    // get the ProductRequest

    public ProductRequestDTO getProductRequestDTO() {
        return ProductRequestDTO.builder()
                .name("i phone")
                .descirption("i phone")
                .price(12312.32)
                .build();
    }


}
