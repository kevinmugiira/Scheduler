package com.example.scheduler.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "TB_SMS_MESSAGES")
public class SmsModel {

    @Id
    private Long id;
    private String PHONE_NUMBER;
    private String MESSAGE;
    private String REFERENCE;
    private String PG_STATUS_CODE;
    private String PG_STATUS_DESC;

    private LocalDate CREATED_ON;
    private int RE_POSTED;
    private int TRIALS;
    @Column(nullable = true)
    private String TXN_TYPE;

    public Long getId() {
        return id;
    }

    public String getPHONENUMBER() {
        return PHONE_NUMBER;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public String getREFERENCE() {
        return REFERENCE;
    }

    public String getPG_STATUS_CODE() {
        return PG_STATUS_CODE;
    }

    public String getPG_STATUS_DESC() {
        return PG_STATUS_DESC;
    }

    public LocalDate getCREATED_ON() {
        return CREATED_ON;
    }

    public int getRE_POSTED() {
        return RE_POSTED;
    }

    public int getTRIALS() {
        return TRIALS;
    }

    public String getTXN_TYPE() {
        return TXN_TYPE;
    }

    public void setTXN_TYPE(String TXN_TYPE) {
        this.TXN_TYPE = TXN_TYPE;
    }
}
