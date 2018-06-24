package com.interviewexperience.dao;

import java.util.List;

import com.interviewexperience.exception.InterviewExperienceException;
import com.interviewexperience.model.Country;


public interface CountryDao {

	public void insert(Country country);
	public void insertBatch(List<Country> countries);
	public List<Country> loadAllCountries();
	public Country findCountryByCountryName(String countryName) throws InterviewExperienceException;
	public Country findCountryByISO3Code(String iso3Code) throws InterviewExperienceException;
	public Country findCountryByISO2Code(String iso2Code) throws InterviewExperienceException;
	
}
