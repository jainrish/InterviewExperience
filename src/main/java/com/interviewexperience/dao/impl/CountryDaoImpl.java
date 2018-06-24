package com.interviewexperience.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import static com.interviewexperience.constants.IConstants.*;

import com.interviewexperience.dao.CountryDao;
import com.interviewexperience.dao.rowmapper.RowMappers;
import com.interviewexperience.exception.InterviewExperienceException;
import com.interviewexperience.model.Country;

@Repository
public class CountryDaoImpl extends JdbcDaoSupport implements CountryDao {

	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	public void initialize() {
		setDataSource(dataSource);
	}
	
	
	@Override
	public void insert(Country country) {
		getJdbcTemplate().update(COUNTRY_INSERT, country.getName(), country.getIso2LetterCode(), country.getIso3LetterCode(), country.getUnNumber(), country.getDialingCode());
		
	}

	@Override
	public void insertBatch(List<Country> countries) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Country> loadAllCountries() {
		return getJdbcTemplate().query(COUNTRY_GET_ALL, RowMappers.getCountryRowMapper());
	}

	@Override
	public Country findCountryByCountryName(String countryName)
			throws InterviewExperienceException {
		List<Country> result = getCountryList(COUNTRY_GET_BY_NAME, new Object[]{countryName});
		if(CollectionUtils.isEmpty(result)) {
			throw new InterviewExperienceException("Invalid country name");
		}
		return result.get(0);
	}

	@Override
	public Country findCountryByISO3Code(String iso3Code)
			throws InterviewExperienceException {
		List<Country> result = getCountryList(COUNTRY_GET_BY_ISO_3_CODE, new Object[]{iso3Code});
		if(CollectionUtils.isEmpty(result)) {
			throw new InterviewExperienceException("Invalid country iso3Code");
		}
		return result.get(0);
	}

	@Override
	public Country findCountryByISO2Code(String iso2Code)
			throws InterviewExperienceException {
		List<Country> result = getCountryList(COUNTRY_GET_BY_ISO_2_CODE, new Object[]{iso2Code});
		if(CollectionUtils.isEmpty(result)) {
			throw new InterviewExperienceException("Invalid country iso2Code");
		}
		return result.get(0);
	}
	
	private List<Country> getCountryList(String sql, Object[] args) {
		return getJdbcTemplate().query(sql, args, RowMappers.getCountryRowMapper());
	}

}
