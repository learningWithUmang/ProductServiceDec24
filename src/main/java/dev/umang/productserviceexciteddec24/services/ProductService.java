package dev.umang.productserviceexciteddec24.services;

import dev.umang.productserviceexciteddec24.dtos.CreateProductRequestDTO;
import dev.umang.productserviceexciteddec24.models.Product;

import java.util.List;

//Interface - like a contract
public interface ProductService {

    Product getSingleProduct(long id);

    List<Product> getAllProducts();

    Product createProduct(String title,
                          String description,
                          String image,
                          String category,
                          double price);
}

/*
Client - Controller - Service
 */
