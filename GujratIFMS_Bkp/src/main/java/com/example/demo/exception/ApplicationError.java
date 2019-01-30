package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ApplicationError {
	private HttpStatus httpCode;
	private Date timestamp;
	private String description;
	private String severity;

	public ApplicationError() {
	}

	public ApplicationError(HttpStatus httpCode, Date timestamp, String description, String severity) {
		this.httpCode = httpCode;
		this.timestamp = timestamp;
		this.description = description;
		this.severity = severity;
	}


	public String getMessage() {
		return description;
	}

	public void setMessage(String description) {
		this.description = description;
	}

	public HttpStatus getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(HttpStatus httpCode) {
		this.httpCode = httpCode;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	@Override
	public String toString() {
		return "ApplicationError [httpCode=" + httpCode + ", description=" + description + ", severity=" + severity + "]";
	}
}

