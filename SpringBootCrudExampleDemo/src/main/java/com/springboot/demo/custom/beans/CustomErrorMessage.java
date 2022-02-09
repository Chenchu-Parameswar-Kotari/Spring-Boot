package com.springboot.demo.custom.beans;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;



@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CustomErrorMessage{
	
	private String errorMessage;
	private String errorCode;
	public CustomErrorMessage() {
	}
	public CustomErrorMessage(String errorMessage, String errorCode) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
}
