package com.janith.springEcom.controller;

import com.janith.springEcom.model.Product;
import com.janith.springEcom.service.ProductService;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService service;

    //mapping products

    //mapping and return list of products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.ACCEPTED);
    }

    //mapping and return get product by id
    @GetMapping("/product/{id}")
    public ResponseEntity <Product> getProductById(@PathVariable int id) {
        Product product = service.getProductById(id);

        //get productById logic
        if(product != null)
        return new ResponseEntity<>(product, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //mapping and return addprodcut with image
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile image){
        Product saveProduct = null;
        try {
            saveProduct = service.addProduct(product, image);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
    }
}
