package com.spring.henallux.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="equivalentdescription")
@NamedQueries({
	@NamedQuery(
		name = "findDescriptionByModelAndLanguage",
		query = "select e"+
				" from EquivalentDescriptionEntity e, DescriptionEntity d, ModelEntity m, LanguageEntity l"+
				" where e.descriptionEquivalent = d"+
				" and m.description = d"+
				" and e.languageDescriptionEquivalent = l"+
				" and m.idModel = :modelID and l.nameLanguage = :languageName"
	)
})

public class EquivalentDescriptionEntity {
	
	@Id
	@Column(name="idequivalentdescription")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idEquivalentDescription;
	
	@JoinColumn(name="iddescription",referencedColumnName="iddescription")
	@ManyToOne
	private DescriptionEntity descriptionEquivalent;
	
	@JoinColumn(name="idlanguage",referencedColumnName="idlanguage")
	@ManyToOne
	private LanguageEntity languageDescriptionEquivalent;
	
	@Column(name="description")
	private String description;

	public Integer getIdEquivalentDescription() {
		return idEquivalentDescription;
	}

	public void setIdEquivalentDescription(Integer idEquivalentDescription) {
		this.idEquivalentDescription = idEquivalentDescription;
	}

	public DescriptionEntity getDescriptionEquivalent() {
		return descriptionEquivalent;
	}

	public void setDescriptionEquivalent(DescriptionEntity descriptionEquivalent) {
		this.descriptionEquivalent = descriptionEquivalent;
	}

	public LanguageEntity getLanguageDescriptionEquivalent() {
		return languageDescriptionEquivalent;
	}

	public void setLanguageDescriptionEquivalent(LanguageEntity languageDescriptionEquivalent) {
		this.languageDescriptionEquivalent = languageDescriptionEquivalent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
