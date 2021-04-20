package com.product.catalog.model;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Embeddable
public class Attributes {

    @Id
    private Long id;
    private float size;
    private String brand;
    private String os;



    public Attributes() {}


}
