package com.spring.henallux.modelAttribute;

public class LoginErrorMessage {

	private String content;
	
	public LoginErrorMessage(){

	}
	
	public String getContent(){
		return content;
	}
	
	public void setContent(String s){
		content = s;
	}
	
	public void appendContent(String s){
		content += s;
	}
}
