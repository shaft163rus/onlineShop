package com.skypro.onlineshop.services;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ProductService {

    String getAllProducts() throws JsonProcessingException;

    String addProduct(Integer... product);


}
