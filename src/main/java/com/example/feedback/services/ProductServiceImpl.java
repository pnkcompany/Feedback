package com.example.feedback.services;

import com.example.feedback.model.Product;
import com.example.feedback.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;


@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> findAll(){
       return productRepository.findAll();
    }

    public Product find(int id) {
        Optional<Product> prdRs = productRepository.findById(id);

        if(prdRs.isPresent()){
            return prdRs.get();
        }
        return null;
    }


}