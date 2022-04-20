package com.example.feedback.repositories;

import com.example.feedback.model.Review;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

public interface CustomizedReviewRepository {

    Review update(int id, Review review);
}
