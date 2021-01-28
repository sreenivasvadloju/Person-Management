package com.mars.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "person")
public class Person implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
    @NotBlank(message = "First Name is mandatory")
    @Column(name="firstName")
	private String firstName;
	
    @NotBlank(message = "Last Name is mandatory")
    @Column(name="lastName")
	private String lastName;
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Address> addressList;	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(Set<Address> addressList) {
		this.addressList = addressList;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

}