package com.interviewexperience.model;

public class InterviewConversation {

	private String interviewUUID;
	private Integer sequenceNumber;
	private String speakerIdentity;
	private String message;

	public InterviewConversation(String interviewUUID, Integer sequenceNumber,
			String speakerIdentity, String message) {
		super();
		this.interviewUUID = interviewUUID;
		this.sequenceNumber = sequenceNumber;
		this.speakerIdentity = speakerIdentity;
		this.message = message;
	}

	public String getInterviewUUID() {
		return interviewUUID;
	}

	public Integer getSequenceNumber() {
		return sequenceNumber;
	}

	public String getSpeakerIdentity() {
		return speakerIdentity;
	}

	public String getMessage() {
		return message;
	}

}
