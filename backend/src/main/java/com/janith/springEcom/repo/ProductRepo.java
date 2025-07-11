package com.janith.springEcom.repo;

import com.janith.springEcom.model.Product;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository <Product, Integer> {


}
