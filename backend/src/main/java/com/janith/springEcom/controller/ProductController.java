package com.janith.springEcom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {

    //mapping products
    @GetMapping("/products")
    //return list of products
    public String getProduct(){
        return "All products";
    }
}
