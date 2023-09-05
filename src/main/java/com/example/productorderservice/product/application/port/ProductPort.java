package com.example.productorderservice.product.application.port;

import com.example.productorderservice.product.domain.Product;

public interface ProductPort { // interface로 만들고 구현은 adapter에서 진행
    void save(Product product);

    Product getProduct(Long productId);
}
