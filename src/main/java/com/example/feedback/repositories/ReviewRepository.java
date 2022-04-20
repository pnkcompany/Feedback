package com.example.feedback.repositories;

import com.example.feedback.model.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


public interface ReviewRepository extends CrudRepository<Review,Integer>,CustomizedReviewRepository {

    @Query(value="SELECT * FROM review WHERE product_id = :id limit 10", nativeQuery = true)
    Iterable<Review> findReviewsByProductId(int id);
}
