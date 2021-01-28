package com.mars.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mars.exceptionhandler.CustomGenericException;
import com.mars.model.Address;
import com.mars.model.Person;
import com.mars.repository.AddressRepository;
import com.mars.repository.PersonRepository;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private AddressRepository addressRepository;
	
	public static final String PERSONS_NOT_FOUND="No Users found in the System";
	

	 @Override
	 public List<Person> getAllPersons() throws Exception {
		
		 List<Person> ll =  (List<Person>) personRepository.findAll();
		 if(ll.isEmpty()) {
			throw new CustomGenericException(PERSONS_NOT_FOUND);
		 }else {
			 return ll; 
		 }
	 }
	 
	 @Override
	 @Transactional
	 public Person addPerson(Person person) throws Exception{
		 return personRepository.save(person);
	 }
	 @Override
	 @Transactional
	 public Person updatePerson(Person person) throws Exception{ // TODO Auto-generated method
		return personRepository.save(person); 
	 }
	
	 @Override
	 @Transactional
	 public void deletePerson(long personId) throws Exception{
		 personRepository.deleteById(personId);
	 }
	 

	 public Optional<Person> getPerson(long personId) throws Exception{
		 return personRepository.findById(personId);		
	 }
	 
	
	 @Override
	 @Transactional
	 public List<Address> getAllAddressForPerson(long personId) throws Exception{
		 return addressRepository.findByPersonId(personId); 
	 }
		 
	@Override
	@Transactional	
	public void addAddress(Person person) throws Exception{
		personRepository.save(person);
	}
	
	@Override
	@Transactional
	public Person updateAddress(Person person) throws Exception{
		return personRepository.save(person);
	}
	
	public Optional<Address> getAddress(long addressId) throws Exception{
		 return addressRepository.findById(addressId); 		
	}
	
	@Override
	public void deleteAddress(long addressId) throws Exception{
		addressRepository.deleteById(addressId);
	}
	
}
