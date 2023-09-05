package com.example.productorderservice.order;

import com.example.productorderservice.product.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@Component
class OrderService {
    private final OrderPort orderPort;

    OrderService(final OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody final CreateOrderRequest request) {
        // 가져온 상품으로 order를 만들어서 order를 저장한다.
        final Product product = orderPort.getProductById(request.productId());

        final Order order = new Order(product, request.quantity());

        orderPort.save(order);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
