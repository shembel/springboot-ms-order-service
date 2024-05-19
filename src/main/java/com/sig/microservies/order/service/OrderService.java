package com.sig.microservies.order.service;

import com.sig.microservies.order.dto.OrderRequest;
import com.sig.microservies.order.model.Order;
import com.sig.microservies.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    // in order for this to work we need a constructor (can be done by Lombok's @RequiredArgsConstructor
    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        // map OrderRequest to Order object
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());

        // save order to OrderRepository (for that we need to inject the order repository
        // into the OrderService class (line 16)
        orderRepository.save(order);
    }
}
