package dev.umang.productserviceexciteddec24.services;

import dev.umang.productserviceexciteddec24.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService{
    @Override
    public Product getSingleProduct(long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
