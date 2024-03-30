package com.example.demo.entities;


import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "subscription")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int sub_id;
	
	@Column
	Date start_date;
	
	@Column
	Date end_date;
	
	@Column
	Boolean sub_status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="plan_id")
	@JsonIgnoreProperties("subscription")
	Plan plan;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties("subscription")
	User user;
	
	@OneToOne(mappedBy = "subscription",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("sub")
	Transaction transaction;
	
	@OneToOne(mappedBy = "subscription", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("sub")
	FoodDelivery fd;
	
}














