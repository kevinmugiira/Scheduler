package com.example.scheduler.repo;

import com.example.scheduler.model.SmsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface SchedulerRepo extends JpaRepository<SmsModel, Long> {

    /**
      * counts number of messages in db table,
      * and for each message with more than 160 characters,
      * it divides it and counts all the parts as a whole message
     **/
    @Query("SELECT s.TXN_TYPE, " +
            "SUM(CASE WHEN LENGTH(s.MESSAGE) <= 160 THEN 1 " +
            "ELSE CEILING(LENGTH(s.MESSAGE) / 160.0) END) AS SMS_COUNT " +
            "FROM SmsModel s " +
            "WHERE s.CREATED_ON BETWEEN :startDate AND :endDate " +
            "GROUP BY s.TXN_TYPE")

   /**
     * counts the number of messages in the db table,
     * outputs them as 'SMS_COUNT',
     * and groups them by the TXN_TYPE column.
     **/
//    @Query(value =
//            "SELECT s.TXN_TYPE AS TXN_TYPE, COUNT(COALESCE(s.TXN_TYPE, 'null')) AS SMS_COUNT " +
//            "FROM SmsModel s " +
//            "WHERE s.CREATED_ON BETWEEN :startDate AND :endDate " +
//            "GROUP BY s.TXN_TYPE")
    List<Object[]> getTxnTypeCount(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
