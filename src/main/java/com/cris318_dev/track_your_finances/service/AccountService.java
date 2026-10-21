package com.cris318_dev.track_your_finances.service;

import com.cris318_dev.track_your_finances.exceptions.AccountDoesNotExistException;
import com.cris318_dev.track_your_finances.model.Account;
import com.cris318_dev.track_your_finances.model.AccountType;
import com.cris318_dev.track_your_finances.model.User;
import com.cris318_dev.track_your_finances.repositories.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;
    private static final Logger LOG = LoggerFactory.getLogger(AccountService.class);

    public Account getAccount(String id) throws AccountDoesNotExistException {
        Optional<Account> result = accountRepository.findById(UUID.fromString(id));
        if(result.isEmpty()){
            String errorMessage = "Account with " + id + " does not exist!";
            LOG.error(errorMessage);
            throw new AccountDoesNotExistException(errorMessage);
        }else{
            Account account = result.get();
            LOG.info("Found account with id {}", account.getId());
            return account;
        }
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Account addAccount(User owner, String accountName, AccountType accountType, double currentAmount){
        Account newAccount = new Account(owner, accountName, accountType, currentAmount);
        Account added = accountRepository.save(newAccount);
        LOG.info("New account {} was added into the database", added);
        return added;
    }

    public User getAccountOwner(String id) throws AccountDoesNotExistException {
        Account account = this.getAccount(id);
        try{
            User owner = account.getOwner();
            LOG.info("Account {} owner is {}.", account.getId(), owner.getId());
            return owner;
        }catch(NullPointerException e){
            String errorMessage = "Account with id " + id + " is null!";
            LOG.error(errorMessage);
            throw new AccountDoesNotExistException(errorMessage);
        }
    }

    public AccountType getAccountTypFromAccount(String id) throws AccountDoesNotExistException {
        Account account = this.getAccount(id);
        return account.getAccountType();
    }
}
