package com.example.feedback.services;

import com.example.feedback.model.Review;
import com.example.feedback.repositories.CustomizedReviewRepository;
import com.example.feedback.repositories.ReviewRepository;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service("reviewService")
@Transactional
public class ReviewServiceImpl  implements  ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review create(Review review){
        return reviewRepository.save(review);
    }

    @Override
    public void deleteById(int id) {
        reviewRepository.deleteAllById(Collections.singleton(id));
    }


    @Override
    public List<Review> getByProductId(int id) {
       List<Review> reviewListByprd =  IterableUtils.toList(reviewRepository.findReviewsByProductId(id));
        return reviewListByprd;
    }


}
