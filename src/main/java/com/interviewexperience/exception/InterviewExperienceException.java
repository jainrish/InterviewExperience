package com.interviewexperience.exception;

public class InterviewExperienceException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public InterviewExperienceException(String message) {
		super(message);
	}
	
	public InterviewExperienceException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public InterviewExperienceException(Throwable cause) {
		super(cause);
	}

}
