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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "plan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Plan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int plan_id;
	
	@Column
	String plan_type;	//daily, monthly, weakly
	
	@Column
	int price;
	
	@Column
	String plan_description;
	
	@Column
	String type;   // veg, nonveg
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "owner_id")
	@JsonIgnoreProperties("plan")
	MessOwner messowner;
	
	@OneToOne(mappedBy = "plan", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("plan")
	TodaysMenu tme;
	
	@OneToMany(mappedBy = "plan", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("plan")
	Set<Subscription>subscription  = new HashSet<>();
	
}














