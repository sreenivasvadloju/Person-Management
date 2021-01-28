package com.mars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mars.model.Address;
import com.mars.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

	/*
	 * @Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
	 * public List<Address> getAllAddressForPerson(@Param("lastName") String
	 * lastName);
	 */
	
}