package com.infosys.rewardseller.RewardService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infosys.rewardseller.RewardService.model.Customer;
import com.infosys.rewardseller.RewardService.model.CustomerDetails;

@Repository
public interface CustomerDetailsRepo extends JpaRepository<CustomerDetails, Integer>{
	
	

	List<CustomerDetails> findByName(String name);
}
