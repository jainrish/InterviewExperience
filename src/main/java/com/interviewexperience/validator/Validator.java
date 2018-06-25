package com.interviewexperience.validator;

import com.interviewexperience.exception.InterviewExperienceException;

public interface Validator<T> {

	public void validate(T t) throws InterviewExperienceException;
}
