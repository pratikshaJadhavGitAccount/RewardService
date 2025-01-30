package com.infosys.rewardseller.RewardService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.rewardseller.RewardService.exception.CustomerNotFoundException;
import com.infosys.rewardseller.RewardService.exception.InvalidException;
import com.infosys.rewardseller.RewardService.model.Customer;
import com.infosys.rewardseller.RewardService.model.CustomerDetails;
import com.infosys.rewardseller.RewardService.model.Reward;
import com.infosys.rewardseller.RewardService.repository.CustomerDetailsRepo;
import com.infosys.rewardseller.RewardService.repository.CustomerRepo;
import com.infosys.rewardseller.RewardService.repository.RewardRepo;

@Service
public class RewardService {

	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	RewardRepo rewardRepo;
	@Autowired
	CustomerDetailsRepo customerDetailsRepo;

	public double calculateRewardPoints(double amount) {
		return calculatePoints(amount);
	}

	public double calculateRewardforCustomerById(String name) {
		CustomerDetails findByName = customerDetailsRepo.findByName(name).get(0);
		Customer cust = findByName.getCustomer();
		double purchaseAmt = cust.getSpentAmt();
		if (purchaseAmt <= 0) {
			throw new InvalidException("Reward is not applicable for zero payment");
		}
		double calculatePoints = calculatePoints(purchaseAmt);
		Reward reward = new Reward(purchaseAmt, calculatePoints);
		rewardRepo.save(reward);
		return calculatePoints(purchaseAmt);
	}

	public CustomerDetails registerCustomer(CustomerDetails customer) {
		return customerDetailsRepo.save(customer);
	}

	private double calculatePoints(double amount) {
		double point = 0;
		if (amount > 100) {
			double a = amount - 100;
			point = point + (a * 2);
			if (amount >= 50) {
				point += 50 * 1;
			}
		}
		return point;
	}

	public void deleteCustomer(int id) {
		CustomerDetails cust = customerDetailsRepo.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("Customer is not availabel with id" + id));
		customerDetailsRepo.delete(cust);
	}

	public List<Customer> getAllCustomers() {
		List<Customer> customers = customerRepo.findAll();
		return customers;
	}

	public Customer updateCustomer(Long id, Customer custDetails) {
		Customer customer = customerRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer is not available"));
		customer.setName(custDetails.getName());
		customer.setDate(custDetails.getDate());
		customer.setReward(custDetails.getReward());
		customer.setCustomerDetails(custDetails.getCustomerDetails());
		customer.setSpentAmt(custDetails.getSpentAmt());
		customerRepo.save(customer);
		return null;
	}
}
