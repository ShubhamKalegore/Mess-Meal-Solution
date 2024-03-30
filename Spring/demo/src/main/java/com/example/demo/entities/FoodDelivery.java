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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "fooddelivery")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodDelivery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int delivery_id;
	
	@Column
	Date delivery_date;
	
	@Column
	Boolean delivery_status;
	
	@Column
	Float amount;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sub_id")
	@JsonIgnoreProperties("fd")
	Subscription sub;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("fooddel")
	Feedback feed;
}









