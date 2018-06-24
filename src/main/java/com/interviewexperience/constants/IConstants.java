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
	
	String CREATE_COUNTRY_TABLE = "CREATE TABLE Country ( country_name VARCHAR(60) NOT NULL, iso_2_code CHAR (2) NOT NULL, iso_3_code CHAR (3) PRIMARY KEY, un_number smallint NOT NULL, dialing_code varchar(20) NOT NULL, created_ts TIMESTAMP NOT NULL, CONSTRAINT ISO_2 UNIQUE(iso_2_code), CONSTRAINT ISO_3 UNIQUE(iso_3_code))";
	String COUNTRY_INSERT = "INSERT INTO Country (country_name, iso_2_code, iso_3_code, un_number, dialing_code, created_ts) VALUES (?, ?, ?, ?, ?, clock_timestamp())";
	String COUNTRY_GET_BY_NAME = "SELECT * FROM Country where country_name = ?";
	String COUNTRY_GET_BY_ISO_2_CODE = "SELECT * from Country where iso_2_code = ?";
	String COUNTRY_GET_BY_ISO_3_CODE = "SELECT * from Country where iso_3_code = ?";
	String COUNTRY_GET_ALL = "SELECT * FROM Country";
}
