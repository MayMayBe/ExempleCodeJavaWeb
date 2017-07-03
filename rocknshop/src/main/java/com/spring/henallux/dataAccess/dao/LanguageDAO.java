package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.henallux.dataAccess.entity.LanguageEntity;
import com.spring.henallux.dataAccess.repository.LanguageRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Language;

@Service
@Transactional
public class LanguageDAO {

	@Autowired
	private LanguageRepository languageRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	
	public ArrayList<Language> getAllCharacteristics(){
		List<LanguageEntity> listEntities = languageRepository.findAll();
		ArrayList<Language> result = new ArrayList<>();
		for(LanguageEntity entity : listEntities){
			Language provider = providerConverter.equivalentLanguageEntityToLanguageModel(entity);
			result.add(provider);
		}
		return result;
	}
}
