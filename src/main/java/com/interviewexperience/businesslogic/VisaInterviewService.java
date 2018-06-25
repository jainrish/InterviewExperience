package com.interviewexperience.businesslogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interviewexperience.exception.InterviewExperienceException;
import com.interviewexperience.model.VisaInterview;
import com.interviewexperience.validator.ValidateVisaInterview;

@Service
public class VisaInterviewService {

	@Autowired
	ValidateVisaInterview validateVisaInterview;
	
	public void addInterview(VisaInterview visaInterview) throws InterviewExperienceException{
		validateVisaInterview.validate(visaInterview);
		
	}
	
	
}
