package dev.umang.productserviceexciteddec24.controllers;

import dev.umang.productserviceexciteddec24.dtos.CreateProductRequestDTO;
import dev.umang.productserviceexciteddec24.models.Product;
import dev.umang.productserviceexciteddec24.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;
    //Contructor injection

    public ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
    }
    //Dependency injection
    //3apis

    //getProductDetails
    //products/3

    @GetMapping("/products/{id}")
    Product getSingleProduct(@PathVariable("id") long id){
        return productService.getSingleProduct(id);
    }

    @GetMapping("/products")
    List<Product> getAllProducts(){
        return productService.getAllProducts();

    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO){
        return productService.createProduct(createProductRequestDTO.getTitle(),
                createProductRequestDTO.getDescription(),
                createProductRequestDTO.getImage(),
                createProductRequestDTO.getCategory(),
                createProductRequestDTO.getPrice());
    }

    //HW - Create a ResponseDTO and send that object instead of Product directly

    //productService.createProduct
    //productService.getAllProducts
}
