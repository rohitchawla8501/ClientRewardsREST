package com.charter.client.rewards;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

	@Test
	/*This Test case checks reward amount for above 100.*/
	void testCalculateRewardsforMultipleTransactions() {
		Customer customer=rewardService.calculateRewardsbyId(2);
		System.out.println("Test Customer"+ customer.getName());
		if(customer.getId()==2) {
			Assertions.assertEquals(540,customer.getTotalRewardAmount());
		}		
	}

	@Test
	/*This Test case checks reward amount for above 50 below 100.*/
	void testCalculateRewardAmountBelowHundredAboveFifty() {
		Customer customer=rewardService.calculateRewardsbyId(3);
		System.out.println("Test Customer"+ customer.getName());
		if(customer.getId()==3) {
			Assertions.assertEquals(1,customer.getTotalRewardAmount());
		}		
	}

	@Test
	/*This Test case checks reward amount for below 50.*/
	void testCalculateRewardAmountBelowFifty() {
		Customer customer=rewardService.calculateRewardsbyId(4);
		System.out.println("Test Customer"+ customer.getName());
		if(customer.getId()==4) {
			Assertions.assertEquals(0,customer.getTotalRewardAmount());
		}		
	}

	@Test
	/*This Test case checks reward amount for amount 100.*/
	void testCalculateRewardAmountForHundred() {
		Customer customer=rewardService.calculateRewardsbyId(5);
		System.out.println("Test Customer"+ customer.getName());
		if(customer.getId()==5) {
			Assertions.assertEquals(50,customer.getTotalRewardAmount());
		}		
	}

	@Test
	/*This Test case is checking if we are taking previous year or months into consideration.
	 Expected 0 for older transactions*/
	void testCalculateRewardAmountPreviousMonths() {
		Customer customer=rewardService.calculateRewardsbyId(6);
		System.out.println("Test Customer"+ customer.getName());
		if(customer.getId()==6) {
			Assertions.assertEquals(0,customer.getTotalRewardAmount());
		}		
	}
}

