package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.henallux.dataAccess.entity.CountryEntity;
import com.spring.henallux.dataAccess.repository.CountryRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Country;

@Service
@Transactional
public class CountryDAO {

	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	public Country save(Country country){
		CountryEntity countryEntity = providerConverter.countryModeltoCountryEntity(country);
		countryEntity = countryRepository.save(countryEntity);
		return providerConverter.countryEntityToCountryModel(countryEntity);
	}
	
	public ArrayList<Country> getAllCountries(){
		List<CountryEntity> countryEntities = countryRepository.findAll();
		ArrayList<Country> countries = new ArrayList<>();
		for(CountryEntity entity : countryEntities){
			Country country = providerConverter.countryEntityToCountryModel(entity);
			countries.add(country);
		}
		return countries;
	}
	
	public Country findByName(String countryName){
		CountryEntity country = countryRepository.findByCountryName(countryName);
		if(country == null) return null;
		return providerConverter.countryEntityToCountryModel(country);
	}
}
