package com.cris318_dev.track_your_finances.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table
public class AccountEntry {
    @Id
    @GeneratedValue
    UUID id;
    double amount;
    LocalDateTime dateTime;
    String comment;
    List<String> tags;
    Account account;
    Categories category;

    public AccountEntry() {
    }

    public AccountEntry(UUID id, double amount, LocalDateTime dateTime, String comment, List<String> tags, Account account, Categories category) {
        this.id = id;
        this.amount = amount;
        this.dateTime = dateTime;
        this.comment = comment;
        this.tags = tags;
        this.account = account;
        this.category = category;
    }

    public AccountEntry(double amount, LocalDateTime dateTime, String comment, List<String> tags, Account account, Categories category) {
        this.amount = amount;
        this.dateTime = dateTime;
        this.comment = comment;
        this.tags = tags;
        this.account = account;
        this.category = category;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "AccountEntry{" +
                "id=" + id +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                ", comment='" + comment + '\'' +
                ", tags=" + tags +
                ", account=" + account +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AccountEntry that = (AccountEntry) o;
        return Double.compare(amount, that.amount) == 0 && Objects.equals(id, that.id) && Objects.equals(dateTime, that.dateTime) && Objects.equals(comment, that.comment) && Objects.equals(tags, that.tags) && Objects.equals(account, that.account) && category == that.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, dateTime, comment, tags, account, category);
    }
}
