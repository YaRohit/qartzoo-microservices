package com.qartzoo.microservices.product.repository;

import com.qartzoo.microservices.product.model.Product;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}