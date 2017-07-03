package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.henallux.dataAccess.entity.CharacteristicEntity;
import com.spring.henallux.dataAccess.repository.CharacteristicRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Characteristic;


@Service
@Transactional
public class CharacteristicDAO {

	@Autowired
	private CharacteristicRepository characteristicRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	
	
	public ArrayList<Characteristic> getAllCharacteristics(){
		List<CharacteristicEntity> listEntities = characteristicRepository.findAll();
		ArrayList<Characteristic> result = new ArrayList<>();
		for(CharacteristicEntity entity : listEntities){
			Characteristic provider = providerConverter.characteristicEntityToCharacteristicModel(entity);
			result.add(provider);
		}
		return result;
	}
}

