package com.example.feedback.repositories;

import com.example.feedback.model.Review;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomizedReviewRepositoryImpl implements CustomizedReviewRepository {
    private final JdbcTemplate jdbc;

    public CustomizedReviewRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Review update(int id, Review review) {
        String updateQuery = "update feedbackdb.review set content = ?, date_post =?,rating=? where id = ?";
       int i=  jdbc.update(updateQuery, review.getContent(),review.getDatePost(),review.getRating(), id);
        if(i==1){
            review.setId(id);
            return review;
        }
        return null;
    }
}
