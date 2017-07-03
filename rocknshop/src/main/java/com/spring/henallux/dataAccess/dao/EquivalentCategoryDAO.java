package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.henallux.dataAccess.entity.EquivalentCategoryEntity;
import com.spring.henallux.dataAccess.repository.EquivalentCategoryRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.EquivalentCategory;

@Service
@Transactional
public class EquivalentCategoryDAO {

	@Autowired
	private EquivalentCategoryRepository equivalentCategoryRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public ArrayList<EquivalentCategory> getAllCharacteristics(){
		List<EquivalentCategoryEntity> listEntities = equivalentCategoryRepository.findAll();
		ArrayList<EquivalentCategory> result = new ArrayList<>();
		for(EquivalentCategoryEntity entity : listEntities){
			EquivalentCategory provider = providerConverter.equivalentCategoryEntityToEquivalentCategoryModel(entity);
			result.add(provider);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<EquivalentCategory> getCategoriesByLanguage(String locale){
		Session session = sessionFactory.openSession();
		Query query = session.getNamedQuery("getCategoriesByLanguage").setString("language", locale);
		List<EquivalentCategoryEntity> equivalentEntities = query.list();
		ArrayList<EquivalentCategory> categories = new ArrayList<>();
		for(EquivalentCategoryEntity entities : equivalentEntities){
			EquivalentCategory equivalent = providerConverter.equivalentCategoryEntityToEquivalentCategoryModel(entities);
			categories.add(equivalent);
		}
		session.close();
		return categories;
	}
}