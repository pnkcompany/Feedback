package com.example.feedback.model;



import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name="review")
public class Review {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String content;
    private Date datePost;
    private float rating;

    @OneToOne
    @JoinColumn(name = "account_id")
    private  Account account;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;


}
