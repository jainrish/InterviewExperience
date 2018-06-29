package com.interviewexperience.dao;

import java.util.List;

import com.interviewexperience.model.Consulate;


public interface ConsulateDao {
	
	public void insert(Consulate consulate);
	public void insertBatch(List<Consulate> consulates);
	public List<Consulate> loadAllConsulates();
	public Consulate findConsulateByID(String consulateID);
	public List<Consulate> findConsulateByVisaCountry(String visaCountry);
	
}
