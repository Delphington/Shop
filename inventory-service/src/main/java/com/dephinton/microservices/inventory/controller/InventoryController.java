package com.dephinton.microservices.inventory.controller;

import com.dephinton.microservices.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam("skuCode") String skuCode,
                             @RequestParam("quantity") Integer quantity) {
        return inventoryService.isInStock(skuCode, quantity);
    }

}
