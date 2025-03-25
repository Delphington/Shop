package com.delphinton.microservices.order.service;

import com.delphinton.microservices.order.dto.OrderRequest;
import com.delphinton.microservices.order.model.Order;
import com.delphinton.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        order.setSkuCode(orderRequest.skuCode());
        repository.save(order);
    }

}
