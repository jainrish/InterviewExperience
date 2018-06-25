package com.interviewexperience.dao.rowmapper;

import org.springframework.jdbc.core.RowMapper;

import com.interviewexperience.model.Consulate;
import com.interviewexperience.model.Country;
import com.interviewexperience.model.InterviewConversation;
import com.interviewexperience.model.VisaInterview;
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
	
	public static RowMapper<InterviewConversation> getInterviewConversationRowMapper() {
		return (rs, row) -> new InterviewConversation(rs.getString("interview_uuid_fk"), (Integer)rs.getObject("sequence_number"), rs.getString("speaker_id"), rs.getString("message"));
	}
	
	public static RowMapper<VisaInterview> getVisaInterviewRowMapper() {
		return (rs, row) -> new VisaInterview(rs.getString("interview_uuid"), rs.getString("date"), rs.getString("consulate_id_fk"), rs.getString("visa_type_uuid_fk"), rs.getString("status"), rs.getString("interviewee_name"));
	}
}
