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

    public Product( RequestProduct requestProduct) {
        this.name= requestProduct.name();
        this.price_in_cents= requestProduct.price_in_cents();
    }
}
