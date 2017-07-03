package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.henallux.dataAccess.entity.CategoryEntity;
import com.spring.henallux.dataAccess.repository.CategoryRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Category;


@Service
@Transactional
public class CategoryDAO {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	
	public ArrayList<Category> getAllCategories(){
		List<CategoryEntity> catEntities = categoryRepository.findAll();
		ArrayList<Category> cat = new ArrayList<>();
		for(CategoryEntity entity : catEntities){
			Category catProvider = providerConverter.categoryEntityToCategoryModel(entity);
			cat.add(catProvider);
		}
		return cat;
	}
}
