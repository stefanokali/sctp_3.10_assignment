package com.skillsunion.springbootdemo;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ProductController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(ProductController.class);

    // Constructor
    public ProductController() {
        products.add(new Product("Apple", 10.0, "Red fruit"));
        products.add(new Product("Banana", 10.0, "Yellow fruit"));
        products.add(new Product("Carrot", 10.0, "Orange veggie"));
    }

    private ArrayList<Product> products = new ArrayList<>();

    @PostMapping({ "/products" })
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        logger.info("POST /products");
        products.add(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping({ "/products" })
    public ResponseEntity<ArrayList<Product>> getProducts() {
        logger.info("GET /products");
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    // @GetMapping("/products/{id}")
    // public String getProduct(@PathVariable String id) {

    // int index = getProductIndex(id);

    // if (index == -1){
    // return "No product found";
    // }

    // return "This is the detail for ID: " + id + ". Product name: " +
    // products.get(index).getName() + ".";

    // }

    // Helper method
    private int getProductIndex(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return products.indexOf(product);
            }
        }

        return -1;
    }

}
