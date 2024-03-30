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
@Table(name = "transaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int transaction_id;
	
	@Column
	int amount;
	
	@Column
	Boolean status;
	
	@Column
	Date tdate;
	
	@OneToOne(mappedBy = "subscription",cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties("transaction")
	Subscription sub;
}
