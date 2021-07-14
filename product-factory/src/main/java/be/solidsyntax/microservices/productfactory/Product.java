package be.solidsyntax.microservices.productfactory;

import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class Product {
    LocalDateTime creationTime = LocalDateTime.now();
    String id = UUID.randomUUID().toString();

    public Product() {
    }
}
