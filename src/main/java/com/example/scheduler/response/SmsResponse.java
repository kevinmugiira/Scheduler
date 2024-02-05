package com.example.scheduler.response;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmsResponse {

    private Long id;
    private String PHONE_NUMBER;
    private String MESSAGE;
    private String REFERENCE;
    private String PG_STATUS_CODE;
    private String PG_STATUS_DESC;
    private LocalDate CREATED_ON;
    private int RE_POSTED;
    private int TRIALS;
    private String TXN_TYPE;
    private Long SMS_COUNT;

    public Long getId() {
        return id;
    }

    public String getPHONE_NUMBER() {
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

    public Long getSMS_COUNT() {
        return SMS_COUNT;
    }
}
