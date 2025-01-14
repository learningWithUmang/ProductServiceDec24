package dev.umang.productserviceexciteddec24.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
public class Product extends BaseModel{
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    //Eager - fetched as part of main object
    //lazy - not fetched as part of main object
    private String title;
    private String description;
    private double price;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Category category;
    //Product : Category => m : 1
    //fk constraints
    //deleting a products, category?
    //1 -> cat_id = 5
    //adding a new prod => 4,
    //yellow giraffe=>4, teddy_bears
    private String imageUrl;

    //P:O
    //@OneToOne
    //private Order order;
}
/*
Product Category
Relation = Cardinality

Product Category
1       1
M        1
P : C
M : 1

are you defining a fk constraint?
Category_id = act like a foregin key in the product table
fk constraints
when you delete a product, what do you want to do with that category?

1 1

In your product table, will you have a category id column?

Order
@Entity

@
List<Product>
 */
