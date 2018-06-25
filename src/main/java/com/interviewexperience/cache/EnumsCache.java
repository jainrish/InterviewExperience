package com.interviewexperience.cache;

import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.interviewexperience.dao.impl.ConsulateDaoImpl;
import com.interviewexperience.dao.impl.VisaTypeDaoImpl;
import com.interviewexperience.model.Consulate;
import com.interviewexperience.model.VisaType;

@Component
public class EnumsCache {

	Map<String, VisaType> visaTypeMap;
	Map<String, Consulate> consulateMap;
	
	@Autowired
	ConsulateDaoImpl consulateDaoImpl;
	
	@Autowired
	VisaTypeDaoImpl visaTypeDaoImpl;
	
	@PostConstruct
	public void initialize() {
		consulateMap = consulateDaoImpl.loadAllConsulates().stream().collect(Collectors.toMap(consulate -> consulate.getConsulateID(), consulate -> consulate));
		visaTypeMap = visaTypeDaoImpl.loadAllVisaTypes().stream().collect(Collectors.toMap(visaType -> visaType.getVisaTypeUUID(), visaType -> visaType));
	}
	
	public Object getEnumsById(String key, Class<?> clazz) {
		if(clazz.isAssignableFrom(VisaType.class)) {
			return visaTypeMap.get(key);
		} else if (clazz.isAssignableFrom(Consulate.class)) {
			return consulateMap.get(key);
		}
		return null;
	}
	
	public Object getAllEnumsByType(Class<?> clazz) {
		if(clazz.isAssignableFrom(VisaType.class)) {
			return visaTypeMap.values();
		} else if (clazz.isAssignableFrom(Consulate.class)) {
			return consulateMap.values();
		}
		return null;
	}
}
