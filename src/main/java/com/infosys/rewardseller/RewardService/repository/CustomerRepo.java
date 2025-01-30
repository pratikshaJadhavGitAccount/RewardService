package com.infosys.rewardseller.RewardService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.rewardseller.RewardService.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{

}
