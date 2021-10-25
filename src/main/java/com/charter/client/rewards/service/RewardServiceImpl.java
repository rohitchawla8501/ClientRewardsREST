/**
 * 
 */
package com.charter.client.rewards.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charter.client.rewards.controller.RewardsController;
import com.charter.client.rewards.dto.Customer;
import com.charter.client.rewards.dto.Transaction;
import com.charter.client.rewards.repository.RewardRepository;

/**
 * @author rohitchawla
 *
 */
@Service
public class RewardServiceImpl implements RewardService {
	
	 Logger logger = LoggerFactory.getLogger(RewardServiceImpl.class);

	@Autowired
	private RewardRepository rewardRepository;

	LocalDate currentdate = LocalDate.now();
	int currentMonth= currentdate.getMonth().getValue();

	@Override
	public List<Customer> calculateRewardsAll() {
		logger.info("Entered calculateRewardsAll method of Service");

		List<Customer> customerList = rewardRepository.findAll();
		

		for(Customer customer : customerList) 
		{
			Set<Transaction> setOfTransaction =customer.getTransactions();
			rewardsSetperMonth(setOfTransaction,customer);
		}

		return customerList;
	}

	@Override
	public Customer calculateRewardsbyId(Integer cid)

	{
		logger.info("Entered calculateRewardsbyId method of Service");

		Customer customer=rewardRepository.findById(cid).orElse(null);
		Set<Transaction> setOfTransaction =customer.getTransactions();

		rewardsSetperMonth(setOfTransaction,customer);
		return customer;
	}

	private int calculateRewardAmountPerTransaction(int transaction_amount)
	{
		int rewardAmount=0;
		if (transaction_amount >=50 && transaction_amount <= 100) 
		{
			rewardAmount=transaction_amount-50;
		} 
		else if (transaction_amount >100)
		{
			rewardAmount=(2*(transaction_amount-100) + 50);
		}
		return rewardAmount;
	}

	private void rewardsSetperMonth(Set<Transaction> setOfTransaction, Customer customer) 
	{


		for (Transaction transaction : setOfTransaction) 
		{
			int transactionMonth=transaction.getTransaction_date().getMonth()+1;
			if(currentMonth==transactionMonth)
				customer.setThirdMonthRewards(customer.getThirdMonthRewards()+calculateRewardAmountPerTransaction(transaction.getTransaction_amount()));
			else if(currentMonth-1==transactionMonth)
				customer.setSecoundMonthRewards(customer.getSecoundMonthRewards()+calculateRewardAmountPerTransaction(transaction.getTransaction_amount()));
			else if(currentMonth-2==transactionMonth)
				customer.setFirstMonthRewards(customer.getFirstMonthRewards()+calculateRewardAmountPerTransaction(transaction.getTransaction_amount()));

		}	
	}


}
