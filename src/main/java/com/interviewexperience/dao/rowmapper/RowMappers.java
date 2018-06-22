package com.interviewexperience.dao.rowmapper;

import org.springframework.jdbc.core.RowMapper;

import com.interviewexperience.model.Consulate;

public class RowMappers {

	public static RowMapper<Consulate> getConsulateRowMapper() {
		return (rs, row) -> new Consulate(rs.getString("consulate_id"), rs.getString("visa_country"), rs.getString("consulate_city"), rs.getString("consulate_country")); 
	}
}
