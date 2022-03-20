package com.example.firstms.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstms.exception.MyCustomException;
import com.example.firstms.exception.PersonNotFoundException;
import com.example.firstms.model.Person;
import com.example.firstms.model.PersonDto;
import com.example.firstms.repository.PersonRepo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//@CrossOrigin(origins="https://www.w3schools.com")
@Api(tags="Persons End Points")
@RestController
public class PersonController {

	private static final Logger LOGGER=LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private PersonRepo repo;

	//@CrossOrigin(origins="https://www.w3schools.com")
	@ApiOperation(value = "Fetching all persons list", notes = "this returns all persons, so use it wisely")
	@ApiResponses({
	        @ApiResponse(code = 200, message = "Successfully Fetched", response = Person.class)
	})
	@GetMapping(path = "/persons", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Person> listPersons() {
		 
		LOGGER.info("##############Person Controller##################");
		return repo.findAll();
	}

	@GetMapping(path = "/persons-dto", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<PersonDto> getPersonsDto() {
	    List<Person> persons = repo.findAll();
	    List<PersonDto> personDtoList = new ArrayList<>();
	    // convert this into List<PersonDto>
	    for(Person person:persons) {
	    	PersonDto personDto=new PersonDto(person);
	    	personDtoList.add(personDto);
	    }
	     
	    return personDtoList;
	}
	
	@GetMapping(path = "/persons/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Person> getPerson(@PathVariable Integer id) {
       if(id==10) {
    	   throw new MyCustomException(121, "This id is not allowed");
       }
		Optional<Person> foundPerson = repo.findById(id);
		if (foundPerson.isPresent()) {
			return ResponseEntity.ok(foundPerson.get());
		}
	   throw new PersonNotFoundException();
	}

	@PostMapping(path = "/persons", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Person> addPersons(@RequestBody Person person) throws URISyntaxException {
		Person newPerson = repo.save(person);
		if (Objects.nonNull(newPerson.getId())) {
			return ResponseEntity.created(new URI(newPerson.getId().toString())).build();
		}
		return ResponseEntity.internalServerError().build();
	}

	@DeleteMapping(path = "/persons/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Person> deletePerson(@PathVariable Integer id) {

		repo.deleteById(id);
		
		return ResponseEntity.ok().build();
	}
}
