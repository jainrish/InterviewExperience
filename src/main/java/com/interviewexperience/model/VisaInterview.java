package com.interviewexperience.model;

import java.util.List;

public class VisaInterview {

	private String interviewUUID;
	private String date;
	private String consulateID;
	private String visaTypeUUID;
	private String status;
	private String intervieweeName;
	private List<InterviewConversation> conversations;

	public VisaInterview(String interviewUUID, String date, String consulateID,
			String visaTypeUUID, String status, String intervieweeName,
			List<InterviewConversation> conversations) {
		super();
		this.interviewUUID = interviewUUID;
		this.date = date;
		this.consulateID = consulateID;
		this.visaTypeUUID = visaTypeUUID;
		this.status = status;
		this.intervieweeName = intervieweeName;
		this.conversations = conversations;
	}

	public String getInterviewUUID() {
		return interviewUUID;
	}

	public String getDate() {
		return date;
	}

	public String getConsulateID() {
		return consulateID;
	}

	public String getVisaTypeUUID() {
		return visaTypeUUID;
	}

	public String getStatus() {
		return status;
	}

	public String getIntervieweeName() {
		return intervieweeName;
	}

	public List<InterviewConversation> getConversations() {
		return conversations;
	}

}
