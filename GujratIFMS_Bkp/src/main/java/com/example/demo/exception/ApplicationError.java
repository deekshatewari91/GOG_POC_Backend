package com.example.demo.exception;

public class ApplicationError {
	private String code;
	private String message;
	private String severity;

	public ApplicationError() {
	}

	public ApplicationError(String code, String message, String severity) {
		this.code = code;
		this.message = message;
		this.severity = severity;
	
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}



	@Override
	public String toString() {
		return "ApplicationError [code=" + code + ", message=" + message + ", severity=" + severity + "]";
	}
}

