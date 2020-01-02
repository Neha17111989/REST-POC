package com.altimetrik.controller;

public class HelloWorldBean {

	private String message;

	public HelloWorldBean(String string) {
		message=string;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
