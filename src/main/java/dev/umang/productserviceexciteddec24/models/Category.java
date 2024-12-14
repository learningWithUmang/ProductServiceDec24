package dev.umang.productserviceexciteddec24.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;



public class Category extends BaseModel{
    private String title;

    private List<Product> products; //electronics

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}


/*
Some common attributes

id,
createdAt,
lastModified
 */