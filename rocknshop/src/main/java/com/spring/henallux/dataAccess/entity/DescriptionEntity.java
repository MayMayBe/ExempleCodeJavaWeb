package com.spring.henallux.dataAccess.entity;


import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="description")
public class DescriptionEntity {

	@Id
	@Column(name="iddescription")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idDescription;
	
	@OneToMany(mappedBy="descriptionEquivalent", fetch = FetchType.LAZY)
	private Collection<EquivalentDescriptionEntity> equivalentDescription;
	
	@OneToOne(mappedBy = "description",cascade = CascadeType.ALL, orphanRemoval = true)
	private ModelEntity model;

	public Integer getIdDescription() {
		return idDescription;
	}

	public void setIdDescription(Integer idDescription) {
		this.idDescription = idDescription;
	}

	public Collection<EquivalentDescriptionEntity> getEquivalentDescription() {
		return equivalentDescription;
	}

	public void setEquivalentDescription(Collection<EquivalentDescriptionEntity> equivalentDescription) {
		this.equivalentDescription = equivalentDescription;
	}

	public ModelEntity getModel() {
		return model;
	}

	public void setModel(ModelEntity model) {
		this.model = model;
	}

	
	



}
