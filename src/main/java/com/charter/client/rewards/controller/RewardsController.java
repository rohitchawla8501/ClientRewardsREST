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
import com.charter.client.rewards.ExceptionHandling.CustomerNotFoundException;
import com.charter.client.rewards.dto.Customer;
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

	@GetMapping("/")
	public ResponseEntity<String> indexRoot() {
		return new ResponseEntity<>("Welcome To Client Rewards REST API.Please enter a valid URL such as /customers/rewards  Or a customer with Valid ID /customers/rewards/{id}", HttpStatus.OK);

	}

	@GetMapping("/customers/rewards")
	public ResponseEntity<List<Customer>> getAllCustomerRewards() {
			logger.info("Entered getAllCustomerRewards method");
			List<Customer> customerList = rewardService.calculateRewardsAll();
			if (customerList.isEmpty() || customerList.size() == 0) 
			{
				logger.error("Customer List is empty");
				throw new CustomerNotFoundException("No Customer Data");
			}
			return new ResponseEntity<>(customerList, HttpStatus.OK);
	}

	@GetMapping("/customers/rewards/{id}")
	public ResponseEntity<Customer> getCustomerRewardsById(@PathVariable Integer id) {
		logger.info("Entered getCustomerRewardsById method");
		Customer customer= rewardService.calculateRewardsbyId(id);

		if ( customer==null) {
			logger.error("Customer Object is empty/No Customer found");
			throw new CustomerNotFoundException("Customer id '" + id + "' does not exist");
			//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			//return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/")).build();
		}

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
}
