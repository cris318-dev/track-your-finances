package com.cris318_dev.track_your_finances.repositories;

import com.cris318_dev.track_your_finances.model.Spending;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpendingRepository extends JpaRepository<Spending, UUID> {
}
