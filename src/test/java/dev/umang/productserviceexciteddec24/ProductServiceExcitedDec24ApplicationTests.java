package dev.umang.productserviceexciteddec24;

import dev.umang.productserviceexciteddec24.models.Category;
import dev.umang.productserviceexciteddec24.models.Product;
import dev.umang.productserviceexciteddec24.projections.ProductWithIdAndPriceProjection;
import dev.umang.productserviceexciteddec24.repository.CategoryRepository;
import dev.umang.productserviceexciteddec24.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceExcitedDec24ApplicationTests {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void testProductRepository(){
//        List<Product> products = productRepository.findAllByCategory_Title("books");
//        System.out.println(products);

//        List<ProductWithIdAndPriceProjection> product = productRepository.getProductTitlesAndPricesAndAGivenCategoryName("books");
//
//        for(ProductWithIdAndPriceProjection productWithIdAndPriceProjection:product){
//            System.out.println(productWithIdAndPriceProjection.getPrice() + " " + productWithIdAndPriceProjection.getId());
//        }
//        System.out.println();

        Optional<Category> category = categoryRepository.findById(2L);

        System.out.println(category.get());

    }

}
