package com.assignment.bluebik.lotterySystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.bluebik.lotterySystem.entity.Winner;

@Repository
public interface WinnerRepository extends JpaRepository<Winner, Integer>{
	
	List<Winner> findAllByLotteryNumberIn(List<Integer> lotteryNumbers);
}
