package com.springboot.demo.custom.beans;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CustomSucessMessage {
	private String sucessMessage;
	private String sucessCode;
	public CustomSucessMessage() {
		
	}
	public CustomSucessMessage(String sucessMessage, String sucessCode) {
		super();
		this.sucessMessage = sucessMessage;
		this.sucessCode = sucessCode;
	}
	public String getSucessMessage() {
		return sucessMessage;
	}
	public void setSucessMessage(String sucessMessage) {
		this.sucessMessage = sucessMessage;
	}
	public String getSucessCode() {
		return sucessCode;
	}
	public void setSucessCode(String sucessCode) {
		this.sucessCode = sucessCode;
	}
}
