package com.example.scheduler.controller;


import com.example.scheduler.response.AccResponse;
import com.example.scheduler.service.AccService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class AccController {

    private final AccService accService;

    @GetMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<AccResponse> getAllAccounts() {
        return accService.getAccounts();
    }
}
