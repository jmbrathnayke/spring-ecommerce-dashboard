package com.janith.springEcom.service;

import com.janith.springEcom.model.Product;
import com.janith.springEcom.repo.ProductRepo;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService {

    @Autowired //connect with repo
    private ProductRepo productRepo;

    //return list of products
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    //return get product by id
    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    // add product
    public Product addProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return productRepo.save(product);
    }
}
