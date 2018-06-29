package com.interviewexperience.businesslogic;

import java.util.UUID;

import org.apache.cxf.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interviewexperience.dao.impl.InterviewConversationDaoImpl;
import com.interviewexperience.dao.impl.VisaInterviewDaoImpl;
import com.interviewexperience.exception.InterviewExperienceException;
import com.interviewexperience.model.InterviewConversation;
import com.interviewexperience.model.VisaInterview;
import com.interviewexperience.validator.ValidateVisaInterview;

@Service
public class VisaInterviewService {

	@Autowired
	ValidateVisaInterview validateVisaInterview;
	
	@Autowired
	InterviewConversationDaoImpl interviewConversationDaoImpl;
	
	@Autowired
	VisaInterviewDaoImpl visaInterviewDaoImpl;
	
	
	@Transactional
	public void addVisaInterview(VisaInterview visaInterview) throws InterviewExperienceException{
		validateVisaInterview.validate(visaInterview); 
		String interviewUUID = "visa-".concat(UUID.randomUUID().toString());
		System.out.println(interviewUUID);
		visaInterview.setInterviewUUID(interviewUUID);
		
		InterviewConversation interviewConversation = null;
		for(int i=0; i<visaInterview.getConversations().size();i++){
			interviewConversation = visaInterview.getConversations().get(i);
			interviewConversation.setSequenceNumber(i+1);
			interviewConversation.setInterviewUUID(interviewUUID);
			interviewConversation.setSpeakerIdentity(StringUtils.isEmpty(interviewConversation.getSpeakerIdentity()) ? "Thought/Comment" : interviewConversation.getSpeakerIdentity());
			interviewConversationDaoImpl.insertConversation(interviewConversation);
		}
		
		visaInterviewDaoImpl.insertVisaInterview(visaInterview);
	}
	
	public VisaInterview getVisaInterview(String interviewUUID) {
		VisaInterview visaInterview = visaInterviewDaoImpl.getVisaInterviewByUUID(interviewUUID);
		if(visaInterview!=null) {
			visaInterview.setConversations(interviewConversationDaoImpl.findConversationByInterviewUUID(interviewUUID));
		}
		return visaInterview;
	}
	
}
