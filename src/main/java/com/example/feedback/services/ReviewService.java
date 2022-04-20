package com.example.feedback.services;

import com.example.feedback.dto.ReviewInfo;
import com.example.feedback.model.Review;

import java.util.List;

public interface ReviewService {
    Review create(Review review);
    void deleteById(int id);
    List<Review> getByProductId(int id);


}
