package com.skypro.onlineshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.skypro.onlineshop.services.ProductService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")


public class AddGetController {

    private final ProductService productService;


    public AddGetController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/add")
    public String addProduct(@RequestParam("productId") Integer... productId) {

        return productService.addProduct(productId);
    }

    @GetMapping("/get")
    public String getAllProducts() throws JsonProcessingException {
        return productService.getAllProducts();
    }


}
