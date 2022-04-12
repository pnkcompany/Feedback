package com.example.feedback.repositories;

import com.example.feedback.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("accountRepository")
public interface AccountRepository extends CrudRepository<Account,Integer> {
    Account findByUsernameAndPassword(String username, String password);
}
