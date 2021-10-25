/**
 * 
 */
package com.charter.client.rewards.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.charter.client.rewards.dto.Customer;
import com.charter.client.rewards.repository.RewardRepository;
import com.charter.client.rewards.service.RewardService;

/**
 * @author rohitchawla
 *
 */

@RestController
public class RewardsController {
	
	 Logger logger = LoggerFactory.getLogger(RewardsController.class);

	@Autowired
	private RewardService rewardService;

	@Autowired
	private RewardRepository rewardRepository;

	@GetMapping("/customers/rewards")
	public ResponseEntity<List<Customer>> getAllCustomerRewards() {
		try {
			 logger.info("Entered getAllCustomerRewards method");
			List<Customer> list = rewardService.calculateRewardsAll();
			if (list.isEmpty() || list.size() == 0) {
				logger.error("Customer List is empty");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Catch block -- Error getAllCustomerRewards");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/customers/rewards/{id}")
	public ResponseEntity<Customer> getCustomerRewardsById(@PathVariable Integer id) {
		try {
			 logger.info("Entered getCustomerRewardsById method");
			Customer customer= rewardService.calculateRewardsbyId(id);

			if ( customer==null) {
				logger.error("Customer Object is empty/No Customer");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				
			}

			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} catch (Exception e) 
		{
			logger.error("Catch block -- Error getCustomerRewardsById");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
