package com.example.scheduler.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="TB_ACCOUNT")
public class AccModel {

    @Id
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

    public Long getACCOUNT_ID() {
        return ACCOUNT_ID;
    }

    public int getBRANCH_ID() {
        return BRANCH_ID;
    }

    public String getACCOUNT_NO() {
        return ACCOUNT_NO;
    }

    public String getACCOUNT_NAME() {
        return ACCOUNT_NAME;
    }

    public String getCUSTOMER_NO() {
        return CUSTOMER_NO;
    }

    public String getCURRENCY() {
        return CURRENCY;
    }

    public String getACCOUNT_CLASS() {
        return ACCOUNT_CLASS;
    }

    public char getALLOW_DR() {
        return ALLOW_DR;
    }

    public char getALLOW_CR() {
        return ALLOW_CR;
    }

    public char getBLOCKED() {
        return BLOCKED;
    }

    public char getSTOPPED() {
        return STOPPED;
    }

    public char getDORMANT() {
        return DORMANT;
    }

    public LocalDateTime getOPENING_DATE() {
        return OPENING_DATE;
    }

    public char getCHEQUE_BOOK_FACILITY() {
        return CHEQUE_BOOK_FACILITY;
    }

    public char getATM_FACILITY() {
        return ATM_FACILITY;
    }

    public char getIS_FROZEN() {
        return IS_FROZEN;
    }

    public String getCREATED_BY() {
        return CREATED_BY;
    }

    public LocalDateTime getCREATED_ON() {
        return CREATED_ON;
    }

    public String getAPPROVED_BY() {
        return APPROVED_BY;
    }

    public LocalDateTime getAPPROVED_ON() {
        return APPROVED_ON;
    }

    public BigDecimal getOPENING_BAL() {
        return OPENING_BAL;
    }

    public BigDecimal getTODAY_DR() {
        return TODAY_DR;
    }

    public BigDecimal getTODAY_CR() {
        return TODAY_CR;
    }

    public BigDecimal getACTUAL_BAL() {
        return ACTUAL_BAL;
    }

    public BigDecimal getAVAILABLE_BAL() {
        return AVAILABLE_BAL;
    }

    public BigDecimal getBLOCKED_AMOUNT() {
        return BLOCKED_AMOUNT;
    }

    public LocalDateTime getDR_DATE() {
        return DR_DATE;
    }

    public LocalDateTime getCR_DATE() {
        return CR_DATE;
    }

    public LocalDateTime getDORMANCY_DATE() {
        return DORMANCY_DATE;
    }

    public BigDecimal getMIN_BALANCE() {
        return MIN_BALANCE;
    }

    public LocalDateTime getMATURITY_DATE() {
        return MATURITY_DATE;
    }

    public BigDecimal getINTEREST_RATE() {
        return INTEREST_RATE;
    }

    public char getEOD_PROCESSED() {
        return EOD_PROCESSED;
    }

    public LocalDateTime getNEXT_PROCESSING_DATE() {
        return NEXT_PROCESSING_DATE;
    }

    public LocalDateTime getLAST_TRANSACTION_DATE() {
        return LAST_TRANSACTION_DATE;
    }

    public String getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }

    public char getPARTIAL_REGISTRATION() {
        return PARTIAL_REGISTRATION;
    }

    public char getPARTIAL_DORMANT() {
        return PARTIAL_DORMANT;
    }

    public LocalDateTime getPARTIAL_DORMANT_DATE() {
        return PARTIAL_DORMANT_DATE;
    }

    public char getALLOW_OVERDRAFT() {
        return ALLOW_OVERDRAFT;
    }

    public BigDecimal getWITHDRAWAL_COUNT() {
        return WITHDRAWAL_COUNT;
    }

    public char getISCLOSED() {
        return ISCLOSED;
    }

    public char getCLOSED_BY() {
        return CLOSED_BY;
    }

    public String getCLOSED_MAKER_REMARKS() {
        return CLOSED_MAKER_REMARKS;
    }

    public String getCLOSED_APPROVED_BY() {
        return CLOSED_APPROVED_BY;
    }

    public String getCLOSED_CHECKER_REMARKS() {
        return CLOSED_CHECKER_REMARKS;
    }

    public LocalDateTime getCLOSEDBY_DATE() {
        return CLOSEDBY_DATE;
    }
}
