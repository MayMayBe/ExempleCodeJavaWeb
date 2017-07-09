package com.spring.henallux.modelAttribute;

public class ExecutedSearch {

	private boolean hasExecutedSearch;
	
	public ExecutedSearch(){
		hasExecutedSearch = false;
	}
	
	public boolean hasExecutedSearch(){
		return hasExecutedSearch;
	}
	
	public void setExecutedSearch(boolean bool){
		hasExecutedSearch = bool;
	}
}
