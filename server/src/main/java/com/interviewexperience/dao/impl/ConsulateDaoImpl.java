package com.interviewexperience.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import static com.interviewexperience.constants.IConstants.*;

import com.interviewexperience.dao.ConsulateDao;
import com.interviewexperience.dao.rowmapper.RowMappers;
import com.interviewexperience.model.Consulate;

@Repository
public class ConsulateDaoImpl extends JdbcDaoSupport implements ConsulateDao{

	@Autowired 
    DataSource dataSource;
 
    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }
	
    /*public void createTable() {
    	getJdbcTemplate().execute(CREATE_CONSULATE_TABLE);
    }*/
    
    public int getCount() {
    	return getJdbcTemplate().queryForList("select count(*) from consulate", Integer.class).get(0);
    }
    
    @Override
    public void insert(Consulate consulate) {
    	if(findConsulateByID(consulate.getConsulateID())==null){
        getJdbcTemplate().update(CONSULATE_INSERT,
        		consulate.getConsulateID(), 
        		consulate.getVisaCountry(), 
        		consulate.getConsulateCity(), 
        		consulate.getConsulateCountry());
    	}
    }

	@Override
	public void insertBatch(List<Consulate> consulates) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Consulate> loadAllConsulates() {
		return getJdbcTemplate().query(CONSULATE_GET_ALL, RowMappers.getConsulateRowMapper());
	}
	
	@Override
	public Consulate findConsulateByID(String consulateID) {
		List<Consulate> consulates = getJdbcTemplate().query(CONSULATE_GET_BY_ID, 
				new Object[]{consulateID}, RowMappers.getConsulateRowMapper());
		if(CollectionUtils.isNotEmpty(consulates)) {
			return consulates.get(0);
		}
		return null;
	}

	@Override
	public List<Consulate> findConsulateByVisaCountry(String visaCountry) {
		// TODO Auto-generated method stub
		return null;
	}
}
