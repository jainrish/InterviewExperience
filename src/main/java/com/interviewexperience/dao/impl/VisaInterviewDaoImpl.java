package com.interviewexperience.dao.impl;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.interviewexperience.constants.IConstants;
import com.interviewexperience.dao.VisaInteviewDao;
import com.interviewexperience.model.VisaInterview;

@Repository
public class VisaInterviewDaoImpl extends JdbcDaoSupport implements
		VisaInteviewDao {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	public void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public void insertVisaInterview(VisaInterview visaInterview) {
		getJdbcTemplate().update(IConstants.VISA_INTERVIEW_INSERT,
				visaInterview.getInterviewUUID(), visaInterview.getDate(),
				visaInterview.getConsulateID(),
				visaInterview.getVisaTypeUUID(), visaInterview.getStatus(),
				visaInterview.getIntervieweeName());

	}

	@Override
	public VisaInterview getVisaInterviewByUUID(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

}
