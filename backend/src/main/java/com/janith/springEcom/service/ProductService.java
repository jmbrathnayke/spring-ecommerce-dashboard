package com.janith.springEcom.service;

import com.janith.springEcom.model.Product;
import com.janith.springEcom.repo.ProductRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired //connect with repo
    private ProductRepo productRepo;

    //return list of products
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }
}
