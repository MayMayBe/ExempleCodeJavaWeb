package com.spring.henallux.modelAttribute;

public class ProcessCommand {

	private Boolean inPayment;
	private Boolean commandSuccess;
	
	public ProcessCommand(){
		this.inPayment = true;
		this.commandSuccess = false;
	}

	public Boolean getInPayment() {
		return inPayment;
	}

	public void setInPayment(Boolean inPayment) {
		this.inPayment = inPayment;
	}

	public Boolean getCommandSuccess() {
		return commandSuccess;
	}

	public void setCommandSuccess(Boolean commandSuccess) {
		this.commandSuccess = commandSuccess;
	}
	
	
	
	
}
