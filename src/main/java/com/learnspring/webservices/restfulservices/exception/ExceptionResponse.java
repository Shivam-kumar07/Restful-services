package com.learnspring.webservices.restfulservices.exception;

import java.util.Date;

public class ExceptionResponse {
	private Date datestamp;
	private String message;
	private String details;
	public ExceptionResponse(Date datestamp, String message, String details) {
		super();
		this.datestamp = datestamp;
		this.message = message;
		this.details = details;
	}
	public Date getDatestamp() {
		return datestamp;
	}
	public void setDatestamp(Date datestamp) {
		this.datestamp = datestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	

}
