package com.cris318_dev.track_your_finances.service;

import com.cris318_dev.track_your_finances.model.Spending;
import com.cris318_dev.track_your_finances.repositories.SpendingRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SpendingService {

    @Autowired
    SpendingRepository spendingRepository;

    private static final Logger LOG = LoggerFactory.getLogger(SpendingService.class);


}
