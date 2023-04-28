package com.assignment.bluebik.lotterySystem.entity;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.assignment.bluebik.lotterySystem.service.WinnerService;

@Component
public class LotteryIdPusher {
    private final WinnerService winnerService;
    private final LotteryGenerator lotteryGenerator;

    public LotteryIdPusher(WinnerService winnerService, LotteryGenerator lotteryGenerator) {
        this.winnerService = winnerService;
        this.lotteryGenerator = lotteryGenerator;
        startPushing();
    }

    @Scheduled(cron = "0 0 0 * * *") // Run at 12am every day
    public void pushLotteryIds() {
        List<Integer> lotteryNumbers = lotteryGenerator.generateLotteryNumbers(1000);
        winnerService.addWinners(lotteryNumbers);
    }

    private void startPushing() {
        pushLotteryIds();
    }
}
