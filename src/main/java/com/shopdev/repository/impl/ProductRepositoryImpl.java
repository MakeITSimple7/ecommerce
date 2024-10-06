package com.shopdev.repository.impl;

import com.shopdev.entity.ProductEntity;
import com.shopdev.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public ProductEntity createProduct(ProductEntity product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1L);
        productEntity.setProductName("Java");
        productEntity.setProductPrice(new BigDecimal("21.5"));
        return productEntity;
    }

    @Override
    public List<ProductEntity> findAllProducts() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1L);
        productEntity.setProductName("Java");
        productEntity.setProductPrice(new BigDecimal("21.5"));
        return List.of(productEntity);
    }
}
