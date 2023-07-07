package com.skypro.onlineshop.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skypro.onlineshop.model.Product;


import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@SessionScope
public class ProductServiceImpl implements ProductService {

    private final ArrayList<Product> basket = new ArrayList<>();

    @Override
    public String getAllProducts() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(basket);
    }

    @Override
    public String addProduct(Integer... productId) {
        for (Integer id : productId) {
            Product product = new Product(id);
            basket.add(product);
        }

        return basket.stream().map(Product::toString).collect(Collectors.joining(" | "));
    }
}
