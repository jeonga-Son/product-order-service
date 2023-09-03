package com.example.productorderservice.product;

interface ProductPort { // interface로 만들고 구현은 adapter에서 진행
    void save(Product product);
}
