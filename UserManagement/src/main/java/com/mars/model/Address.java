package com.mars.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

	@Entity
    @Table(name="address")
	
	public class Address implements Serializable { 

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	 @NotBlank(message = "Street Name is mandatory")
	@Column(name="street")
	private String street;  
	
	 @NotBlank(message = "City Name is mandatory")
	@Column(name="city")
	private String city;
	
	 @NotBlank(message = "State Name is mandatory")
	@Column(name="state")
	private String state;
	
	 @NotBlank(message = "Postal Code Name is mandatory")
	@Column(name="postalcode")
	private String postalcode;
	
	@ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;	
    
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	
}
