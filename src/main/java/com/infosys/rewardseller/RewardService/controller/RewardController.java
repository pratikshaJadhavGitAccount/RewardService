package com.infosys.rewardseller.RewardService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.rewardseller.RewardService.model.Customer;
import com.infosys.rewardseller.RewardService.model.CustomerDetails;
import com.infosys.rewardseller.RewardService.service.RewardService;

@RestController
@RequestMapping("/api/reward")
public class RewardController {

	@Autowired
	RewardService service;

	@PostMapping("/register")
	public ResponseEntity<CustomerDetails> register(@RequestBody CustomerDetails customer) {
		return ResponseEntity.ok(service.registerCustomer(customer));
	}

	@GetMapping("/getAllCustomer")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return ResponseEntity.ok(service.getAllCustomers());
	}

	@PutMapping("/updateCustDetails/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer custDetails) {
		return ResponseEntity.ok(service.updateCustomer(id, custDetails));
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
		service.deleteCustomer(id);
		return ResponseEntity.ok("Successfully deleted customer");
	}

	@GetMapping("/getRewardForCustomer/{name}")
	public ResponseEntity<Double> calculateRewardPointForCustomer(@PathVariable String name) {
		return ResponseEntity.ok(service.calculateRewardforCustomerById(name));
	}

	@GetMapping("/calculate/{amount}")
	public ResponseEntity<Double> getRewardPoints(@PathVariable double amount) {
		return ResponseEntity.ok(service.calculateRewardPoints(amount));
	}

}
