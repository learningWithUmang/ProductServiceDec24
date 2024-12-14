package dev.umang.productserviceexciteddec24.controllers;

import dev.umang.productserviceexciteddec24.models.Product;
import dev.umang.productserviceexciteddec24.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;
    //Contructor injection

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
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

    //productService.createProduct
    //productService.getAllProducts
}
