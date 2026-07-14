package com.cris318_dev.track_your_finances.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue
    UUID id;
    double currentAmount;
    String accountName;
    AccountType accountType;
    User owner;


    public Account() {
    }

    public Account(UUID id, double currentAmount, String accountName, AccountType accountType, User owner) {
        this.id = id;
        this.currentAmount = currentAmount;
        this.accountName = accountName;
        this.accountType = accountType;
        this.owner = owner;
    }

    public Account(User owner, String accountName, AccountType accountType, double currentAmount) {
        this.owner = owner;
        this.accountName = accountName;
        this.accountType = accountType;
        this.currentAmount = currentAmount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", currentAmount=" + currentAmount +
                ", accountName='" + accountName + '\'' +
                ", accountType=" + accountType +
                ", owner=" + owner +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(currentAmount, account.currentAmount) == 0 && Objects.equals(id, account.id) && Objects.equals(accountName, account.accountName) && accountType == account.accountType && Objects.equals(owner, account.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currentAmount, accountName, accountType, owner);
    }
}
