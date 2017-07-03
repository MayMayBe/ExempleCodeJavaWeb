package com.spring.henallux.dataAccess.entity;

import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="musicalcharacteristic")
public class CharacteristicEntity {

	@Id
	@Column(name="idtype")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idType;
	
	@OneToMany(mappedBy="characteristicEquivalent", fetch = FetchType.LAZY)
	private Collection<EquivalentCharacteristicEntity> equivalentcharacteristics;
	
	@OneToMany(mappedBy="type", fetch = FetchType.LAZY)
	private Collection<ModelEntity> models;

	public Integer getIdType() {
		return idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	public Collection<EquivalentCharacteristicEntity> getEquivalentcharacteristics() {
		return equivalentcharacteristics;
	}

	public void setEquivalentcharacteristics(Collection<EquivalentCharacteristicEntity> equivalentcharacteristics) {
		this.equivalentcharacteristics = equivalentcharacteristics;
	}

	public Collection<ModelEntity> getModels() {
		return models;
	}

	public void setModels(Collection<ModelEntity> models) {
		this.models = models;
	}

	
	
	
}
