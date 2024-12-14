package dev.umang.productserviceexciteddec24.services;

import dev.umang.productserviceexciteddec24.models.Product;

import java.util.List;

//Interface - like a contract
public interface ProductService {

    Product getSingleProduct(long id);

    List<Product> getAllProducts();

}

/*
Client - Controller - Service
 */
