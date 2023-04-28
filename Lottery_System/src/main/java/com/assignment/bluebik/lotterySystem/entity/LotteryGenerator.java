package com.assignment.bluebik.lotterySystem.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class LotteryGenerator {
    private static final Random random = new Random();
    private static final int MAX_LOTTERY_NUMBER = 10000;

    public List<Integer> generateLotteryNumbers(int count) {
        List<Integer> lotteryNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lotteryNumbers.add(random.nextInt(MAX_LOTTERY_NUMBER) + 1);
        }
        return lotteryNumbers;
    }
}
