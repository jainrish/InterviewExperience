package com.interviewexperience.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.cxf.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interviewexperience.cache.EnumsCache;
import com.interviewexperience.exception.InterviewExperienceException;
import com.interviewexperience.model.Consulate;
import com.interviewexperience.model.VisaInterview;
import com.interviewexperience.model.VisaType;

@Service
public class ValidateVisaInterview implements Validator<VisaInterview> {

	@Autowired
	EnumsCache enumsCache;
	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
	
	
	@Override
	public void validate(VisaInterview visaInterview) throws InterviewExperienceException{
		StringBuilder errorList = new StringBuilder();
		if(StringUtils.isEmpty(visaInterview.getConsulateID()) || enumsCache.getEnumsById(visaInterview.getConsulateID(), Consulate.class)==null) {
			errorList.append("ConsulateID is invalid | ");
		}
		
		if(StringUtils.isEmpty(visaInterview.getVisaTypeUUID()) || enumsCache.getEnumsById(visaInterview.getVisaTypeUUID(), VisaType.class)==null) {
			errorList.append("VisaType is invalid | ");
		}
		
		try {
			if (!StringUtils.isEmpty(visaInterview.getDate())) {
				simpleDateFormat.parse(visaInterview.getDate());
			}
		} catch (ParseException ex) {
			errorList.append("VisaDate is invalid | ");
		}
		
		if(errorList.length()!=0) {
			throw new InterviewExperienceException(errorList.toString());
		}
	}
}
