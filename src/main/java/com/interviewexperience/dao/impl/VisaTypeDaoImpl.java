package com.interviewexperience.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import static com.interviewexperience.constants.IConstants.*;

import com.interviewexperience.dao.VisaTypeDao;
import com.interviewexperience.dao.rowmapper.RowMappers;
import com.interviewexperience.exception.InterviewExperienceException;
import com.interviewexperience.model.VisaType;

@Repository
public class VisaTypeDaoImpl extends JdbcDaoSupport implements VisaTypeDao{

	@Autowired 
    DataSource dataSource;
 
    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }
    
	
	@Override
	public void insert(VisaType visaType) {
		getJdbcTemplate().update(VISA_TYPE_INSERT, visaType.getVisaTypeUUID(), visaType.getCountry(), visaType.getVisaCode(), visaType.getVisaDescription());
		
	}

	@Override
	public void insertBatch(List<VisaType> visaTypes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VisaType> loadAllVisaTypes() {
		getJdbcTemplate().execute("delete from VisaType where visa_type_uuid = '7bd4f297-b54c-4895-9cac-309b7ac0fb5e'");
		return getJdbcTemplate().query(VISA_TYPE_GET_ALL, RowMappers.getVisaTypeRowMapper());
	}

	
	@Override
	public List<VisaType> findVisaTypeByCountryCode(String countryCode) {
		return getJdbcTemplate().query(VISA_TYPE_GET_BY_COUNTRY_CODE, new Object[]{countryCode}, RowMappers.getVisaTypeRowMapper());
	}

	@Override
	public VisaType findVisaTypeByUUID(String uuid) throws InterviewExperienceException{
		List<VisaType> result = getJdbcTemplate().query(VISA_TYPE_GET_BY_VISA_TYPE_UUID, new Object[]{uuid}, RowMappers.getVisaTypeRowMapper());
		if(CollectionUtils.isNotEmpty(result)) {
			return result.get(0);
		} else {
			throw new InterviewExperienceException("Invalid uuid");
		}
		
	}

}
