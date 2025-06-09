package com.kriguer.demo.domain.product;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name="product")
@Entity(name="product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

    @Id  @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Integer price_in_cents;
    private Boolean active;

    public Product( RequestProduct requestProduct) {
        //this.id = requestProduct.id();
        this.name= requestProduct.name();
        this.price_in_cents= requestProduct.price_in_cents();
        this.active = true; // Assuming you want to set active to true when creating a new product
    }
}
