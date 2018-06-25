package com.interviewexperience.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interviewexperience.businesslogic.VisaInterviewService;
import com.interviewexperience.exception.InterviewExperienceException;
import com.interviewexperience.model.VisaInterview;


@RestController
@Produces("application/json")
@Consumes("application/json")
public class InterviewController {

	@Autowired
	VisaInterviewService visaInterviewService;
	
	@GET
	@RequestMapping("/interview/{interviewUUID}")
	public ResponseEntity<Object> getInterviewByUUID(@PathVariable("interviewUUID") String interviewUUID) {
		return ResponseEntity.ok(visaInterviewService.getVisaInterview(interviewUUID));
	}
	
	@POST
	@RequestMapping("/interview")
	public ResponseEntity<Object> insertInterview(@RequestBody VisaInterview visaInterview) {
		try {
			visaInterviewService.addVisaInterview(visaInterview);
		} catch(InterviewExperienceException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("200");
	}
}
