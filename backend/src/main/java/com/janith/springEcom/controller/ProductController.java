package com.janith.springEcom.controller;

import com.janith.springEcom.model.Product;
import com.janith.springEcom.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService service;

    //mapping products

    //return list of products
    @GetMapping("/products")
    public List<Product> getProducts(){
        return service.getAllProducts();
    }
}
