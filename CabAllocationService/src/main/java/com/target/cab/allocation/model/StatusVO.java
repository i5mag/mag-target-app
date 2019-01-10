package com.target.cab.allocation.model;

public class StatusVO {
	
	private String responseStatus;
	
	private String responseCode;
	
	private String error;

	public StatusVO(String responseStatus, String responseCode, String error) {
		super();
		this.responseStatus = responseStatus;
		this.responseCode = responseCode;
		this.error = error;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
