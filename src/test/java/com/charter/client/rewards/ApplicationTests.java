package com.charter.client.rewards;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Assertions;

import com.charter.client.rewards.dto.Customer;
import com.charter.client.rewards.service.RewardService;

@SpringBootTest

class ApplicationTests {

	@Autowired
	private RewardService rewardService;
	
	@Test
	void contextLoads() {
	}

//	@Test
//	void testCalculateRewardAmount() {
//		Customer customer=rewardService.calculateRewardsbyId(2);
//		System.out.println("Test Customer"+ customer);
//			if(customer.getId()==2) {
//		Assertions.assertEquals(540,customer.getTotalRewardAmount());
//		}		
//	}
}
	
