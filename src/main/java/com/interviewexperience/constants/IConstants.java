package com.interviewexperience.constants;

public interface IConstants {

	String CREATE_CONSULATE_TABLE = "CREATE TABLE Consulate ( consulate_id VARCHAR (50) PRIMARY KEY, visa_country VARCHAR (200) NOT NULL, consulate_city VARCHAR (200) NOT NULL, consulate_country VARCHAR (200) NOT NULL, created_ts TIMESTAMP NOT NULL)";
	String CONSULATE_INSERT = "INSERT INTO Consulate (consulate_id, visa_country, consulate_city, consulate_country, created_ts) VALUES (?, ?, ?, ?, clock_timestamp())";
	String CONSULATE_GET_BY_ID = "SELECT * FROM Consulate WHERE consulate_id = ?";
	String CONSULATE_GET_ALL = "SELECT * FROM Consulate";
}
