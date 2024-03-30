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
@Table(name = "messowner")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessOwner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int owner_id;
	
	@Column
	String mess_name;
	
	@Column
	String mess_discription;
	
	@Column
	Boolean mess_availability;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="location_id")
	@JsonIgnoreProperties("messowner")
	Location location;
	
	@OneToMany(mappedBy = "messowner", cascade=CascadeType.ALL)
	@JsonIgnoreProperties("messowner")
	Set<Plan> plan=new HashSet<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	@JsonIgnoreProperties("messowner")
	User user;
	
	
	
}
