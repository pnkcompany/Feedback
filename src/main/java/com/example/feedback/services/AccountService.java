package com.example.feedback.services;

import com.example.feedback.model.Account;


public interface AccountService {
    public Account create(Account account);
    public Account login(String username,String password);
}
