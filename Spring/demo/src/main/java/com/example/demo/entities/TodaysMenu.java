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
@Table(name = "plan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodaysMenu {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	int menu_id;
	
	@Column
	Date date;
	
	@Column
	String meal_dinner;
	
	@Column
	String description;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "plan_id")
	@JsonIgnoreProperties("tme")
	Plan plan;
}