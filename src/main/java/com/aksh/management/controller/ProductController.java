package com.aksh.management.controller;
import com.aksh.management.model.Product;
import com.aksh.management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService productService;
//@autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product pro=productService.saveProduct(product);
        return new ResponseEntity<>(pro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Deleted Successfully!", HttpStatus.OK);
    }
}
