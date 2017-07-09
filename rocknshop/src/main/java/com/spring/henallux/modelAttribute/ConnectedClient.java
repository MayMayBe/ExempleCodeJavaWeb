package com.spring.henallux.modelAttribute;

public class ConnectedClient {
	private Boolean connected;
	
	public ConnectedClient(){
		connected = false;
	}

	public Boolean isConnected() {
		return connected;
	}
	
	public Boolean getConnected(){
		return connected;
	}

	public void setConnected(Boolean connected) {
		this.connected = connected;
	}
	
	
}
