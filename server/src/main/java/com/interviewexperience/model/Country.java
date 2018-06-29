package com.interviewexperience.model;

public class Country {

	private String name;
	private String iso2LetterCode;
	private String iso3LetterCode;
	private Integer unNumber;
	private String dialingCode;

	public Country(String name, String iso2LetterCode, String iso3LetterCode,
			Integer unNumber, String dialingCode) {
		super();
		this.name = name;
		this.iso2LetterCode = iso2LetterCode;
		this.iso3LetterCode = iso3LetterCode;
		this.unNumber = unNumber;
		this.dialingCode = dialingCode;
	}

	public String getName() {
		return name;
	}

	public String getIso2LetterCode() {
		return iso2LetterCode;
	}

	public String getIso3LetterCode() {
		return iso3LetterCode;
	}

	public Integer getUnNumber() {
		return unNumber;
	}

	public String getDialingCode() {
		return dialingCode;
	}

}
