package com.company.repositories;

import com.company.dto.CityStatisticsDto;
import com.company.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionsRepository extends JpaRepository<Transaction, Long> {
    //JPQL
    @Query("select new com.company.dto.CityStatisticsDto(transaction.city, sum(transaction.someValue)) from Transaction transaction " +
            "where transaction.city=:city group by transaction.city")
    CityStatisticsDto getCityStatistics(@Param("city") String city);
}
