package com.webservice.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Produces("application/json")
@Consumes("application/json")
public class ReviewController {

	@GET
	@RequestMapping("/experiences")
	public ResponseEntity<Object> getExperiences() {
		return ResponseEntity.ok("Tested ok!!");
	}
	
}
