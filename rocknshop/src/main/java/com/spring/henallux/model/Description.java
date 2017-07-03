package com.spring.henallux.model;

import java.util.Collection;



public class Description {
	
	private Integer idDescription;
	private Collection<EquivalentDescription> equivalentDescription;
	private Model model;
	public Integer getIdDescription() {
		return idDescription;
	}
	public void setIdDescription(Integer idDescription) {
		this.idDescription = idDescription;
	}
	public Collection<EquivalentDescription> getEquivalentDescription() {
		return equivalentDescription;
	}
	public void setEquivalentDescription(Collection<EquivalentDescription> equivalentDescription) {
		this.equivalentDescription = equivalentDescription;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	

}
