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
import org.springframework.web.bind.annotation.RequestParam;
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
		/*String uuid = "visa_" + UUID.randomUUID().toString();
		InterviewConversation interviewConversation1 = new InterviewConversation(uuid, 1 , "VO", "Good Morning, please pass your i20");
		InterviewConversation interviewConversation2 = new InterviewConversation(uuid, 2 , "ME", "Good Morning Mam, here!!");
		List<InterviewConversation> list = new ArrayList<InterviewConversation>();
		list.add(interviewConversation1);
		list.add(interviewConversation2);
		VisaInterview visaInterview = new VisaInterview(uuid, "2018/06/24", "USA_MDR", "80fff564-e1b4-4fa7-a58c-8332c789b4ef", InterviewStatus.APPROVED.toString(), "Rishabh Jain", list);*/
		
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
