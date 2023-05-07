package com.spring.model;

public class ErrorModel {
	private String errorMesssage;

	public ErrorModel(String errorMessage) {
		this.setErrorMesssage(errorMessage);
	}

	public String getErrorMesssage() {
		return this.errorMesssage;
	}

	public void setErrorMesssage(String errorMesssage) {
		this.errorMesssage = errorMesssage;
	}

}
