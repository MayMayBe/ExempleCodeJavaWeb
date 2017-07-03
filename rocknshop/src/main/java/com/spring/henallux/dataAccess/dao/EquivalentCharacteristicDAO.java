package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.henallux.dataAccess.entity.EquivalentCharacteristicEntity;
import com.spring.henallux.dataAccess.repository.EquivalentCharacteristicRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.EquivalentCharacteristic;

@Service
@Transactional
public class EquivalentCharacteristicDAO {

	@Autowired
	private EquivalentCharacteristicRepository equivalentCharacteristicRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	
	public ArrayList<EquivalentCharacteristic> getAllCharacteristics(){
		List<EquivalentCharacteristicEntity> listEntities = equivalentCharacteristicRepository.findAll();
		ArrayList<EquivalentCharacteristic> result = new ArrayList<>();
		for(EquivalentCharacteristicEntity entity : listEntities){
			EquivalentCharacteristic provider = providerConverter.equivalentCharacteristicEntityToEquivalentCharacteristicModel(entity);
			result.add(provider);
		}
		return result;
	}
}

