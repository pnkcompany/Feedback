package com.example.feedback.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReviewInfo {
    private String content;
    private float rating;
    private int product_id;
}
