package com.spring.henallux.model;

import java.util.Collection;


public class Characteristic {

	private Integer idType;
	private Collection<EquivalentCharacteristic> equivalentcharacteristics;
	private Collection<Model> models;
	public Integer getIdType() {
		return idType;
	}
	public void setIdType(Integer idType) {
		this.idType = idType;
	}
	public Collection<EquivalentCharacteristic> getEquivalentcharacteristics() {
		return equivalentcharacteristics;
	}
	public void setEquivalentcharacteristics(Collection<EquivalentCharacteristic> equivalentcharacteristics) {
		this.equivalentcharacteristics = equivalentcharacteristics;
	}
	public Collection<Model> getModels() {
		return models;
	}
	public void setModels(Collection<Model> models) {
		this.models = models;
	}
	
	
	

}
