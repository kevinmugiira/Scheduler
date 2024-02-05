package com.example.scheduler.service;


import com.example.scheduler.model.AccModel;
import com.example.scheduler.repo.AccRepo;
import com.example.scheduler.response.AccResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccService {

    @Autowired
    private AccRepo accRepo;

    public List<AccResponse> getAccounts() {
        List<AccModel> accounts = accRepo.findAll();

        return accounts.stream().map(this::mapToAccResponse).collect(Collectors.toList());
    }

    private AccResponse mapToAccResponse(AccModel accModel) {
        return AccResponse.builder()
                .ACCOUNT_ID(accModel.getACCOUNT_ID())
                .BRANCH_ID(accModel.getBRANCH_ID())
                .ACCOUNT_NO(accModel.getACCOUNT_NO())
                .ACCOUNT_NAME(accModel.getACCOUNT_NAME())
                .CUSTOMER_NO(accModel.getCUSTOMER_NO())
                .CURRENCY(accModel.getCURRENCY())
                .ACCOUNT_CLASS(accModel.getACCOUNT_CLASS())
                .ALLOW_DR(accModel.getALLOW_DR())
                .ALLOW_CR(accModel.getALLOW_CR())
                .BLOCKED(accModel.getBLOCKED())
                .STOPPED(accModel.getSTOPPED())
                .DORMANT(accModel.getDORMANT())
                .OPENING_DATE(accModel.getOPENING_DATE())
                .CHEQUE_BOOK_FACILITY(accModel.getCHEQUE_BOOK_FACILITY())
                .ATM_FACILITY(accModel.getATM_FACILITY())
                .IS_FROZEN(accModel.getIS_FROZEN())
                .CREATED_BY(accModel.getCREATED_BY())
                .CREATED_ON(accModel.getCREATED_ON())
                .APPROVED_BY(accModel.getAPPROVED_BY())
                .APPROVED_ON(accModel.getAPPROVED_ON())
                .OPENING_BAL(accModel.getOPENING_BAL())
                .TODAY_DR(accModel.getTODAY_DR())
                .TODAY_CR(accModel.getTODAY_CR())
                .ACTUAL_BAL(accModel.getACTUAL_BAL())
                .AVAILABLE_BAL(accModel.getAVAILABLE_BAL())
                .BLOCKED_AMOUNT(accModel.getBLOCKED_AMOUNT())
                .DR_DATE(accModel.getDR_DATE())
                .CR_DATE(accModel.getCR_DATE())
                .DORMANCY_DATE(accModel.getDORMANCY_DATE())
                .MIN_BALANCE(accModel.getMIN_BALANCE())
                .MATURITY_DATE(accModel.getMATURITY_DATE())
                .INTEREST_RATE(accModel.getINTEREST_RATE())
                .EOD_PROCESSED(accModel.getEOD_PROCESSED())
                .NEXT_PROCESSING_DATE(accModel.getNEXT_PROCESSING_DATE())
                .LAST_TRANSACTION_DATE(accModel.getLAST_TRANSACTION_DATE())
                .PHONE_NUMBER(accModel.getPHONE_NUMBER())
                .PARTIAL_REGISTRATION(accModel.getPARTIAL_REGISTRATION())
                .PARTIAL_DORMANT(accModel.getPARTIAL_DORMANT())
                .PARTIAL_DORMANT_DATE(accModel.getPARTIAL_DORMANT_DATE())
                .ALLOW_OVERDRAFT(accModel.getALLOW_OVERDRAFT())
                .WITHDRAWAL_COUNT(accModel.getWITHDRAWAL_COUNT())
                .ISCLOSED(accModel.getISCLOSED())
                .CLOSED_BY(accModel.getCLOSED_BY())
                .CLOSED_MAKER_REMARKS(accModel.getCLOSED_MAKER_REMARKS())
                .CLOSED_APPROVED_BY(accModel.getCLOSED_APPROVED_BY())
                .CLOSED_CHECKER_REMARKS(accModel.getCLOSED_CHECKER_REMARKS())
                .CLOSEDBY_DATE(accModel.getCLOSEDBY_DATE())
                .build();
    }
}
