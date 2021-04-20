package com.product.catalog.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
public class Product {

    @Id
    private Long id;
    private String description;
    private String price;

    @Embedded
    private Attributes attributes;


    public Product() {}

}
