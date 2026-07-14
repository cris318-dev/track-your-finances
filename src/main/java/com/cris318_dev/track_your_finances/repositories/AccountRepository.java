package com.cris318_dev.track_your_finances.repositories;

import com.cris318_dev.track_your_finances.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
}
