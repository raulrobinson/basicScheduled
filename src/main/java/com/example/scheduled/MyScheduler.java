package com.example.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class MyScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyScheduler.class);

    @Value("${app.interval}")
    private int valueInterval;

    @Scheduled(fixedRateString = "${app.interval}")
    public void task() {
        LOGGER.info("Tarea programada ejecutada cada: {}s, DateTime: " + Instant.now(), valueInterval / 1000);
    }

}
