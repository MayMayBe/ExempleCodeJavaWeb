package com.spring.henallux.dataAccess.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.henallux.dataAccess.entity.CountryEntity;
@Repository
@Transactional
public interface CountryRepository extends JpaRepository<CountryEntity, Integer>{
	
	public CountryEntity findByCountryName(String countryname);
}