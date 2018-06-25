package com.interviewexperience.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import org.apache.cxf.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.interviewexperience.cache.EnumsCache;
import com.interviewexperience.dao.impl.ConsulateDaoImpl;
import com.interviewexperience.dao.impl.CountryDaoImpl;
import com.interviewexperience.dao.impl.VisaTypeDaoImpl;
import com.interviewexperience.model.Consulate;
import com.interviewexperience.model.VisaType;



@RestController
@Produces("application/json")
@Consumes("application/json")
@RequestMapping("/enums")
public class EnumController {

	@Autowired
	VisaTypeDaoImpl visaTypeDaoImpl;
	
	@Autowired
	CountryDaoImpl countryDaoImpl;
	
	@Autowired
	ConsulateDaoImpl consulateDaoImpl;
	
	@Autowired
	EnumsCache enumsCache;
	
	@GET
	@RequestMapping("/consulate/{consulateID}")
	public ResponseEntity<Object> getConsulateByID(@PathVariable("consulateID") String consulateID) {
		return ResponseEntity.ok(consulateDaoImpl.findConsulateByID(consulateID));
	}
	
	@GET
	@RequestMapping("/consulates")
	public ResponseEntity<Object> getConsulates() {
		return ResponseEntity.ok(enumsCache.getAllEnumsByType(Consulate.class));
	}
	
	@GET
	@RequestMapping("/visaTypes")
	public ResponseEntity<Object> getVisaTypes(@RequestParam(value = "countryCode", required = false) String countryCode){
		
		if(StringUtils.isEmpty(countryCode)) {
			return ResponseEntity.ok(enumsCache.getAllEnumsByType(VisaType.class));
		} else {
			return ResponseEntity.ok(visaTypeDaoImpl.findVisaTypeByCountryCode(countryCode));
		}
	}
	
	@GET
	@RequestMapping("/countries")
	public ResponseEntity<Object> getCountries(){
		return ResponseEntity.ok(countryDaoImpl.loadAllCountries());
	}
	
	@GET
	@RequestMapping("/countries/country/iso2code/{iso2code}")
	public ResponseEntity<Object> getCountryByIso2Code(@PathVariable("iso2code") String iso2Code){
		try {
			return ResponseEntity.ok(countryDaoImpl.findCountryByISO2Code(iso2Code));
		} catch (Exception e) {
			return ResponseEntity.ok("No country found");
		}
		
	}
	
	@GET
	@RequestMapping("/countries/country/iso3code/{iso3code}")
	public ResponseEntity<Object> getCountryByIso3Code(@PathVariable("iso3code") String iso3Code){
		try {
			return ResponseEntity.ok(countryDaoImpl.findCountryByISO3Code(iso3Code));
		} catch (Exception e) {
			return ResponseEntity.ok("No country found");
		}
	}
	
	@GET
	@RequestMapping("/countries/country/countryName/{countryName}")
	public ResponseEntity<Object> getCountryByName(@PathVariable("countryName") String countryName){	
		try {
			return ResponseEntity.ok(countryDaoImpl.findCountryByCountryName(countryName));
		} catch (Exception e) {
			return ResponseEntity.ok("No country found");
		}
	}
	
}
