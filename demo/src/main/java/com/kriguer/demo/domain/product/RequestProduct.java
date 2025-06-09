package com.kriguer.demo.domain.product;

public record RequestProduct(String name, Integer price_in_cents) {
    // essa classe é um DTO (Data Transfer Object) que serve para receber os dados do cliente
    // e converter para o objeto Product, que será salvo no banco de dados.
    // Ela é usada para evitar que o cliente envie dados desnecessários ou inválidos.
    // Além disso, ela pode ser usada para validar os dados antes de salvá-los no banco de dados.
    // A anotação @Valid é usada para validar os dados do DTO antes de salvá-los no banco de dados.
}
