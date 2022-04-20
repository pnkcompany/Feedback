package com.example.feedback.controller;

import com.example.feedback.dto.MessageDetails;
import com.example.feedback.dto.ReviewInfo;
import com.example.feedback.model.Product;
import com.example.feedback.model.Review;
import com.example.feedback.model.User;
import com.example.feedback.repositories.CustomizedReviewRepository;
import com.example.feedback.repositories.ReviewRepository;
import com.example.feedback.repositories.UserRepository;
import com.example.feedback.security.services.UserDetailsImpl;
import com.example.feedback.security.services.UserDetailsServiceImpl;
import com.example.feedback.services.ProductService;
import com.example.feedback.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("review")
public class ReviewController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private ReviewRepository customizedReviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewService reviewService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Review> getReviewsByProductId(@PathVariable("id") int id) {
        List<Review> reviews = reviewService.getByProductId(id);
        return reviews;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<MessageDetails> deleteReviewById(@PathVariable("id") int id) {
        reviewService.deleteById(id);
        MessageDetails msg = new MessageDetails("Deleted success fullllyyyy");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(msg);
    }

    @RequestMapping(value = "sendReview", method = RequestMethod.POST)
    public String sendReview(@RequestBody ReviewInfo reviewInfo) {
        Authentication actx = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl udi = (UserDetailsImpl) actx.getPrincipal();
        User usr = userRepository.findByUsername(udi.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: "));

        Review review = new Review();
        review.setUser(usr);
        Product prd = productService.find(reviewInfo.getProduct_id());
        review.setContent(reviewInfo.getContent());
        review.setProduct(prd);
        review.setRating(reviewInfo.getRating());
        review.setDatePost(new Date());
        reviewService.create(review);
        return "redirect:/product/" + review.getProduct().getId();

    }

    @RequestMapping(value = "updateReview/{id}", method = RequestMethod.PUT)
    public String updateReview(@PathVariable("id") int id,@RequestBody ReviewInfo reviewInfo) {
        Authentication actx = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl udi = (UserDetailsImpl) actx.getPrincipal();
        User usr = userRepository.findByUsername(udi.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: "));

        Review review = new Review();
        review.setUser(usr);
        Product prd = productService.find(reviewInfo.getProduct_id());
        review.setContent(reviewInfo.getContent());
        review.setProduct(prd);
        review.setRating(reviewInfo.getRating());
        review.setDatePost(new Date());
        customizedReviewRepository.update(id,review);
        return "redirect:/product/" + review.getProduct().getId();

    }
}
