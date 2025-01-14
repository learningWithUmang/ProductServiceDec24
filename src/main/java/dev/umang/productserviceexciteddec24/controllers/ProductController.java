package dev.umang.productserviceexciteddec24.controllers;

import dev.umang.productserviceexciteddec24.dtos.CreateProductRequestDTO;
import dev.umang.productserviceexciteddec24.exceptions.ProductNotFoundException;
import dev.umang.productserviceexciteddec24.models.Product;
import dev.umang.productserviceexciteddec24.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
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
    Product getSingleProduct(@PathVariable("id") long id) throws ProductNotFoundException {
        //either handle the exception or throw it further
        return productService.getSingleProduct(id);
    }

    @GetMapping("/products")
    List<Product> getAllProducts(){
        return productService.getAllProducts();

    }

    @GetMapping("/products/paginated")
    //accept filter params which you're going to provide to the service
    Page<Product> getPaginatedProducts(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){
        //should i return page of prod or list of prod to the frontend??
        //please explore how to convert Page<T> to List<T> - HW
        return productService.getPaginatedProducts(pageNo, pageSize);
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
