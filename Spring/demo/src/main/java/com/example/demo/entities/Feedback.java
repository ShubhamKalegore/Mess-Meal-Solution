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
@Table(name = "")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int feed_id;
	
	@Column
	int rating;
	
	@Column
	String description;
	
	@Column
	Date feedack_date;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "delivery_id")
	@JsonIgnoreProperties("feed")
	FoodDelivery fooddel;
}
