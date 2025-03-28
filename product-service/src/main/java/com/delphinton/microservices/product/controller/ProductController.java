package com.delphinton.microservices.product.controller;

import com.delphinton.microservices.product.dto.ProductRequest;
import com.delphinton.microservices.product.dto.ProductResponse;
import com.delphinton.microservices.product.model.Product;
import com.delphinton.microservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        log.info("Creating product");
        return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        log.info("Getting all products");
        return productService.getAllProducts();
    }

}
