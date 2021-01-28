package com.mars.repository;

import org.springframework.data.repository.CrudRepository;

import com.mars.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}