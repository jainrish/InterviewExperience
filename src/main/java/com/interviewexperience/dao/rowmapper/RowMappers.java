package com.interviewexperience.dao.rowmapper;

import org.springframework.jdbc.core.RowMapper;

import com.interviewexperience.model.Consulate;
import com.interviewexperience.model.Country;
import com.interviewexperience.model.VisaType;

public class RowMappers {

	public static RowMapper<Consulate> getConsulateRowMapper() {
		return (rs, row) -> new Consulate(rs.getString("consulate_id"), rs.getString("visa_country"), rs.getString("consulate_city"), rs.getString("consulate_country")); 
	}
	
	public static RowMapper<VisaType> getVisaTypeRowMapper() {
		return (rs, row) -> new VisaType(rs.getString("visa_type_uuid"), rs.getString("country_code"), rs.getString("visa_code"), rs.getString("visa_description"));
	}
	
	public static RowMapper<Country> getCountryRowMapper() {
		return (rs, row) -> new Country(rs.getString("country_name"), rs.getString("iso_2_code"), rs.getString("iso_3_code"), rs.getInt("un_number"), rs.getString("dialing_code"));
	}
}
