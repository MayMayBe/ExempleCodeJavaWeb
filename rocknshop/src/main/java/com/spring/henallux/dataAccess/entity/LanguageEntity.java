package com.spring.henallux.dataAccess.entity;


import javax.persistence.*;
@Entity
@Table(name="language")
public class LanguageEntity {
	
	@Id
	@Column(name="idlanguage")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idLanguage;
	
	@Column(name="namelanguage")
	private String nameLanguage;
	

	public Integer getIdLanguage() {
		return idLanguage;
	}

	public void setIdLanguage(Integer idLanguage) {
		this.idLanguage = idLanguage;
	}

	public String getNameLanguage() {
		return nameLanguage;
	}

	public void setNameLanguage(String nameLanguage) {
		this.nameLanguage = nameLanguage;
	}
	
}
