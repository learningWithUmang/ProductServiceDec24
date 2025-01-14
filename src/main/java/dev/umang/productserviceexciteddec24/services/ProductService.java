package dev.umang.productserviceexciteddec24.services;

import dev.umang.productserviceexciteddec24.dtos.CreateProductRequestDTO;
import dev.umang.productserviceexciteddec24.exceptions.ProductNotFoundException;
import dev.umang.productserviceexciteddec24.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

//Interface - like a contract
public interface ProductService {

    Product getSingleProduct(long id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product createProduct(String title,
                          String description,
                          String image,
                          String category,
                          double price);

    Page<Product> getPaginatedProducts(int pageNo, int pageSize);
}

/*
Client - Controller - Service
 */
