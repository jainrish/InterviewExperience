package com.interviewexperience.businesslogic;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interviewexperience.exception.InterviewExperienceException;
import com.interviewexperience.model.InterviewConversation;
import com.interviewexperience.model.VisaInterview;
import com.interviewexperience.validator.ValidateVisaInterview;

@Service
public class VisaInterviewService {

	@Autowired
	ValidateVisaInterview validateVisaInterview;
	
	
	
	@Transactional
	public void addInterview(VisaInterview visaInterview) throws InterviewExperienceException{
		validateVisaInterview.validate(visaInterview); 
		String interviewUUID = "visa_".concat(UUID.randomUUID().toString());
		int countMessage = 1;
		for(InterviewConversation interviewConversation : visaInterview.getConversations()) {
			
		}
	}
	
	
}
