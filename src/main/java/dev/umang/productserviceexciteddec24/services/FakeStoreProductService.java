package dev.umang.productserviceexciteddec24.services;

import dev.umang.productserviceexciteddec24.dtos.CreateProductRequestDTO;
import dev.umang.productserviceexciteddec24.dtos.FakeStoreProductDTO;
import dev.umang.productserviceexciteddec24.models.Category;
import dev.umang.productserviceexciteddec24.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    private RedisTemplate redisTemplate;

    public FakeStoreProductService(RestTemplate restTemplate,
                                   RedisTemplate redisTemplate){
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Product getSingleProduct(long id) {
        System.out.println("Debugging 1");
        //Is is to going to fetch product from fakestore?
        /*
        Check for the product with this id in the cache??
        if present, return, else go to db and fetch
         */

        Product cachedProduct = (Product) redisTemplate.opsForHash().get("Products", "Products_" + id); //Products, Products_1
        if(cachedProduct != null){
            /*
            Cache hit
             */
            return cachedProduct;
        }

        // Cache miss
        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTOResponse = restTemplate.getForEntity("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDTO.class);

        System.out.println("Debugging");

        Product response = fakeStoreProductDTOResponse.getBody().toProduct();

        redisTemplate.opsForHash().put("Products", "Products_" + id, response);

        return response;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] fakeStoreProductDTOS = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class);

        List<Product> products = new ArrayList<>();

        for(FakeStoreProductDTO fakeStoreProductDTO: fakeStoreProductDTOS){
            products.add(fakeStoreProductDTO.toProduct());
        }

        return products;
    }

    @Override
    public Product createProduct(String title, String description, String image, String category, double price) {
        return null;
    }

    @Override
    public Page<Product> getPaginatedProducts(int pageNo, int pageSize) {
        return null;
    }
}
