package dev.umang.productserviceexciteddec24.services;

import dev.umang.productserviceexciteddec24.dtos.CreateProductRequestDTO;
import dev.umang.productserviceexciteddec24.models.Category;
import dev.umang.productserviceexciteddec24.models.Product;
import dev.umang.productserviceexciteddec24.repository.CategoryRepository;
import dev.umang.productserviceexciteddec24.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(
            ProductRepository productRepository,
            CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getSingleProduct(long id) {
        return null;
    }
    //HW to implement this? - 1 line or max 2 lines


    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
        //get all products from product table
    }

    @Override
    public Product createProduct(String title,
                                 String description,
                                 String image,
                                 String category,//aparrel
                                 double price) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);

        //cate object
        //prodict.setCategory(cate obj)

        //You need to get the corresponding category object from the
        //category table -> you need to check with a category with the
        //name in the param exist or not?

        Category categoryFromDB = categoryRepository.findByTitle(category);

        if(categoryFromDB == null){
            Category newCategory = new Category();
            newCategory.setTitle(category);
            product.setCategory(newCategory);
            //categoryRepository.save(newCategory); //category insert before product
        }else{
            product.setCategory(categoryFromDB);
        }

        //insert the prod in prod table?


        Product createdProduct = productRepository.save(product);
        //fk contrainsts

        return createdProduct;
    }
}
