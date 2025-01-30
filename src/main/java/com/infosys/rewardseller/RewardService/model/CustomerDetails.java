package com.infosys.rewardseller.RewardService.model;

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

@Entity
@Data
@NoArgsConstructor
@Table(name = "CustomerDetails")
public class CustomerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "customer_id",referencedColumnName = "id")
	private Customer customer;
	public CustomerDetails(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	

}
