package com.example.scheduler.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "TB_CHANNELS")
public class ChannelsModel {

    @Id
    private Long ID;
    private String CHANNEL;
    private String DESCRIPTION;
    private LocalDate CREATED_ON;
    private String CREATED_BY;
    private int APPROVED;
    private String APPROVED_BY;
    private LocalDate APPROVED_ON;
    private String REMARKS;
    private String CHECKER_REMARKS;
    private String CHARGE_CHANNEL;

    public Long getID() {
        return ID;
    }

    public String getCHANNEL() {
        return CHANNEL;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public LocalDate getCREATED_ON() {
        return CREATED_ON;
    }

    public String getCREATED_BY() {
        return CREATED_BY;
    }

    public int getAPPROVED() {
        return APPROVED;
    }

    public String getAPPROVED_BY() {
        return APPROVED_BY;
    }

    public LocalDate getAPPROVED_ON() {
        return APPROVED_ON;
    }

    public String getREMARKS() {
        return REMARKS;
    }

    public String getCHECKER_REMARKS() {
        return CHECKER_REMARKS;
    }

    public String getCHARGE_CHANNEL() {
        return CHARGE_CHANNEL;
    }
}
