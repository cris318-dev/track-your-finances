package com.cris318_dev.track_your_finances.service;


import com.cris318_dev.track_your_finances.exceptions.UserAccountListIsNullException;
import com.cris318_dev.track_your_finances.exceptions.UserDoesNotExistException;
import com.cris318_dev.track_your_finances.model.Account;
import com.cris318_dev.track_your_finances.model.User;
import com.cris318_dev.track_your_finances.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class UserService {

    @Autowired
    UserRepository userRepository;

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    public User addUser(String firstname, String lastname, LocalDateTime birthdate){
        User newUser = new User(firstname, lastname, birthdate);
        User added = userRepository.save(newUser);
        LOG.info("New user {} was added into the database", added);
        return added;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(String id) throws UserDoesNotExistException {
        Optional<User> result = userRepository.findById(UUID.fromString(id));
        if(result.isEmpty()){
            String errorMessage = "User with id: " + " does not exist";
            LOG.error(errorMessage);
            throw new UserDoesNotExistException(errorMessage);
        }else{
            User user = result.get();
            LOG.info("Found User with ID: {}", user);
            return user;
        }
    }

    public List<User> getUser(String firstname, String lastname, LocalDateTime dateOfBirth){
        return userRepository.findByFirstnameAndLastnameAndDateOfBirth(firstname, lastname, dateOfBirth);
    }

    public List<Account> getUserAccounts(String id) throws UserDoesNotExistException, UserAccountListIsNullException {
        User user = this.getUser(id);
        try{
            List<Account> accounts = user.getAccounts();
            LOG.info("User {} accounts: {}", user.getId(), accounts);
            return accounts;
        }catch(NullPointerException e){
            String errorMessage = " Account list of user with id " + user.getId() + " is null!";
            LOG.error("User {} account list is NULL", user.getId());
            throw new UserAccountListIsNullException(errorMessage);
        }
    }

    public List<Account> getUserAccounts(User user){
        return user.getAccounts();
    }

    public List<Account> addAccount(Account newAccount) throws UserDoesNotExistException, UserAccountListIsNullException {
        String id = newAccount.getOwner().getId().toString();
        User user = this.getUser(id);
        try{
            List<Account> accounts = user.getAccounts();
            accounts.add(newAccount);
            user.setAccounts(accounts);
            userRepository.save(user);
            LOG.info("Added new account {} to user {}", newAccount.getAccountName(), newAccount.getOwner().getId());
            return accounts;
        }
        catch(NullPointerException e){
            String errorMessage = " Account list of user with id " + id + " is null!";
            LOG.error("User {} account list is NULL", id);
            throw new UserAccountListIsNullException(errorMessage);
        }
    }


}
