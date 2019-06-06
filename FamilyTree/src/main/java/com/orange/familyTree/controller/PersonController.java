package com.orange.familyTree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orange.familyTree.entity.Person;
import com.orange.familyTree.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	
	@GetMapping(value="/{nickName}/{genealogyName}/node")
	public Person findByname(@PathVariable("nickName") String nickName,
			@PathVariable("genealogyName") String genealogyName,
			@RequestParam("pn") String personName) {
		return personService.getPerson(nickName, genealogyName, personName);
	}
	
	@GetMapping(value="/{nickName}/{genealogyName}/edge")
	public List<Person> getShortPath(@PathVariable("nickName") String nickName, 
			@PathVariable("genealogyName") String genealogyName, 
			@RequestParam("spm") String startPersonName, @RequestParam("epn") String endPersonName){
		return personService.findShortPath(nickName, genealogyName, startPersonName, 
				endPersonName);
		
	}


}
