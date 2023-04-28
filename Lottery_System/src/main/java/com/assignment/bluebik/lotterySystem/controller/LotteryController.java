package com.assignment.bluebik.lotterySystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.bluebik.lotterySystem.service.WinnerService;

@RestController
@RequestMapping("/api/lottery")
public class LotteryController {
    private final WinnerService winnerService;

    public LotteryController(WinnerService winnerService) {
        this.winnerService = winnerService;
    }

    @GetMapping("/{lotteryNumber}")
    public boolean checkNumber(@PathVariable Integer lotteryNumber) {
        boolean isWinner = false;
        int retries = 3;
        while (retries > 0) {
            try {
                isWinner = winnerService.isWinner(lotteryNumber);
                break;
            } catch (Exception e) {
                retries--;
                if (retries == 0) {
                    throw e;
                }
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ignored) {}
            }
        }
        return isWinner;
    }
}

