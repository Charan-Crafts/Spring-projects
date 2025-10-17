package com.growandshine.EcommerceBackend.Repositories;

import com.growandshine.EcommerceBackend.Entites.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
