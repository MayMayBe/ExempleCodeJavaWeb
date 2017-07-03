package com.spring.henallux.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="equivalentcharacteristic")
public class EquivalentCharacteristicEntity {
	
	@Id
	@Column(name="idequivalentcharacteristic")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idEquivalentCharacteristic;
	
	@JoinColumn(name="idtype",referencedColumnName="idtype")
	@ManyToOne
	private CharacteristicEntity characteristicEquivalent;
	
	@JoinColumn(name="idlanguage",referencedColumnName="idlanguage")
	@ManyToOne
	private LanguageEntity languageCharacteristicEquivalent;
	
	@Column(name="namecharacteristic")
	private String nameCharacteristic;

	public Integer getIdEquivalentCharacteristic() {
		return idEquivalentCharacteristic;
	}

	public void setIdEquivalentCharacteristic(Integer idEquivalentCharacteristic) {
		this.idEquivalentCharacteristic = idEquivalentCharacteristic;
	}

	public CharacteristicEntity getCharacteristicEquivalent() {
		return characteristicEquivalent;
	}

	public void setCharacteristicEquivalent(CharacteristicEntity characteristicEquivalent) {
		this.characteristicEquivalent = characteristicEquivalent;
	}

	public LanguageEntity getLanguageCharacteristicEquivalent() {
		return languageCharacteristicEquivalent;
	}

	public void setLanguageCharacteristicEquivalent(LanguageEntity languageCharacteristicEquivalent) {
		this.languageCharacteristicEquivalent = languageCharacteristicEquivalent;
	}

	public String getNameCharacteristic() {
		return nameCharacteristic;
	}

	public void setNameCharacteristic(String nameCharacteristic) {
		this.nameCharacteristic = nameCharacteristic;
	}
	
	

}
