package com.interviewexperience.dao;

import java.util.List;

import com.interviewexperience.model.InterviewConversation;

public interface InterviewConversationDao {

	public void insertConversation(InterviewConversation interviewConversation);
	public List<InterviewConversation> findConversationByInterviewUUID(String interviewUUID);
	
}
