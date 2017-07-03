package com.spring.henallux.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="equivalentcategory")
@NamedQueries({
	@NamedQuery(
			name = "getCategoriesByLanguage",
			query = "from EquivalentCategoryEntity e where e.languageCategoryEquivalent.nameLanguage = :language")
})
public class EquivalentCategoryEntity {
	
	@Id
	@Column(name="idequivalentcategory")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idEquivalentCategory;
	
	@JoinColumn(name="idcategory",referencedColumnName="idcategory")
	@ManyToOne
	private CategoryEntity categoryEquivalent;
	
	@JoinColumn(name="idlanguage",referencedColumnName="idlanguage")
	@ManyToOne
	private LanguageEntity languageCategoryEquivalent;
	
	@Column(name="namecategory")
	private String nameCategory;

	public Integer getIdEquivalentCategory() {
		return idEquivalentCategory;
	}

	public void setIdEquivalentCategory(Integer idEquivalentCategory) {
		this.idEquivalentCategory = idEquivalentCategory;
	}

	public CategoryEntity getCategoryEquivalent() {
		return categoryEquivalent;
	}

	public void setCategoryEquivalent(CategoryEntity categoryEquivalent) {
		this.categoryEquivalent = categoryEquivalent;
	}

	public LanguageEntity getLanguageCategoryEquivalent() {
		return languageCategoryEquivalent;
	}

	public void setLanguageCategoryEquivalent(LanguageEntity languageCategoryEquivalent) {
		this.languageCategoryEquivalent = languageCategoryEquivalent;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	

}
