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
import com.charter.client.rewards.dto.Customer;
import com.charter.client.rewards.dto.Transaction;
import com.charter.client.rewards.repository.CustomerRepository;

/**
 * @author rohitchawla
 *
 */
@Service
public class RewardServiceImpl implements RewardService {

	Logger logger = LoggerFactory.getLogger(RewardServiceImpl.class);

	@Autowired
	private CustomerRepository customerRepository;

	LocalDate currentdate = LocalDate.now();

	@Override
	public List<Customer> calculateRewardsAll() {
		logger.info("Entered calculateRewardsAll method of Service");
		List<Customer> customerList = customerRepository.findAll();
		if (!customerList.isEmpty())
		{   
			logger.info("Customer List is not empty, traversing the customer List");
			for(Customer customer : customerList) 
			{
				logger.debug("Getting customer transactions by Id and calculating rewards for customer " +customer.getName());
				Set<Transaction> setOfTransaction =customer.getTransactions();
				rewardsSetperMonth(setOfTransaction,customer);
				logger.debug("End of reward calculation for customer" +customer.getName());
			}

		}
		logger.info("Entered calculateRewardsAll method of Service");
		return customerList;
	}

	@Override
	public Customer calculateRewardsbyId(Integer customerId)

	{
		logger.info("Entered calculateRewardsbyId method of Service");

		Customer customer=customerRepository.findById(customerId).orElse(null);
		if (customer!=null) 
		{
			logger.debug("Getting customer transactions by Id and calculating rewards for customer " +customer.getName());
			Set<Transaction> setOfTransaction =customer.getTransactions();
			rewardsSetperMonth(setOfTransaction,customer);
			logger.debug("End of reward calculation for customer " +customer.getName());
		}
		logger.info("End of calculateRewardsbyId method of Service, Returning Customer details with Rewards");
		return customer;
	}

	private int calculateRewardAmountPerTransaction(int transactionAmount)
	{
		logger.debug("Transaction Amount " + transactionAmount);
		int rewardAmount=0;
		if (transactionAmount >=50 && transactionAmount <= 100) 
		{
			rewardAmount=transactionAmount-50;
		} 
		else if (transactionAmount >100)
		{
			rewardAmount=(2*(transactionAmount-100) + 50);
		}
		logger.debug("Reward Amount" + rewardAmount);
		return rewardAmount;
	}


	private void rewardsSetperMonth(Set<Transaction> setOfTransaction, Customer customer) 
	{


		for (Transaction transaction : setOfTransaction) 
		{
			int transactionMonth=transaction.getTransaction_date().getMonth()+1;
			int transactionYear=transaction.getTransaction_date().getYear()+1900;
			
			logger.debug("Calculating Rewards for customer" + customer.getName() + " for Transaction Id " + transaction.getId());
			
			if((currentdate.getYear()==transactionYear)&&(currentdate.getMonth().getValue()==transactionMonth))
				customer.setThirdMonthRewards(customer.getThirdMonthRewards()+calculateRewardAmountPerTransaction(transaction.getTransaction_amount()));
			else if((currentdate.minusMonths(1).getYear()==transactionYear)&& (currentdate.minusMonths(1).getMonth().getValue()==transactionMonth))
				customer.setSecondMonthRewards(customer.getSecondMonthRewards()+calculateRewardAmountPerTransaction(transaction.getTransaction_amount()));
			else if((currentdate.minusMonths(2).getYear()==transactionYear)&& (currentdate.minusMonths(2).getMonth().getValue()==transactionMonth))
				customer.setFirstMonthRewards(customer.getFirstMonthRewards()+calculateRewardAmountPerTransaction(transaction.getTransaction_amount()));

			logger.debug("End of Calculating Rewards for customer" + customer.getName() + " for Transaction Id " + transaction.getId());

		}	
	}
}
