package com.interviewexperience.dao.impl;

import static com.interviewexperience.constants.IConstants.*;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.interviewexperience.dao.VisaInteviewDao;
import com.interviewexperience.dao.rowmapper.RowMappers;
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
		getJdbcTemplate().update(VISA_INTERVIEW_INSERT,
				visaInterview.getInterviewUUID(), visaInterview.getDate(),
				visaInterview.getConsulateID(),
				visaInterview.getVisaTypeUUID(), visaInterview.getStatus(),
				visaInterview.getIntervieweeName());

	}

	@Override
	public VisaInterview getVisaInterviewByUUID(String uuid) {
		List<VisaInterview> visaInterviews = getJdbcTemplate().query(
				VISA_INTERVIEW_GET_BY_UUID, new Object[] { uuid },
				RowMappers.getVisaInterviewRowMapper());
		if(CollectionUtils.isEmpty(visaInterviews)) {
			return null;
		}

		return visaInterviews.get(0);
	}

}
