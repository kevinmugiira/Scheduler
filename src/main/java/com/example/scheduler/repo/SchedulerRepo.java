package com.example.scheduler.repo;

import com.example.scheduler.model.SchedulerModel;
import com.example.scheduler.model.SmsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface SchedulerRepo extends JpaRepository<SmsModel, Long> {

    @Query(value =
            "SELECT s.TXN_TYPE AS TXN_TYPE, COUNT(COALESCE(s.TXN_TYPE, 'null')) AS SMS_COUNT " +
            "FROM SmsModel s " +
            "WHERE s.CREATED_ON BETWEEN :startDate AND :endDate " +
            "GROUP BY s.TXN_TYPE")
    List<Object[]> getTxnTypeCount(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
