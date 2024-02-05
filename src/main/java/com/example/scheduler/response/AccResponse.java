package com.example.scheduler.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccResponse {

    private Long ACCOUNT_ID;
    private int BRANCH_ID;
    private String ACCOUNT_NO;
    private String ACCOUNT_NAME;
    private String CUSTOMER_NO;
    private String CURRENCY;
    private String ACCOUNT_CLASS;
    private char ALLOW_DR;
    private char ALLOW_CR;
    private char BLOCKED;
    private char STOPPED;
    private char DORMANT;
    private LocalDateTime OPENING_DATE;
    private char CHEQUE_BOOK_FACILITY;
    private char ATM_FACILITY;
    private char IS_FROZEN;
    private String CREATED_BY;
    private LocalDateTime CREATED_ON;
    private String APPROVED_BY;
    private LocalDateTime APPROVED_ON;
    private BigDecimal OPENING_BAL;
    private BigDecimal TODAY_DR;
    private BigDecimal TODAY_CR;
    private BigDecimal ACTUAL_BAL;
    private BigDecimal AVAILABLE_BAL;
    private BigDecimal BLOCKED_AMOUNT;
    private LocalDateTime DR_DATE;
    private LocalDateTime CR_DATE;
    private LocalDateTime DORMANCY_DATE;
    private BigDecimal MIN_BALANCE;
    private LocalDateTime MATURITY_DATE;
    private BigDecimal INTEREST_RATE;
    private char EOD_PROCESSED;
    private LocalDateTime NEXT_PROCESSING_DATE;
    private LocalDateTime LAST_TRANSACTION_DATE;
    private String PHONE_NUMBER;
    private char PARTIAL_REGISTRATION;
    private char PARTIAL_DORMANT;
    private LocalDateTime PARTIAL_DORMANT_DATE;
    private char ALLOW_OVERDRAFT;
    private BigDecimal WITHDRAWAL_COUNT;
    private char ISCLOSED;
    private char CLOSED_BY;
    private String CLOSED_MAKER_REMARKS;
    private String CLOSED_APPROVED_BY;
    private String CLOSED_CHECKER_REMARKS;
    private LocalDateTime CLOSEDBY_DATE;
}
