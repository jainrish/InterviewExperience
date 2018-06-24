package com.interviewexperience.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import org.apache.cxf.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.interviewexperience.dao.impl.VisaTypeDaoImpl;


@RestController
@Produces("application/json")
@Consumes("application/json")
public class VisaTypeController {

	@Autowired
	VisaTypeDaoImpl visaTypeDaoImpl;
	
	@GET
	@RequestMapping("/visaTypes")
	public ResponseEntity<Object> getAVisaTypes(@RequestParam(value = "countryCode", required = false) String countryCode){
		if(StringUtils.isEmpty(countryCode)) {
			return ResponseEntity.ok(visaTypeDaoImpl.loadAllVisaTypes());
		} else {
			return ResponseEntity.ok(visaTypeDaoImpl.findVisaTypeByCountryCode(countryCode));
		}
	}
	
}
