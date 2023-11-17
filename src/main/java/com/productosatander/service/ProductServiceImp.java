package com.productosatander.service;

import com.productosatander.entity.Product;
import com.productosatander.exception.ResourceNotFoundException;
import com.productosatander.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImp implements  ProductService{

    private final ProductRepository  productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id "+id+" not found"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        var productToUpdate = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id "+id+" not found"));

        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
        return productRepository.save(productToUpdate);
    }

    @Override
    public String deleteById(Long id) {
        var productToDelete = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id "+id+" not found"));
        productRepository.delete(productToDelete);

        return "Product successfully deleted";
    }
}
