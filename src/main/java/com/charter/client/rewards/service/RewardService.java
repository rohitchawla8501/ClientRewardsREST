/**
 * 
 */
package com.charter.client.rewards.service;


import java.util.List;

import com.charter.client.rewards.dto.Customer;

/**
 * @author rohitchawla
 *
 */
public interface RewardService {

	
	List<Customer> calculateRewardsAll();
	
	Customer calculateRewardsbyId(Integer id);
}
