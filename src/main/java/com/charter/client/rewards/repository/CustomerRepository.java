package com.charter.client.rewards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charter.client.rewards.dto.Customer;

@Repository
	public interface CustomerRepository extends JpaRepository<Customer, Integer> {}

