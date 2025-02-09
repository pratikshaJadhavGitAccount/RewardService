package com.infosys.rewardseller.RewardService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "reward")
public class Reward {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double point;
	private double amount;

	@OneToOne(mappedBy = "reward")
	private Customer customer;

	public Reward(double point, double amount) {
		this.point = point;
		this.amount = amount;

	}

}
