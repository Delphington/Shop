package com.delphington.microservices.order.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface InventoryClient {

    @GetExchange("/api/inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);



//    Logger log = LoggerFactory.getLogger(InventoryClient.class);
//
//    @GetExchange("/api/inventory")
//    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
//    @Retry(name = "inventory")
//    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
//
//    default boolean fallbackMethod(String skuCode, Integer quantity, Throwable throwable) {
//        log.error("Cannot check inventory for skuCode: {}, quantity: {}. Reason: {}",
//                skuCode, quantity, throwable.getMessage());
//        return false;
//    }
}
