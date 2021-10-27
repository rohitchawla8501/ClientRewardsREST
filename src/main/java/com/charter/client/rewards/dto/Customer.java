package com.charter.client.rewards.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author rohitchawla Customer DTO
 */

@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	int id;
	@Column
	String name;

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Transaction> transactions;

	@Transient
	int totalRewardAmount;
	@Transient
	int thirdMonthRewards;
	@Transient
	int secondMonthRewards;
	@Transient
	int firstMonthRewards;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public int getTotalRewardAmount() {
		return firstMonthRewards + secondMonthRewards + thirdMonthRewards;
	}

	public void setTotalRewardAmount(int totalRewardAmount) {
		this.totalRewardAmount = totalRewardAmount;
	}

	public int getThirdMonthRewards() {
		return thirdMonthRewards;
	}

	public void setThirdMonthRewards(int thirdMonthRewards) {
		this.thirdMonthRewards = thirdMonthRewards;
	}

	public int getSecondMonthRewards() {
		return secondMonthRewards;
	}

	public void setSecondMonthRewards(int secoundMonthRewards) {
		this.secondMonthRewards = secoundMonthRewards;
	}

	public int getFirstMonthRewards() {
		return firstMonthRewards;
	}

	public void setFirstMonthRewards(int firstMonthRewards) {
		this.firstMonthRewards = firstMonthRewards;
	}

}
