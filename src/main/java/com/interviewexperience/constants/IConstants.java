package com.interviewexperience.constants;

public interface IConstants {

	String CREATE_CONSULATE_TABLE = "CREATE TABLE Consulate ( consulate_id VARCHAR (50) PRIMARY KEY, visa_country VARCHAR (200) NOT NULL, consulate_city VARCHAR (200) NOT NULL, consulate_country VARCHAR (200) NOT NULL, created_ts TIMESTAMP NOT NULL)";
	String CONSULATE_INSERT = "INSERT INTO Consulate (consulate_id, visa_country, consulate_city, consulate_country, created_ts) VALUES (?, ?, ?, ?, clock_timestamp())";
	String CONSULATE_GET_BY_ID = "SELECT * FROM Consulate WHERE consulate_id = ?";
	String CONSULATE_GET_ALL = "SELECT * FROM Consulate";
	
	String CREATE_VISA_TYPE_TABLE = "CREATE TABLE VisaType ( visa_type_uuid VARCHAR(40) PRIMARY KEY, country_code CHAR (3) NOT NULL, visa_code VARCHAR (20) NOT NULL, visa_description VARCHAR (200), created_ts TIMESTAMP NOT NULL)";
	String VISA_TYPE_INSERT = "INSERT INTO VisaType (visa_type_uuid, country_code, visa_code, visa_description, created_ts) VALUES (?, ?, ?, ?, clock_timestamp())";
	String VISA_TYPE_GET_BY_COUNTRY_CODE = "SELECT * FROM VisaType WHERE country_code = ?";
	String VISA_TYPE_GET_BY_VISA_TYPE_UUID = "SELECT * FROM VisaType WHERE visa_type_uuid = ?";
	String VISA_TYPE_GET_ALL = "SELECT * FROM VisaType";
}
