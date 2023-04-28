package com.assignment.bluebik.lotterySystem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.assignment.bluebik.lotterySystem.entity.Winner;
import com.assignment.bluebik.lotterySystem.repository.WinnerRepository;

import jakarta.transaction.Transactional;

@Service
public class WinnerService {
    private final WinnerRepository winnerRepository;

    public WinnerService(WinnerRepository winnerRepository) {
        this.winnerRepository = winnerRepository;
    }

    @Transactional
    public void addWinners(List<Integer> winners) {
        List<Winner> entities = winners.stream()
                .map(Winner::new)
                .collect(Collectors.toList());
        winnerRepository.saveAll(entities);
    }

    public boolean isWinner(Integer lotteryNumber) {
        return winnerRepository.existsById(lotteryNumber);
    }
}
