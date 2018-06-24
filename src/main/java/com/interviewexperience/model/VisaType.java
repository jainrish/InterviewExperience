package com.interviewexperience.model;

public class VisaType {

	private String visaTypeUUID;
	private String country;
	private String visaCode;
	private String visaDescription;

	public VisaType(String visaTypeUUID, String country, String visaCode,
			String visaDescription) {
		super();
		this.visaTypeUUID = visaTypeUUID;
		this.country = country;
		this.visaCode = visaCode;
		this.visaDescription = visaDescription;
	}

	public String getVisaTypeUUID() {
		return visaTypeUUID;
	}

	public String getCountry() {
		return country;
	}

	public String getVisaCode() {
		return visaCode;
	}

	public String getVisaDescription() {
		return visaDescription;
	}

}
