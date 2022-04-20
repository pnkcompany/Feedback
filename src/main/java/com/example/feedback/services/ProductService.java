package com.example.feedback.services;

import com.example.feedback.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll ();
    public Product find(int id);

}
