package com.interviewexperience.model;

public class Consulate {

	private String consulateID;
	private String visaCountry;
	private String consulateCity;
	private String consulateCountry;
	
	public Consulate(String consulateID, String visaCountry,
			String consulateCity, String consulateCountry) {
		super();
		this.consulateID = consulateID;
		this.visaCountry = visaCountry;
		this.consulateCity = consulateCity;
		this.consulateCountry = consulateCountry;
	}

	public String getConsulateID() {
		return consulateID;
	}

	public String getVisaCountry() {
		return visaCountry;
	}

	public String getConsulateCity() {
		return consulateCity;
	}

	public String getConsulateCountry() {
		return consulateCountry;
	}
	
	
}
