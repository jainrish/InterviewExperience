package com.interviewexperience.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interviewexperience.dao.impl.ConsulateDaoImpl;

@RestController
@Produces("application/json")
@Consumes("application/json")
public class ConsulateController {

	@Autowired
	ConsulateDaoImpl consulateDaoImpl;
	
	
	@GET
	@RequestMapping("/consulate/{consulateID}")
	public ResponseEntity<Object> getConsulateByID(@PathVariable("consulateID") String consulateID) {
		return ResponseEntity.ok(consulateDaoImpl.findConsulateByID(consulateID));
	}
	
	@GET
	@RequestMapping("/consulates")
	public ResponseEntity<Object> getConsulates() {
		return ResponseEntity.ok(consulateDaoImpl.loadAllConsulates());
	}
}
