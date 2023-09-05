package com.example.productorderservice.order;

import com.example.productorderservice.product.Product;
import org.springframework.stereotype.Component;

@Component
class OrderService {
    private final OrderPort orderPort;

    OrderService(final OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    public void createOrder(final CreateOrderRequest request) {
        // 가져온 상품으로 order를 만들어서 order를 저장한다.
        final Product product = orderPort.getProductById(request.productId());

        final Order order = new Order(product, request.quantity());

        orderPort.save(order);
    }

}
