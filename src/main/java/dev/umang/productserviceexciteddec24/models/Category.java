package dev.umang.productserviceexciteddec24.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Entity
public class Category extends BaseModel{
    private String title;

    //duplicate relation(already mentioned in product class)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = {CascadeType.REMOVE})
    @JsonIgnore
    private List<Product> products; //electronics

    //deletes a category
    //deleting cat_id = 4
    //Product
    //cat_id column
    //Category : Product : 1 : m
    //Read about cascade types and fk constraints.

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