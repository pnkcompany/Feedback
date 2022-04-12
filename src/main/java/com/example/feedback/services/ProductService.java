package com.example.feedback.services;

import com.example.feedback.model.Product;

public interface ProductService {
    public Iterable<Product> findAll ();
    public Product find(int id);

}
