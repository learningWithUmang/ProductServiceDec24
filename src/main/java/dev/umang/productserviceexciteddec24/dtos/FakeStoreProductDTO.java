package dev.umang.productserviceexciteddec24.dtos;

import dev.umang.productserviceexciteddec24.models.Category;
import dev.umang.productserviceexciteddec24.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class FakeStoreProductDTO {
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;

    public Product toProduct(){
        Product product = new Product();
        product.setDescription(description);
        product.setTitle(title);
        product.setPrice(price);
        product.setImageUrl(image);

        Category category1 = new Category();
        category1.setTitle(category);
        product.setCategory(category1);

        return product;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
