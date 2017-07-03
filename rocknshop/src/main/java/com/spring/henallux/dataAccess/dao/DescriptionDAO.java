package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.henallux.dataAccess.entity.DescriptionEntity;
import com.spring.henallux.dataAccess.repository.DescriptionRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Description;


@Service
@Transactional
public class DescriptionDAO {

	@Autowired
	private DescriptionRepository descriptionRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	
	
	public ArrayList<Description> getAllCharacteristics(){
		List<DescriptionEntity> listEntities = descriptionRepository.findAll();
		ArrayList<Description> result = new ArrayList<>();
		for(DescriptionEntity entity : listEntities){
			Description provider = providerConverter.descriptionEntityToDescriptionModel(entity);
			result.add(provider);
		}
		return result;
	}
}
