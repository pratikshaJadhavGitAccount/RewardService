package com.infosys.rewardseller.RewardService.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
//	private String password;
	private LocalDate date;
	private Double spentAmt;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "reward_id",referencedColumnName = "id")
	private Reward reward;
	
	@OneToOne(mappedBy = "customer" )
	//@JoinColumn(name= "customerDetails_id",referencedColumnName = "id")
	private CustomerDetails customerDetails;

	public Customer( String name,
			//String password,
			LocalDate date,Double spentAmt, Reward reward,
			CustomerDetails customerDetails){
		this.name=name;
		//this.password=password;
		this.date =date;
		this.spentAmt= spentAmt;
		this.reward=reward;
		this.customerDetails=customerDetails;
	}
}
