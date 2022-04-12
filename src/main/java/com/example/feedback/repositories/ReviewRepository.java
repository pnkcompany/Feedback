package com.example.feedback.repositories;

import com.example.feedback.model.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository("reviewRepository")
public interface ReviewRepository extends CrudRepository<Review,Integer> {
}
