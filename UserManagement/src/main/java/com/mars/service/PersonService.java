package com.mars.service;

import java.util.List;
import java.util.Optional;

import com.mars.model.Address;
import com.mars.model.Person;

public interface PersonService {
	

	public List<Person> getAllPersons() throws Exception;
	public Person addPerson(Person person) throws Exception;
	public Person updatePerson(Person person) throws Exception;	
	public void deletePerson(long personId)  throws Exception;
	public Optional<Person> getPerson(long personid)  throws Exception;	
	public List<Address> getAllAddressForPerson(long personId) throws Exception;
	public void addAddress(Person person) throws Exception;
	public Person updateAddress(Person person) throws Exception;
	public Optional<Address> getAddress(long addressId) throws Exception;
	public void deleteAddress(long addressId) throws Exception;
	
}
