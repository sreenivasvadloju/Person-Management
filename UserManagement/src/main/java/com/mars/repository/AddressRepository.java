package com.mars.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mars.model.Address;
import com.mars.model.Person;

public interface AddressRepository extends JpaRepository<Address, Long> {

	 List<Address> findByPersonId(Long instructorId);
	 Optional<Person> findByIdAndPersonId(Long id, Long personId);
}
