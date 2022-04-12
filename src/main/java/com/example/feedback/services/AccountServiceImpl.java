package com.example.feedback.services;

import com.example.feedback.model.Account;
import com.example.feedback.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("accountService")
@Transactional
public class AccountServiceImpl  implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account create(Account account){

        return accountRepository.save(account);
    }

    @Override
    public Account login(String username,String password){
        return accountRepository.findByUsernameAndPassword(username,password);
    }



}
