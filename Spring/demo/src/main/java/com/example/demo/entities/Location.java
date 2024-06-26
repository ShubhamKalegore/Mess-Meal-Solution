package com.example.demo.entities;

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
@Table(name = "location")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int location_id;
	
	@Column
	String address;
	
	@Column
	int pincode;
	
	@Column
	String state;
	
	@OneToOne(mappedBy = "location", cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	@JsonIgnoreProperties("location")
	User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("location")
	MessOwner messowner;
}
