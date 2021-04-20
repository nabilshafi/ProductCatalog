package com.product.catalog.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Product {

    @Id
    private Long id;
    private String description;
    private String price;

    @ManyToOne
    private Category category;

    public Product() {

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @Embedded
    private Attributes attributes;

    @JsonCreator
    public Product(Long id, String description, String price, Category category, Attributes attributes) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.category = category;
        this.attributes = attributes;
    }
}
