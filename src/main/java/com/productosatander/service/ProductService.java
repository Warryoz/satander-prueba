package com.productosatander.service;

import com.productosatander.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);

    Product save(Product product);

    Product update(Long id, Product product);
    String deleteById(Long id);
}
