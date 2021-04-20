package com.product.catalog.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
public class Category {

    @Id
    private Long id;
    private String name;


    @OneToMany
    private List<Product> product;

    public Category(){}

}
