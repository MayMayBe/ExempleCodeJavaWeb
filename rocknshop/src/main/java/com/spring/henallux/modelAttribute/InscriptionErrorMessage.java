package com.spring.henallux.modelAttribute;

public class InscriptionErrorMessage {

	private String content;
	
	public InscriptionErrorMessage(){

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