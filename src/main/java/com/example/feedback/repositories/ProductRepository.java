package com.example.feedback.repositories;

import com.example.feedback.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository("productRepository")
public interface ProductRepository  extends CrudRepository<Product, Serializable> {
}
