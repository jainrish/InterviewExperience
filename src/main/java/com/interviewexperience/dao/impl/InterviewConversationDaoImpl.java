package com.interviewexperience.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import static com.interviewexperience.constants.IConstants.*;

import com.interviewexperience.dao.InterviewConversationDao;
import com.interviewexperience.dao.rowmapper.RowMappers;
import com.interviewexperience.model.InterviewConversation;

@Repository
public class InterviewConversationDaoImpl extends JdbcDaoSupport implements
		InterviewConversationDao {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public void insertConversation(InterviewConversation interviewConversation) {
		getJdbcTemplate().update(CONVERSATION_INSERT,
				interviewConversation.getInterviewUUID(),
				interviewConversation.getSequenceNumber(),
				interviewConversation.getSpeakerIdentity(),
				interviewConversation.getMessage());
	}

	@Override
	public List<InterviewConversation> findConversationByInterviewUUID(
			String interviewUUID) {
		return getJdbcTemplate().query(CONVERSATION_GET_BY_INTERVIEW_UUID,
				new Object[] { interviewUUID },
				RowMappers.getInterviewConversationRowMapper());
	}

}
