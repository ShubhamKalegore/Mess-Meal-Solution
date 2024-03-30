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
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int user_id;
	
	@Column
	String username;
	
	@Column
	String email;
	
	@Column
	String mobno;
	
	@Column
	Boolean status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="login_id")
	@JsonIgnoreProperties("users")
	Login login;
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("user")
	Location loc;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	@JsonIgnoreProperties("user")
	Set<MessOwner> tiffServ=new HashSet<>();
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("user")
	Subscription subcription;
	
}
