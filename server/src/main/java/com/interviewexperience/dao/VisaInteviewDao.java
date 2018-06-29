package com.interviewexperience.dao;

import com.interviewexperience.model.VisaInterview;

public interface VisaInteviewDao {

	public void insertVisaInterview(VisaInterview visaInterview);

	public VisaInterview getVisaInterviewByUUID(String uuid);

}
