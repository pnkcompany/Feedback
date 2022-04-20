package com.example.feedback.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name="product")
public class Product  implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Integer id;
    private String name;
    private  double price;

    @Column(columnDefinition = "TEXT")
    private  String photo;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


}
