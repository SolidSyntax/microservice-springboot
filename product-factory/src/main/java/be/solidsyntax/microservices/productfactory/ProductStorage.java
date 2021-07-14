package be.solidsyntax.microservices.productfactory;

import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;

@Service
public class ProductStorage {
    private BlockingQueue<Product> storage;

//    public ProductStorage(@Value("${production.storage-capacity}") int capacity) {
//        this.storage = new ArrayBlockingQueue<Product>(capacity);
//    }
//
//    public void store(Product product) {
//        storage.add(product);
//    }
}
