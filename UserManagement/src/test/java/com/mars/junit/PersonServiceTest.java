package com.mars.junit;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mars.model.Person;
import com.mars.repository.PersonRepository;
import com.mars.service.PersonService;



@SpringBootTest
public class PersonServiceTest {

	@Autowired
	private PersonService personService;
	
	@MockBean
	private PersonRepository personRepository;
	
	@org.junit.jupiter.api.Test
	public void testSavePersonSucess() throws Exception{

		Person person = new Person();
		person.setFirstName("Sree");
		person.setLastName("Vad");

		Mockito.when(personRepository.save(person)).thenReturn(person);
	    assertThat(personService.addPerson(person)).isEqualTo(person);
	}	

	
	@Test
	public void testGetPersonbyIdSuccess() throws Exception{	
		Person person = new Person();
		person.setId(5);
		person.setFirstName("Sree");
		person.setLastName("Vad");
		Optional<Person> personOptional = Optional.of(person);		
		long id=6;
	    Mockito.when(personRepository.findById(id)).thenReturn(personOptional);
	    assertThat(personService.getPerson(id)).isEqualTo(personOptional);
	}
	
	@Test
	public void testDeletePerson(){
		Person person = new Person();
		person.setId(5);
		person.setFirstName("Sree");
		person.setLastName("Vad");
		Optional<Person> personOptional = Optional.of(person);	
		long myId=9;
	    Mockito.when(personRepository.findById(myId)).thenReturn(personOptional);
	    Mockito.when(personRepository.existsById(person.getId())).thenReturn(false);
 
	}

	
	
}
