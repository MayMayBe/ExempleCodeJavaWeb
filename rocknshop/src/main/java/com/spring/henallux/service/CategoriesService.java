package com.spring.henallux.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.dao.EquivalentCategoryDAO;
import com.spring.henallux.model.EquivalentCategory;

@Service
public class CategoriesService {

	@Autowired
	private EquivalentCategoryDAO equivalentCategoryDAO;
	
	public ArrayList<EquivalentCategory> getCategoriesByLanguage(String language){
		return equivalentCategoryDAO.getCategoriesByLanguage(language);
	}
	
}
