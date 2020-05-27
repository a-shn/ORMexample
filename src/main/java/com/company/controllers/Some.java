package com.company.controllers;

import com.company.dto.CityStatisticsDto;
import com.company.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.company.repositories.TransactionsRepository;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Some {
    @Autowired
    private TransactionsRepository transactionsRepository;

    @GetMapping("/add_chelny")
    public ResponseEntity<?> addChelny() {
        Transaction transaction = Transaction.builder()
                .city("Chelny")
                .someValue(123)
                .build();
        transactionsRepository.save(transaction);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/add_kazan")
    public ResponseEntity<?> addKazan() {
        Transaction transaction = Transaction.builder()
                .city("Kazan")
                .someValue(321)
                .build();
        transactionsRepository.save(transaction);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/statistics/{city}")
    public ResponseEntity<CityStatisticsDto> stats(@PathVariable("city") String city) {
        CityStatisticsDto statisticsDto = transactionsRepository.getCityStatistics(city);
        return ResponseEntity.ok(statisticsDto);
    }
}
