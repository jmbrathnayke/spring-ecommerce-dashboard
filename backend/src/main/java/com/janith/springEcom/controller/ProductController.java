package com.janith.springEcom.controller;

import com.janith.springEcom.model.Product;
import com.janith.springEcom.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService service;

    //mapping products

    //return list of products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity <Product> getProductById(@PathVariable int id) {
        Product product = service.getProductById(id);

        //get productById logic
        if(product != null)
        return new ResponseEntity<>(product, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
