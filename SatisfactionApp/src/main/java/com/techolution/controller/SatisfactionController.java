package com.techolution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techolution.dto.Satisfaction;
import com.techolution.service.SatisfactionService;

/**
 * @author M1029444
 *
 */
@RestController
public class SatisfactionController {
	
	@Autowired
	private SatisfactionService service;

	@RequestMapping(value="/findSatisfaction", method=RequestMethod.GET)
	public ResponseEntity<Satisfaction> findSatisfaction(){
		System.out.println("Controller : " + service);
		Satisfaction satisfaction = service.findSatisfaction();
		
		return new ResponseEntity<Satisfaction>(satisfaction, HttpStatus.OK);
	}
}
