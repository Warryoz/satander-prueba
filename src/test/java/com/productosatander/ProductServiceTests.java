package com.productosatander;


import com.productosatander.entity.Product;
import com.productosatander.repository.ProductRepository;
import com.productosatander.service.ProductService;
import com.productosatander.service.ProductServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class ProductServiceTests {

    @Mock
    public ProductRepository productRepository;

    @InjectMocks
    public ProductServiceImp productServiceImp;


    // UNIT TEST FOR CREATE PRODUCT


    @Test
    public void testCreateProduct() {
        var product = new Product();
        product.setId(1L);
        product.setName("Producto 1");
        product.setPrice(100D);

        //given
        given(productRepository.save(product)).willReturn(product);

        //when
        var result = productServiceImp.save(product);

        //then
        assert(result.getId() == 1L);

    }

}
