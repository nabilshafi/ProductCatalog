package com.product.catalog.model;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Embeddable
public class Attributes {

    @Id
    private Long id;
    private float size;
    private String brand;
    private String os;

    public Attributes(Long id, float size, String brand, String os) {
        this.id = id;
        this.size = size;
        this.brand = brand;
        this.os = os;
    }


    public Attributes() {

    }
}
