package com.interviewexperience.dao;

import java.util.List;

import com.interviewexperience.model.VisaType;

public interface VisaTypeDao {

	public void insert(VisaType visaType);
	public void insertBatch(List<VisaType> visaTypes);
	public List<VisaType> loadAllVisaTypes();
	public List<VisaType> findVisaTypeByCountryCode(String countryCode);
	public VisaType findVisaTypeByUUID(String uuid);
	
}
